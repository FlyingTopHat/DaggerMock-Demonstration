package com.flyingtophat.daggermockexample;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.flyingtophat.daggermockexample.di.AppComponent;
import com.flyingtophat.daggermockexample.di.DaggerAppComponent;
import com.flyingtophat.daggermockexample.di.module.AppModule;
import com.flyingtophat.daggermockexample.di.module.ButtonModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .buttonModule(new ButtonModule())
            .build();
    }

    @VisibleForTesting
    public void setComponent(final AppComponent component) {
        mAppComponent = component;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
