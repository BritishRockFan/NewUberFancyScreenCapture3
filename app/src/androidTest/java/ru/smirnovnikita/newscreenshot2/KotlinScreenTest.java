package ru.smirnovnikita.newscreenshot2;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.smirnovnikita.newscreenshot2.FancyScreen.ScreenshotTakingRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class KotlinScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> MyTest = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ScreenshotTakingRule screenshotTake = new ScreenshotTakingRule();

    //Press permission button
    public void allowPermission(){
        onView(withText("Allow")).check(matches(isDisplayed())).check(matches(isClickable()));
        onView(withText("Allow")).perform(click());
    }

    //Test must fail
    @Test
    public void ScreenCheck() {
        onView(withId(R.id.btnMagic)).check(matches(isDisplayed())).check(matches(isClickable()));
        onView(withId(R.id.btnMagic)).perform(click());
        onView(withId(R.id.btnMagic)).check(matches(withText("Магия! Скринь!!!")));
    }
}
