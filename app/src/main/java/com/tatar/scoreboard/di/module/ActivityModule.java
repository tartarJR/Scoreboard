package com.tatar.scoreboard.di.module;

import android.app.Activity;
import android.content.Context;

import com.tatar.scoreboard.di.qualifier.ActivityContext;
import com.tatar.scoreboard.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 26.02.2018.
 */

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @ActivityContext
    @PerActivity
    @Provides
    public Context context() {
        return context;
    }

}
