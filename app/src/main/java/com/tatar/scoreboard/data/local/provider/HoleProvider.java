package com.tatar.scoreboard.data.local.provider;

import com.tatar.scoreboard.data.local.modal.Hole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobile on 23.02.2018.
 */

public class HoleProvider {

    private List<Hole> holeList;

    public HoleProvider() {
        holeList = new ArrayList<>();
        addScores();
    }

    public List<Hole> getHoleList() {
        return holeList;
    }

    private void addScores() {
        Hole hole;

        for (int i = 1; i < 19; i++) {
            hole = new Hole();

            hole.setHoleName("Hole " + i);
            hole.setScore(0);

            holeList.add(hole);
        }
    }
}
