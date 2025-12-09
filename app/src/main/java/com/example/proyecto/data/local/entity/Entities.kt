package com.example.proyecto.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.proyecto.domain.model.Opportunity
import com.example.proyecto.domain.model.UserProfile

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val isTalent: Boolean,
    val photoUrl: String?,
    val description: String?
)

fun UserEntity.toDomain() = UserProfile(id, name, email, isTalent, photoUrl, description)
fun UserProfile.toEntity() = UserEntity(id, name, email, isTalent, photoUrl, description)

@Entity(tableName = "opportunities")
data class OpportunityEntity(
    @PrimaryKey val id: String,
    val title: String,
    val company: String,
    val status: String,
    val datePosted: String
)

fun OpportunityEntity.toDomain() = Opportunity(id, title, company, status, datePosted)
fun Opportunity.toEntity() = OpportunityEntity(id, title, company, status, datePosted)
