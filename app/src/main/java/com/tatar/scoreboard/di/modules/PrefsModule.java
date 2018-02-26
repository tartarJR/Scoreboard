package com.tatar.scoreboard.di.modules;

import android.content.Context;

import com.tatar.scoreboard.data.prefs.PrefsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 26.02.2018.
 */

@Module(includes = {ContextModule.class})
public class PrefsModule {

    @Provides
    @Singleton
    public PrefsManager prefsManager(Context context) {
        return new PrefsManager(context);
    }

}
