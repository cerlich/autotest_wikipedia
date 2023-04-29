package org.wikipedia.fintechTests.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R

class SettingScreen {
    private val castomFeed = withText(R.string.preference_title_customize_explore_feed)
    private val aboutWiki = withText(R.string.about_description)
    private val privacyPolicy = withText(R.string.privacy_policy_description)

    fun scrollSettings() {
        onView(ViewMatchers.withId(R.id.recycler_view))
                .perform(ViewActions.swipeUp());
    }

    fun clickCastomFeed(){
        onView(castomFeed)
                .perform(click())
    }

    fun clickAboutWiki(){
        onView(aboutWiki)
                .perform(click())
    }

    fun clickPrivacyPolicy(){
        onView(privacyPolicy)
                .perform(click())
    }
}