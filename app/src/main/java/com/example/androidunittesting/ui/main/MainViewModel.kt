package com.example.androidunittesting.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidunittesting.data.User
import com.example.androidunittesting.data.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    val mUserDao:UserDao
        ): ViewModel() {
            val mUerList by lazy { MutableLiveData<List<User>>(null) }
    fun listUsers() = viewModelScope.launch(Dispatchers.IO) {
        val list = mUserDao.listUsers()
        mUerList.postValue(list)
    }

}