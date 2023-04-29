package org.wikipedia.fintechTests

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.fintechTests.screens.CreateAccountScreen
import org.wikipedia.fintechTests.screens.MainScreen
import org.wikipedia.main.MainActivity

class TestValidationPassword {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun skipOnboarding() {
        val skip = ViewMatchers.withId(R.id.fragment_onboarding_skip_button)
        Espresso.onView(skip)
                .perform(ViewActions.click())
    }

    @Test
    fun testFifthCase(){
        val mainScreen = MainScreen()
        val account = CreateAccountScreen()

        with(mainScreen){
            clickMenu()
            clickLogIn()
        }

        with(account){
            typeTextToUsernameField("cerlich")
            typeTextToPasswordField("pass")
            typeTextToPasswordRepeatField("pass")
            clickNext()
            checkColorPassword()
            checkError()
        }
    }
}