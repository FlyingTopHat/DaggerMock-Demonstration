package com.flyingtophat.daggermockexample.di;

import com.flyingtophat.daggermockexample.MainActivity;
import com.flyingtophat.daggermockexample.di.module.AppModule;
import com.flyingtophat.daggermockexample.di.module.ButtonModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ButtonModule.class})
public interface AppComponent {

    void inject(final MainActivity mainActivity);
}
