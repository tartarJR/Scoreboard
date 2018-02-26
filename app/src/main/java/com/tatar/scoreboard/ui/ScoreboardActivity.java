package com.tatar.scoreboard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tatar.scoreboard.App;
import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.modal.Hole;
import com.tatar.scoreboard.data.local.provider.HoleProvider;
import com.tatar.scoreboard.data.prefs.PrefsManager;

import java.util.List;

import javax.inject.Inject;

public class ScoreboardActivity extends AppCompatActivity {

    private List<Hole> holeList;

    @Inject
    PrefsManager prefsManager;

    @Inject
    HoleProvider holeProvider;

    private RecyclerView holeRecyclerView;
    private ScoreboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        App.getAppComponent().inject(this);

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

        adapter = new ScoreboardAdapter(ScoreboardActivity.this);
        adapter.updateHolesList(holeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        holeRecyclerView.setAdapter(adapter);
        holeRecyclerView.setLayoutManager(layoutManager);
        holeRecyclerView.setHasFixedSize(true);
    }
}
