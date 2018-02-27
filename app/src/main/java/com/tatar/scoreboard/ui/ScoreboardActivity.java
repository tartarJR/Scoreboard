package com.tatar.scoreboard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.tatar.scoreboard.App;
import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.modal.Hole;
import com.tatar.scoreboard.data.local.provider.HoleProvider;
import com.tatar.scoreboard.data.prefs.PrefsManager;
import com.tatar.scoreboard.di.component.ScoreboardAdapterComponent;
import com.tatar.scoreboard.di.component.DaggerScoreboardAdapterComponent;
import com.tatar.scoreboard.di.module.ActivityModule;

import java.util.List;

import javax.inject.Inject;

public class ScoreboardActivity extends AppCompatActivity {

    private ScoreboardAdapterComponent scoreboardAdapterComponent;

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

        scoreboardAdapterComponent = DaggerScoreboardAdapterComponent.builder().activityModule(new ActivityModule(this)).build();

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

        adapter = scoreboardAdapterComponent.scoreboardAdapter();
        adapter.updateHolesList(holeList);

        holeRecyclerView.setAdapter(adapter);
        holeRecyclerView.setLayoutManager(scoreboardAdapterComponent.linearLayoutManager());
        holeRecyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_scoreboard) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
