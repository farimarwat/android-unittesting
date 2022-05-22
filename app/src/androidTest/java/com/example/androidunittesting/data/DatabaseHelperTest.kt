package com.example.androidunittesting.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class DatabaseHelperTest {
    lateinit var mDatabase:DatabaseHelper
    lateinit var mUserDao: UserDao
    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        mDatabase = Room.inMemoryDatabaseBuilder(context,DatabaseHelper::class.java)
            .allowMainThreadQueries()
            .build()
        mUserDao = mDatabase.getUserDao()
    }

    @After
    fun tearDown() {
        mDatabase.close()
    }

    @Test
    fun addingUserSuccessfully_mustReturnTrue() = runBlocking{
        val user = User("Ajman","asdfghjkl")
        val result = mUserDao.insert(user)
        Truth.assertThat(result > 0).isTrue()
    }
}