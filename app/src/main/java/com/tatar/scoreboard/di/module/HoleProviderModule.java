package com.tatar.scoreboard.di.module;

import com.tatar.scoreboard.data.local.provider.HoleProvider;
import com.tatar.scoreboard.data.prefs.PrefsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 26.02.2018.
 */

@Module(includes = {PrefsModule.class})
public class HoleProviderModule {

    @Singleton
    public HoleProvider holeProvider(PrefsManager prefsManager) {
        return new HoleProvider(prefsManager);
    }

}
