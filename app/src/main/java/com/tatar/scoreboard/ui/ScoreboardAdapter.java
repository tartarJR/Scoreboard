package com.tatar.scoreboard.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.modal.Hole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobile on 23.02.2018.
 */

public class ScoreboardAdapter extends RecyclerView.Adapter<ScoreboardAdapter.ViewHolder> {

    private Context context;
    private final List<Hole> holeList = new ArrayList<>();

    public ScoreboardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hole_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindHole(holeList.get(position));

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedScore = holeList.get(position).getScore() + 1;
                holeList.get(position).setScore(updatedScore);
                holder.scoreLabel.setText(updatedScore + "");
            }
        });

        holder.subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedScore = holeList.get(position).getScore() - 1;
                if (updatedScore < 0) {
                    Toast.makeText(context, "Can not subtract score, it is already 0.", Toast.LENGTH_LONG).show();
                    updatedScore = 0;
                }
                holeList.get(position).setScore(updatedScore);
                holder.scoreLabel.setText(updatedScore + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return holeList.size();
    }

    public void updateHolesList(List<Hole> holeList) {
        this.holeList.clear();
        this.holeList.addAll(holeList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView holeLabel;
        public TextView scoreLabel;
        public Button addButton;
        public Button subtractButton;

        public ViewHolder(View itemView) {
            super(itemView);

            holeLabel = itemView.findViewById(R.id.holeNameTextView);
            scoreLabel = itemView.findViewById(R.id.scoreTextView);
            addButton = itemView.findViewById(R.id.add_score_button);
            subtractButton = itemView.findViewById(R.id.subtract_score_btn);
        }

        public void bindHole(Hole hole) {
            holeLabel.setText(hole.getHoleName());
            scoreLabel.setText(hole.getScore() + "");
        }

    }

}
