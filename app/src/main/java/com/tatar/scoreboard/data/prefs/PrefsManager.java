package com.tatar.scoreboard.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.tatar.scoreboard.data.local.modal.Hole;

import java.util.List;

/**
 * Created by mobile on 23.02.2018.
 */

public class PrefsManager {

    private static final String PREF_NAME = "com.tatar.scoreboard.preferences";
    private static final String PREF_KEY_SCORE_COUNT = "PREF_KEY_SCORE_COUNT_";
    private static final int SCORE_COUNT_DEF_VAL = 0;

    private final SharedPreferences prefs;

    public PrefsManager(Context context) {
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
        return prefs.getInt(PREF_KEY_SCORE_COUNT + holeName, SCORE_COUNT_DEF_VAL);
    }

    public void clearScoreCounts(List<Hole> holeList) {
        prefs.edit().clear();
        prefs.edit().apply();

        for (Hole hole : holeList) {
            hole.setScore(SCORE_COUNT_DEF_VAL);
        }
    }
}
