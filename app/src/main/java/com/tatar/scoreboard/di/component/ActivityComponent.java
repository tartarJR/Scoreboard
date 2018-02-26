package com.tatar.scoreboard.di.component;

import android.support.v7.widget.LinearLayoutManager;

import com.tatar.scoreboard.di.module.HoleListModule;
import com.tatar.scoreboard.di.scope.PerActivity;
import com.tatar.scoreboard.ui.ScoreboardActivity;
import com.tatar.scoreboard.ui.ScoreboardAdapter;

import dagger.Component;

/**
 * Created by mobile on 26.02.2018.
 */

@Component(modules = {HoleListModule.class})
@PerActivity
public interface ActivityComponent {
    ScoreboardAdapter scoreboardAdapter();

    LinearLayoutManager linearLayoutManager();
}
