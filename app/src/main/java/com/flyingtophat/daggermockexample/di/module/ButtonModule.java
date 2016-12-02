package com.flyingtophat.daggermockexample.di.module;

import android.app.Application;

import com.flyingtophat.daggermockexample.domain.ButtonTextService;

import dagger.Module;
import dagger.Provides;

@Module
public class ButtonModule {

    @Provides
    @SuppressWarnings("WeakerAccess")
    public ButtonTextService providesButtonTextService(final Application app) {
        return new ButtonTextService(app);
    }
}