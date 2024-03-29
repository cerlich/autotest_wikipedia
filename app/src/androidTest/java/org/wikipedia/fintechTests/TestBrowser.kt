package org.wikipedia.fintechTests

import android.net.Uri
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.matcher.IntentMatchers.anyIntent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.core.AnyOf.anyOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.fintechTests.screens.MainScreen
import org.wikipedia.fintechTests.screens.SettingScreen
import org.wikipedia.main.MainActivity

class TestBrowser {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun skipOnboarding() {
        val skip = ViewMatchers.withId(R.id.fragment_onboarding_skip_button)
        Espresso.onView(skip)
                .perform(ViewActions.click())
    }
    @Test
    fun testThirdCase(){
        val settingScreen = SettingScreen()
        val mainScreen = MainScreen()

        with(mainScreen) {
            clickMenu()
            clickSettings()
        }

        with(settingScreen) {
            scrollSettings()
            clickPrivacyPolicy()
        }

        anyIntent().matches(anyOf( hasData(Uri.parse("https://meta.m.wikimedia.org/wiki/Privacy_policy")),
                        hasData(Uri.parse("www.google.com"))))
    }
}