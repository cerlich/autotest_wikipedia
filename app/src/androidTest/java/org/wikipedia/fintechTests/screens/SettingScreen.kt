package org.wikipedia.fintechTests.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.actionWithAssertions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R


class SettingScreen {

    private val menuButton = withId(R.id.nav_more_container)
    private val settingButton = withId(R.id.main_drawer_settings_container)
    private val castomFeed = withText(R.string.preference_title_customize_explore_feed)
    private val aboutWiki = withText(R.string.about_description)
    private val privacyPolicy = withText(R.string.privacy_policy_description)
    private val account = withId(R.id.main_drawer_account_container)

    fun clickLogIn(){
        onView(account)
                .perform(click())
    }

    fun clickMenu(){
        onView(menuButton)
                .perform(click())
    }

    fun clickSettings(){
        onView(settingButton)
                .perform(click())
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

    private fun checkbox(text: Int) {
        onView(allOf(hasSibling(withChild(
                withText(text))),
                    withId(R.id.feed_content_type_checkbox)))
                .check(matches(isChecked()))
    }

     fun scroll(id : Int) {
        onView(withId(id))
                .perform(ViewActions.swipeUp());
    }

    fun checkAllCheckboxes(){
        checkbox(R.string.view_featured_article_card_title)
        checkbox(R.string.view_featured_image_card_title)
        checkbox(R.string.view_card_news_title)
        checkbox(R.string.view_top_read_card_title)
        checkbox(R.string.view_because_you_read_card_title)
        checkbox(R.string.on_this_day_card_title)
        scroll(R.id.content_types_recycler)
        checkbox(R.string.view_random_card_title)
        checkbox(R.string.view_main_page_card_title)
    }
}