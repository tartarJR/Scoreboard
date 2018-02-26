package com.tatar.scoreboard.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.tatar.scoreboard.data.local.modal.Hole;

import java.util.List;

/**
 * Created by mobile on 23.02.2018.
 */

public class SharedPreferencesManager {

    private static final String PREF_NAME = "com.tatar.scoreboard.preferences";
    private static final String PREF_KEY_SCORE_COUNT = "PREF_KEY_SCORE_COUNT_";

    private final SharedPreferences prefs;

    public SharedPreferencesManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setScoreCountsForHoles(List<Hole> holeList) {
        for (int i = 0; i < holeList.size(); i++) {
            setScoreCountForHole(holeList.get(i).getHoleName(), holeList.get(i).getScore());
        }
    }

    private void setScoreCountForHole(String holeName, int scoreCount) {
        prefs.edit().putInt(PREF_KEY_SCORE_COUNT + holeName, scoreCount).apply();
    }

    public int getScoreCountForHole(String holeName) {
        return prefs.getInt(PREF_KEY_SCORE_COUNT + holeName, 0);
    }
}
