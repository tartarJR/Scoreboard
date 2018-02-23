package com.tatar.scoreboard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.provider.HoleProvider;

public class ScoreboardActivity extends AppCompatActivity {

    private HoleProvider holeProvider;

    private RecyclerView holeRecyclerView;
    private ScoreboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        holeRecyclerView = findViewById(R.id.holeRecyclerView);

        holeProvider = new HoleProvider();

        adapter = new ScoreboardAdapter(ScoreboardActivity.this, holeProvider.getHoleList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        holeRecyclerView.setAdapter(adapter);
        holeRecyclerView.setLayoutManager(layoutManager);
        holeRecyclerView.setHasFixedSize(true);
    }
}
