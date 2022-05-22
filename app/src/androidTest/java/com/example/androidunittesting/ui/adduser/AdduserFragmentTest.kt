package com.example.androidunittesting.ui.adduser

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.androidunittesting.R
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.AndroidEntryPoint

import org.junit.After
import org.junit.Before
import org.junit.Test

class AdduserFragmentTest {
    lateinit var scenario: FragmentScenario<AdduserFragment>
    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_AndroidUnitTesting)
        scenario.moveToState(Lifecycle.State.STARTED)
    }
    @Test
    fun testAddUserFragment(){
        onView(withId(R.id.edt_username)).perform(typeText("Afzaal Khan"))
        onView(withId(R.id.edt_password)).perform(typeText("Afzaal Khan"))
        onView(withId(R.id.btn_createuser)).perform(click())
        assertThat(onView(withId(R.id.txt_status)).check(matches(withText("User Added Successfully"))))
    }
}