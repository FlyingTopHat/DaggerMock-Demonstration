package com.flyingtophat.daggermockexample.withoutdaggermock.di;

import com.flyingtophat.daggermockexample.domain.ButtonTextService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class MockedButtonModule {

    @Singleton
    @Provides
    ButtonTextService providesMockButtonTextService() {
        return mock(ButtonTextService.class);
    }
}