package com.tatar.scoreboard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.tatar.scoreboard.App;
import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.modal.Hole;
import com.tatar.scoreboard.data.local.provider.HoleProvider;
import com.tatar.scoreboard.data.prefs.PrefsManager;
import com.tatar.scoreboard.di.component.ActivityComponent;
import com.tatar.scoreboard.di.component.DaggerActivityComponent;
import com.tatar.scoreboard.di.module.ActivityModule;

import java.util.List;

import javax.inject.Inject;

public class ScoreboardActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Inject
    PrefsManager prefsManager;

    @Inject
    HoleProvider holeProvider;

    private List<Hole> holeList;
    private RecyclerView holeRecyclerView;
    private ScoreboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        App.getAppComponent().inject(this);

        activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build();

        holeList = holeProvider.provideHoleList();

        setUpRecyclerView();
    }

    @Override
    protected void onPause() {
        super.onPause();

        prefsManager.setScoreCountsForHoles(holeList);
    }

    private void setUpRecyclerView() {
        holeRecyclerView = findViewById(R.id.holeRecyclerView);

        adapter = activityComponent.scoreboardAdapter();
        adapter.updateHolesList(holeList);

        holeRecyclerView.setAdapter(adapter);
        holeRecyclerView.setLayoutManager(activityComponent.linearLayoutManager());
        holeRecyclerView.setHasFixedSize(true);
    }
}
