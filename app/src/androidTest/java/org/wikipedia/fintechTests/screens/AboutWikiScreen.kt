package org.wikipedia.fintechTests.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R

class AboutWikiScreen {

    private val authorsHeading = withText(R.string.about_contributors_heading)
    private val authorsBlock = withId(R.id.about_contributors)
    private val translatorHeading = withText(R.string.about_translators_heading)
    private val translatorsBlock = withId(R.id.about_translators)
    private val licenseHeading = withText(R.string.about_app_license_heading)
    private val licenseBlock = withId(R.id.about_app_license)

    fun isDisplayedAuthors(){
        onView(authorsHeading).check(matches(isDisplayed()))
        onView(authorsBlock).check(matches(isDisplayed()))
    }

    fun isDisplayedTranslators(){
        onView(translatorHeading).check(matches(isDisplayed()))
        onView(translatorsBlock).check(matches(isDisplayed()))
    }

    fun isDisplayedLicense(){
        onView(licenseHeading).check(matches(isDisplayed()))
        onView(licenseBlock).check(matches(isDisplayed()))
    }
}