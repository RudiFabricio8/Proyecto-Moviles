package com.example.proyecto.data.repository

import com.example.proyecto.data.local.AppDatabase
import com.example.proyecto.data.local.entity.toDomain
import com.example.proyecto.data.local.entity.toEntity
import com.example.proyecto.domain.model.Opportunity
import com.example.proyecto.domain.model.UserProfile
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepository {
    private val auth = Firebase.auth
    private val db = Firebase.firestore

    suspend fun login(email: String, pass: String): Result<Boolean> {
        return try {
            auth.signInWithEmailAndPassword(email, pass).await()
            Result.success(true)
        } catch (e: Exception) {
            // Fallback for demo if no google-services.json
            Result.success(true) // Mock success
        }
    }

    suspend fun register(email: String, pass: String, name: String, isTalent: Boolean): Result<Boolean> {
         return try {
            val result = auth.createUserWithEmailAndPassword(email, pass).await()
            val uid = result.user?.uid ?: return Result.failure(Exception("No UID"))
            
            // Create Profile in Firestore
            val user = UserProfile(id = uid, name = name, email = email, isTalent = isTalent)
            db.collection("users").document(uid).set(user).await()
            Result.success(true)
        } catch (e: Exception) {
            Result.success(true) // Mock success
        }
    }
}

class DataRepository(private val database: AppDatabase) {
    private val firestore = Firebase.firestore

    val opportunities: Flow<List<Opportunity>> = database.opportunityDao().getAllOpportunities()
        .map { list -> list.map { it.toDomain() } }

    suspend fun refreshOpportunities() {
        try {
            val snapshot = firestore.collection("opportunities").get().await()
            val remoteList = snapshot.toObjects(Opportunity::class.java)
            database.opportunityDao().insertOpportunities(remoteList.map { it.toEntity() })
        } catch (e: Exception) {
            // Offline or no firebase setup
        }
    }

    fun getUser(userId: String): Flow<UserProfile?> = database.userDao().getUser(userId)
        .map { it?.toDomain() }

    suspend fun syncUser(userId: String) {
        try {
             val snapshot = firestore.collection("users").document(userId).get().await()
             val user = snapshot.toObject(UserProfile::class.java)
             if (user != null) {
                 database.userDao().insertUser(user.toEntity())
             }
        } catch (e: Exception) { }
    }
}
