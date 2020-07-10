package com.zg.burgerjoint.uitests.burgerlist.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.EN_LOGIN_FAIL_ERROR_MESSAGE
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.LoginActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFailTest {
    private val activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun enterNoInformation(){
        onView(withId(R.id.etUserName)).perform(
            typeText(""), closeSoftKeyboard()
        )

        onView(withId(R.id.etPassword)).perform(
            typeText(""), closeSoftKeyboard()
        )

        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(withText(
            EN_LOGIN_FAIL_ERROR_MESSAGE)))
    }
}