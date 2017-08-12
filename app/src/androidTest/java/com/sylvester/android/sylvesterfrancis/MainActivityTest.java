package com.sylvester.android.sylvesterfrancis;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager.perform(swipeLeft());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction viewPager2 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager2.perform(swipeLeft());

        ViewInteraction viewPager3 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager3.perform(swipeLeft());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.your_name));
        appCompatEditText.perform(scrollTo(), click());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.your_name));
        appCompatEditText2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText3 = onView(
                withId(R.id.your_name));
        appCompatEditText3.perform(scrollTo(), replaceText("sylvester"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                withId(R.id.your_email));
        appCompatEditText4.perform(scrollTo(), replaceText("whitefire00700@gmail.com"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText5 = onView(
                withId(R.id.your_subject));
        appCompatEditText5.perform(scrollTo(), replaceText("expres"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.your_subject), withText("expres")));
        appCompatEditText6.perform(scrollTo(), replaceText("expresso "), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                withId(R.id.your_message));
        appCompatEditText7.perform(scrollTo(), replaceText("testi"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.your_message), withText("testi")));
        appCompatEditText8.perform(scrollTo(), replaceText("testing"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.post_message), withText("Send Message")));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction viewPager4 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager4.perform(swipeRight());

        ViewInteraction viewPager5 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager5.perform(swipeRight());

        ViewInteraction viewPager6 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager6.perform(swipeRight());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3466094);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction viewPager7 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager7.perform(swipeLeft());

        ViewInteraction viewPager8 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager8.perform(swipeRight());

        ViewInteraction viewPager9 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager9.perform(swipeLeft());

        ViewInteraction viewPager10 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager10.perform(swipeLeft());

        ViewInteraction viewPager11 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager11.perform(swipeLeft());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3580939);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction viewPager12 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager12.perform(swipeLeft());

        ViewInteraction viewPager13 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager13.perform(swipeLeft());

        ViewInteraction viewPager14 = onView(
                allOf(withId(R.id.materialviewpager_viewpager),
                        withParent(withId(R.id.viewpager_layout)),
                        isDisplayed()));
        viewPager14.perform(swipeLeft());

    }

}
