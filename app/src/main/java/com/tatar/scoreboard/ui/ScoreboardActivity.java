package com.tatar.scoreboard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.modal.Hole;
import com.tatar.scoreboard.data.local.provider.HoleProvider;
import com.tatar.scoreboard.data.prefs.PrefsManager;

import java.util.List;

public class ScoreboardActivity extends AppCompatActivity {

    private List<Hole> holeList;

    private PrefsManager prefsManager;
    private HoleProvider holeProvider;

    private RecyclerView holeRecyclerView;
    private ScoreboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        prefsManager = new PrefsManager(getApplicationContext());
        holeProvider = new HoleProvider(prefsManager);

        holeList = holeProvider.provideHoleList();

        holeRecyclerView = findViewById(R.id.holeRecyclerView);

        adapter = new ScoreboardAdapter(ScoreboardActivity.this, holeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        holeRecyclerView.setAdapter(adapter);
        holeRecyclerView.setLayoutManager(layoutManager);
        holeRecyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onPause() {
        super.onPause();

        prefsManager.setScoreCountsForHoles(holeList);
    }
}
