package com.example.androidunittesting.ui.adduser

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.androidunittesting.data.DatabaseHelper
import com.example.androidunittesting.data.User
import com.example.androidunittesting.data.UserDao
import com.example.androidunittesting.ui.main.MainViewModel
import com.example.spendtracker.utils.getOrAwaitValue
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddUserViewModelTest {
    lateinit var mDatabase: DatabaseHelper
    lateinit var mUserDao: UserDao
    lateinit var addUserViewModel: AddUserViewModel
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        mDatabase = Room.inMemoryDatabaseBuilder(context, DatabaseHelper::class.java)
            .allowMainThreadQueries()
            .build()
        mUserDao = mDatabase.getUserDao()
        addUserViewModel = AddUserViewModel(mUserDao)
    }

    @After
    fun tearDown() {
        mDatabase.close()
    }

    @Test
    fun userlist_mustcontainthenewaddedobject() = runBlocking{
        val user = User("Aslam","12345")
        addUserViewModel.addUser(user)
        addUserViewModel.listUsers()
        val result = addUserViewModel.mList.getOrAwaitValue().find {
            it.username == user.username
        }
        Truth.assertThat(result != null).isTrue()
    }
}