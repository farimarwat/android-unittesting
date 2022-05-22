package com.example.androidunittesting.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserValidatorTest {

    @Test
    fun whenusernameorpasswordempty_returnfalse(){
        val username = ""
        val password = ""
        val result = UserValidator.validateuserdata(username,password)
        assertThat(result).isFalse()
    }
    @Test
    fun whenUsernameAndPasswordNotEmpty_returnTrue(){
        val username = "Aslam"
        val password = "123456"
        val result = UserValidator.validateuserdata(username,password)
        assertThat(result).isTrue()
    }

}