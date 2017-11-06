package app.com.mobileassignment;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.com.mobileassignment.views.MainActivity;

/**
 * Created by Amatus Samiu on 11/6/2017.
 */

@RunWith(AndroidJUnit4.class)
public class AutomatedTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkTextEnteredInSearchBoxAndDisplayed() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.search)).perform(ViewActions.typeText("amsterdam"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.search)).check(ViewAssertions.matches(ViewMatchers.withText("amsterdam")));
        Thread.sleep(1000);
        Espresso.onData(CoreMatchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.citiesList))
                .atPosition(0)
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(Matchers.allOf(ViewMatchers.withId(R.id.cityName), ViewMatchers.withText("Amsterdam, NL")))));
    }

}
