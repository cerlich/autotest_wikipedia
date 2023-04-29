package org.wikipedia.fintechTests.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.wikipedia.R

class MainScreen {
    private val menuButton = ViewMatchers.withId(R.id.nav_more_container)
    private val settingButton = ViewMatchers.withId(R.id.main_drawer_settings_container)
    private val account = ViewMatchers.withId(R.id.main_drawer_account_container)

    fun clickLogIn(){
        Espresso.onView(account)
                .perform(ViewActions.click())
    }

    fun clickMenu(){
        Espresso.onView(menuButton)
                .perform(ViewActions.click())
    }

    fun clickSettings(){
        Espresso.onView(settingButton)
                .perform(ViewActions.click())
    }
}