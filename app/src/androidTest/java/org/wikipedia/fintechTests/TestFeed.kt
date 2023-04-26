package org.wikipedia.fintechTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.Before
import org.wikipedia.main.MainActivity
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R
import org.wikipedia.fintechTests.screens.SettingScreen

class TestFeed {
        @get:Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)

        @Before
        fun skipOnboarding() {
            val skip = withId(R.id.fragment_onboarding_skip_button)
            onView(skip)
                .perform(click())
        }

        @Test
        fun testFirstCase() {
            val settingScreen = SettingScreen()
            with(settingScreen) {
                clickMenu()
                clickSettings()
                clickCastomFeed()
                checkAllCheckboxes()
            }
        }

}