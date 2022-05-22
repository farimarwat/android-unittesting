package com.example.androidunittesting

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.common.truth.Truth.assertThat

import org.junit.Before
import org.junit.Test

class MainActivityTest {
    lateinit var scenario:ActivityScenario<MainActivity>
    @Before
    fun setUp() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun addMainActivity(){
        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.edt_username)).perform(ViewActions.typeText("Afzaal Khan"))
        onView(withId(R.id.edt_password)).perform(ViewActions.typeText("123456"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_createuser)).perform(click())
        assertThat(
            onView(withId(R.id.txt_status)).check(
                ViewAssertions.matches(
                    ViewMatchers.withText(
                        "User Added Successfully"
                    )
                )
            )
        )
    }
}