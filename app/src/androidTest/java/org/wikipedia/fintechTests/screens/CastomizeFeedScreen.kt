package org.wikipedia.fintechTests.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers
import org.wikipedia.R

class CastomizeFeedScreen {

    private val article = R.string.view_featured_article_card_title
    private val image = R.string.view_featured_image_card_title
    private val news = R.string.view_card_news_title
    private val topRead = R.string.view_top_read_card_title
    private val recommend = R.string.view_because_you_read_card_title
    private val thisDay = R.string.on_this_day_card_title
    private val random = R.string.view_random_card_title
    private val mainPage = R.string.view_main_page_card_title


    private fun checkbox(text: Int) {
        Espresso.onView(Matchers.allOf(ViewMatchers.hasSibling(ViewMatchers.withChild(
                ViewMatchers.withText(text))),
                ViewMatchers.withId(R.id.feed_content_type_checkbox)))
                .check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }

    fun scrollFeed() {
        Espresso.onView(ViewMatchers.withId(R.id.content_types_recycler))
                .perform(ViewActions.swipeUp());
    }

    fun checkAllCheckboxes(){
        checkbox(article)
        checkbox(image)
        checkbox(news)
        checkbox(topRead)
        checkbox(recommend)
        checkbox(thisDay)
        scrollFeed()
        checkbox(random)
        checkbox(mainPage)
    }
}