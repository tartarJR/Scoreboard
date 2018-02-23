package com.tatar.scoreboard.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tatar.scoreboard.R;
import com.tatar.scoreboard.data.local.modal.Hole;

import java.util.List;

/**
 * Created by mobile on 23.02.2018.
 */

public class ScoreboardAdapter extends RecyclerView.Adapter<ScoreboardAdapter.ViewHolder> {

    private Context context;
    private List<Hole> holeList;

    public ScoreboardAdapter(Context context, List<Hole> holeList) {
        this.context = context;
        this.holeList = holeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hole_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindHour(holeList.get(position));
    }

    @Override
    public int getItemCount() {
        return holeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hole hole) {
            holeLabel.setText(hole.getHoleName());
            scoreLabel.setText(hole.getScore());
        }

        @Override
        public void onClick(View v) {

        }
    }

}
