package com.tatar.scoreboard.data.local.provider;

import com.tatar.scoreboard.data.local.modal.Hole;
import com.tatar.scoreboard.data.prefs.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobile on 23.02.2018.
 */

public class HoleProvider {

    private static final String HOLE_NAME_INDICATOR = "Hole ";

    private SharedPreferencesManager sharedPreferencesManager;

    public HoleProvider(SharedPreferencesManager sharedPreferencesManager) {
        this.sharedPreferencesManager = sharedPreferencesManager;
    }

    public List<Hole> provideHoleList() {
        List<Hole> holeList = new ArrayList<>();

        Hole hole;

        for (int i = 1; i < 19; i++) {
            hole = new Hole();

            hole.setHoleName(HOLE_NAME_INDICATOR + i);
            hole.setScore(sharedPreferencesManager.getScoreCountForHole(hole.getHoleName()));

            holeList.add(hole);
        }

        return holeList;
    }
}
