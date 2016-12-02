package com.flyingtophat.daggermockexample.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application app;

    public AppModule(final Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    @SuppressWarnings("WeakerAccess")
    public Application providesApplication() {
        return app;
    }
}
