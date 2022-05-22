package com.example.androidunittesting.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user:User):Long
    @Query("SELECT * FROM users")
    suspend fun listUsers():List<User>
}