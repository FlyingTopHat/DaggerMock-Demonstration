package com.flyingtophat.daggermockexample.withdaggermock;

import android.support.test.rule.ActivityTestRule;

import com.flyingtophat.daggermockexample.MainActivity;
import com.flyingtophat.daggermockexample.R;
import com.flyingtophat.daggermockexample.UiTest;
import com.flyingtophat.daggermockexample.di.AppComponent;
import com.flyingtophat.daggermockexample.di.module.AppModule;
import com.flyingtophat.daggermockexample.di.module.ButtonModule;
import com.flyingtophat.daggermockexample.domain.ButtonTextService;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import it.cosenonjaviste.daggermock.DaggerMockRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

public class TestButtonInUi extends UiTest {

    @Rule
    public DaggerMockRule<AppComponent> daggerRule = new DaggerMockRule<>(AppComponent.class,
            new AppModule(getApp()), new ButtonModule()).set(new DaggerMockRule.ComponentSetter<AppComponent>() {
        @Override
        public void setComponent(AppComponent appComponent) {
            getApp().setComponent(appComponent);
        }
    });

    @Rule
    public final ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Mock
    private ButtonTextService buttonTextService;

    @Test
    public void buttonUpdatedWithText() {
        when(buttonTextService.getText()).thenReturn("Test123");

        activityRule.launchActivity(null);

        onView(withId(R.id.button)).check(matches(withText("Test123")));
    }
}
