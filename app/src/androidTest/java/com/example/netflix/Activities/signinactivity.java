package com.example.netflix.Activities;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.netflix.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class signinactivity {

    @Rule
    public ActivityTestRule<SplashScreen> mActivityTestRule = new ActivityTestRule<>(SplashScreen.class);

    @Test
    public void signinactivity() {
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.emailedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("t"), closeSoftKeyboard());

        pressBack();

        pressBack();

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.passwordedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.passwordedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("12345678"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.signinbutton), withText("Sign In"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction checkableImageButton = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.passwordedittext), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.passwordedittext), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("123456789"));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.passwordedittext), withText("123456789"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.passwordedittext), withText("123456789"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.signinbutton), withText("Sign In"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                2),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.signinbutton), withText("Sign In"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                2),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.settingsicon), withContentDescription("Settings"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.signoutbutton), withText("Signout"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                11),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(android.R.id.button2), withText("NO"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.signoutbutton), withText("Signout"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                11),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(android.R.id.button1), withText("YES"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton7.perform(scrollTo(), click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.singuptextview), withText("New to Netflix? Sign up now."),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatTextView.perform(click());

        pressBack();

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.emailedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(pressImeActionButton());

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.emailedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText9.perform(pressImeActionButton());

        pressBack();

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.passwordedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText10.perform(pressImeActionButton());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.forgotpasswordtextview), withText("Forgot Password?"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                3),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.forgotpasswordtextview), withText("Forgot Password?"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                3),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.emailedittext), withText("pratyaksh0shrivastava@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText11.perform(pressImeActionButton());

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.emailedittext), withText("pratyaksh0shrivastava@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText12.perform(replaceText("pratyaksh0shrivastava@gmail.com"));

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.emailedittext), withText("pratyaksh0shrivastava@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.emailedittext), withText("pratyaksh0shrivastava@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emaillayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(pressImeActionButton());

        ViewInteraction textInputEditText15 = onView(
                allOf(withId(R.id.passwordedittext),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.passwordlayout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText15.perform(pressImeActionButton());

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.forgotpasswordtextview), withText("Forgot Password?"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                3),
                        isDisplayed()));
        appCompatTextView4.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(android.R.id.button2), withText("NO"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatButton8.perform(scrollTo(), click());

        ViewInteraction appCompatTextView5 = onView(
                allOf(withId(R.id.forgotpasswordtextview), withText("Forgot Password?"),
                        childAtPosition(
                                allOf(withId(R.id.constraintLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                3),
                        isDisplayed()));
        appCompatTextView5.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(android.R.id.button1), withText("YES"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton9.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
