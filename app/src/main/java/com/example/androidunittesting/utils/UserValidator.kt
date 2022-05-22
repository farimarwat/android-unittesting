package com.example.androidunittesting.utils

object UserValidator {
    fun validateuserdata(username:String,password:String):Boolean{
        if(username.isEmpty() || password.isEmpty()){
            return false
        }
        return true
    }
}