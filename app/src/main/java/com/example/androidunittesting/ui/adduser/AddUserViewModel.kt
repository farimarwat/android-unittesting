package com.example.androidunittesting.ui.adduser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidunittesting.data.DatabaseHelper
import com.example.androidunittesting.data.User
import com.example.androidunittesting.data.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor (
    val mUserDao:UserDao
        ) : ViewModel() {
    val isUserAdded by lazy { MutableStateFlow(false) }
    val mList = MutableLiveData<List<User>>()
    fun addUser(user:User) = viewModelScope.launch(Dispatchers.IO) {
        val result = mUserDao.insert(user)
        if(result > 0){
            isUserAdded.value = true
        }
    }
    fun listUsers() = viewModelScope.launch(Dispatchers.IO) {
        val list = mUserDao.listUsers()
        mList.postValue(list)
    }
}