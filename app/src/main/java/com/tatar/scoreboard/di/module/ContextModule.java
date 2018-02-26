package com.tatar.scoreboard.di.module;

import android.content.Context;

import com.tatar.scoreboard.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 26.02.2018.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @Singleton
    @Provides
    public Context context() {
        return context.getApplicationContext();
    }

}
