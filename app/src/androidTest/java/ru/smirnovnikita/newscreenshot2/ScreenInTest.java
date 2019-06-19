package ru.smirnovnikita.newscreenshot2;

import android.app.Instrumentation;
import androidx.test.espresso.Espresso;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class ScreenInTest {
    
    @Rule
    public ActivityTestRule<MainActivity> MyTest = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule = GrantPermissionRule.grant(
            "android.permission.WRITE_EXTERNAL_STORAGE");

    @Before
    public void setup() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Espresso.setFailureHandler(new CustomHandler(instrumentation, MyTest.getActivity()));
    }
    //Press permission button
    public void allowPermission(){
        onView(withText("Allow")).check(matches(isDisplayed())).check(matches(isClickable()));
        onView(withText("Allow")).perform(click());
    }

    //Test must fail.
    @Test
    public void ScreenCheck() {
        onView(withId(R.id.btnMagic)).check(matches(isDisplayed())).check(matches(isClickable()));
        onView(withId(R.id.btnMagic)).perform(click());
        onView(withId(R.id.btnMagic)).check(matches(withText("Магия! Скринь!!!")));
    }

}
