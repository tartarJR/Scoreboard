package com.tatar.scoreboard.di.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.tatar.scoreboard.di.qualifier.ActivityContext;
import com.tatar.scoreboard.di.scope.PerActivity;
import com.tatar.scoreboard.ui.ScoreboardAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 26.02.2018.
 */

@Module(includes = {ActivityModule.class})
public class HoleListModule {

    @PerActivity
    @Provides
    public ScoreboardAdapter scoreboardAdapter(@ActivityContext Context context) {
        return new ScoreboardAdapter(context);
    }

    @PerActivity
    @Provides
    public LinearLayoutManager linearLayoutManager(@ActivityContext Context context) {
        return new LinearLayoutManager(context);
    }

}
