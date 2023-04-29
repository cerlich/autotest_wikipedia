package org.wikipedia.fintechTests.screens


import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Description
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsNot.not
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Checks
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matcher
import org.wikipedia.R


class CreateAccountScreen {
   private val password = withHint(R.string.account_creation_password_hint)
   private val username = withHint(R.string.create_account_username_hint)
   private val passwordRepeat = withHint(R.string.create_account_password_repeat_hint)
   private val hide = withId(com.google.android.material.R.id.text_input_end_icon)
   private val passError = withText(R.string.create_account_password_error)
   private val nextButton = withId(R.id.create_account_submit_button)

   fun typeTextToPasswordField(text: String){
      onView(password)
              .perform(click(), typeText(text), closeSoftKeyboard())
   }

   fun typeTextToPasswordRepeatField(text: String){
      onView(passwordRepeat)
              .perform(click(), typeText(text), closeSoftKeyboard())
   }

   fun typeTextToUsernameField(text: String){
      onView(username)
              .perform(click(), typeText(text), closeSoftKeyboard())
   }

   fun clickHidePassword(){
      onView(allOf(hide, isDescendantOfA(withId(R.id.create_account_password_input))))
              .perform(click())
   }

   fun clickNext(){
      onView(nextButton)
              .perform(click())
   }

   fun checkIsVisiblePass(){
      onView(password)
              .check(matches(not(CheckIsHidden())))
   }

   fun checkIsHiddenPass(){
      onView(password)
              .check(matches(CheckIsHidden()))
   }

   fun checkColorPassword(){
      onView(withId(R.id.create_account_password_input))
              .check(matches(errorColor(R.color.red700)))
   }

   fun checkError(){
      onView(passError)
              .check(matches(allOf(isDisplayed(), hasTextColor(R.color.red700))))
   }

   class CheckIsHidden(): BoundedMatcher<View?, EditText>(EditText::class.java){
      override fun describeTo(description: Description) {
         description.appendText("Password visibility check error")
      }
      override fun matchesSafely(editText: EditText): Boolean {
       return editText.transformationMethod is PasswordTransformationMethod
      }
   }

   private fun errorColor(@ColorInt color : Int): Matcher<View> {
      Checks.checkNotNull(color)
      return object : BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {
         override fun describeTo(description: Description?) {
            description?.appendText("color is $color")
         }

         override fun matchesSafely(item: TextInputLayout): Boolean {
            val exp = ContextCompat.getColor(item.context, color)
            val fact = item.errorCurrentTextColors
            return exp == fact
         }

      }
   }
}


