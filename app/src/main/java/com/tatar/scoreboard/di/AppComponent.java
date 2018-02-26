package com.tatar.scoreboard.di;

import com.tatar.scoreboard.di.modules.HoleProviderModule;
import com.tatar.scoreboard.di.modules.PrefsModule;
import com.tatar.scoreboard.ui.ScoreboardActivity;

import dagger.Component;

/**
 * Created by mobile on 26.02.2018.
 */

@Component(modules = {PrefsModule.class, HoleProviderModule.class})
public interface AppComponent {
    void inject(ScoreboardActivity scoreboardActivity);
}
