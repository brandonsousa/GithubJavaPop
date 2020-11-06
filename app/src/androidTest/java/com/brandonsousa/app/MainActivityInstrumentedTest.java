package com.brandonsousa.app;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.brandonsousa.app.view.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/*
 * @created at 22/10/2020 - 20:11
 * @project App
 * @author brand
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkIfLoading() {
        onView(withId(R.id.pb_main))
                .check(matches(isDisplayed()));

    }

    @Test
    public void checkIfHasContent() {
        try {
            Thread.sleep(5000);
            onView(withId(R.id.swt_sort_by))
                    .check(matches(isDisplayed()));
            onView(withText("JavaGuide"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
