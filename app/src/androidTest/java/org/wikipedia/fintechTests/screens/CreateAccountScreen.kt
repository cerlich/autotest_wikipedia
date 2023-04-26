package org.wikipedia.fintechTests.screens


import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
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
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import org.hamcrest.Matcher
import org.wikipedia.R


class CreateAccountScreen {
   private val password = withHint(R.string.account_creation_password_hint)
   private val hide = withId(com.google.android.material.R.id.text_input_end_icon)
   private val passError = withText(R.string.create_account_password_error)

   fun typeTextToPasswordField(text: String){
      onView(password)
              .perform(click(), typeText(text), closeSoftKeyboard())
   }

   fun clickHidePassword(){
      onView(allOf(hide, isDescendantOfA(withId(R.id.create_account_password_input))))
              .perform(click())
   }

   fun checkIsVisiblePass(){
      onView(password)
              .check(matches(not(CheckHide())))
   }

   fun checkIsHiddenPass(){
      onView(password)
              .check(matches(CheckHide()))
   }

   fun checkColorError(){
      onView(passError)
              .check(matches(hasTextColor(R.color.red700)))
   }

   class CheckHide(): BoundedMatcher<View?, EditText>(EditText::class.java){
      override fun describeTo(description: Description) {
         description.appendText("Password visibility check error")
      }
      override fun matchesSafely(editText: EditText): Boolean {
         return editText.transformationMethod.equals(PasswordTransformationMethod.getInstance())
      // return editText.transformationMethod is PasswordTransformationMethod
      }
   }
}


