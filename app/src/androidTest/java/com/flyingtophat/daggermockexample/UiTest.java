package com.flyingtophat.daggermockexample;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

public class UiTest {

    protected App getApp() {
        final Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        return (App) instrumentation.getTargetContext().getApplicationContext();
    }
}
