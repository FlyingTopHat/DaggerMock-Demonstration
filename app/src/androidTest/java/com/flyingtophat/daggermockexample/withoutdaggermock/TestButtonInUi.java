package com.flyingtophat.daggermockexample.withoutdaggermock;

import android.support.test.rule.ActivityTestRule;

import com.flyingtophat.daggermockexample.MainActivity;
import com.flyingtophat.daggermockexample.R;
import com.flyingtophat.daggermockexample.UiTest;
import com.flyingtophat.daggermockexample.di.AppComponent;
import com.flyingtophat.daggermockexample.di.module.AppModule;
import com.flyingtophat.daggermockexample.domain.ButtonTextService;
import com.flyingtophat.daggermockexample.withoutdaggermock.di.MockedButtonModule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

public class TestButtonInUi extends UiTest {

    @Singleton
    @Component(modules = {AppModule.class, MockedButtonModule.class})
    interface TestButtonInUiAppComponent extends AppComponent {
        void inject(TestButtonInUi activity);
    }

    @Rule
    public final ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Inject
    @SuppressWarnings("WeakerAccess")
    ButtonTextService buttonTextService;

    @Before
    public void setupDagger() {
        final TestButtonInUiAppComponent component = buildAppComponent();
        getApp().setComponent(component);

        component.inject(this);
    }

    @Test
    public void buttonUpdatedWithText() {
        when(buttonTextService.getText()).thenReturn("Test456");

        activityRule.launchActivity(null);

        onView(withId(R.id.button)).check(matches(withText("Test456")));
    }

    private static TestButtonInUiAppComponent buildAppComponent() {
        return DaggerTestButtonInUi_TestButtonInUiAppComponent.builder()
                .mockedButtonModule(new MockedButtonModule())
                .build();
    }
}
