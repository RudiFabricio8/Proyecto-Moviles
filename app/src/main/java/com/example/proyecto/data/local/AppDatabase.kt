package com.example.proyecto.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto.data.local.dao.OpportunityDao
import com.example.proyecto.data.local.dao.UserDao
import com.example.proyecto.data.local.entity.OpportunityEntity
import com.example.proyecto.data.local.entity.UserEntity

@Database(entities = [UserEntity::class, OpportunityEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun opportunityDao(): OpportunityDao
}
