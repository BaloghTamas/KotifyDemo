package hu.bme.aut.android.kotifydemo.utils

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom
import android.support.v7.widget.Toolbar
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is` as macthesIs


fun matchToolbarTitle(title: CharSequence): ViewInteraction {
    return onView(isAssignableFrom(Toolbar::class.java)).check(matches(withToolbarTitle(macthesIs(title))))
}


private fun withToolbarTitle(
        textMatcher: Matcher<CharSequence>): Matcher<Any> {
    return object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {
        public override fun matchesSafely(toolbar: Toolbar): Boolean {
            return textMatcher.matches(toolbar.title)
        }

        override fun describeTo(description: Description) {
            description.appendText("with toolbar title: ")
            textMatcher.describeTo(description)
        }
    }
}
