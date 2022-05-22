package com.example.androidunittesting.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class DatabaseHelper: RoomDatabase() {
    abstract fun getUserDao():UserDao
}