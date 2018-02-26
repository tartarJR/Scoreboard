package com.tatar.scoreboard.di.component;

import com.tatar.scoreboard.di.module.HoleProviderModule;
import com.tatar.scoreboard.di.module.PrefsModule;
import com.tatar.scoreboard.ui.ScoreboardActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobile on 26.02.2018.
 */

@Component(modules = {PrefsModule.class, HoleProviderModule.class})
@Singleton
public interface AppComponent {
    void inject(ScoreboardActivity scoreboardActivity);
}
