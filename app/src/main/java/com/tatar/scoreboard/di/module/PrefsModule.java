package com.tatar.scoreboard.di.module;

import android.content.Context;

import com.tatar.scoreboard.data.prefs.PrefsManager;
import com.tatar.scoreboard.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 26.02.2018.
 */

@Module(includes = {ContextModule.class})
public class PrefsModule {

    @Singleton
    @Provides
    public PrefsManager prefsManager(@ApplicationContext Context context) {
        return new PrefsManager(context);
    }

}
