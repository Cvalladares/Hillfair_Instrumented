package appteam.nith.hillffair.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appteam.nith.hillffair.R;
import appteam.nith.hillffair.activities.LeaderBoardActivity;

import java.util.ArrayList;

/**
 * Created by Akatsuki on 10/12/2016.
 */
public class LeaderBoardAdapter extends  RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardViewHolder> {
    ArrayList<LeaderBoardActivity.LeaderBoardUserModel> users;
    Context context;

    public LeaderBoardAdapter(ArrayList<LeaderBoardActivity.LeaderBoardUserModel> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public LeaderBoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_leaderboard,parent,false);
        LeaderBoardViewHolder leaderBoardViewHolder = new LeaderBoardViewHolder(view,users,context);

        return leaderBoardViewHolder;
    }

    @Override
    public void onBindViewHolder(LeaderBoardViewHolder holder, int position) {

        LeaderBoardActivity.LeaderBoardUserModel user=users.get(position);
        holder.username.setText(user.getName());
        if(user.getRollNo()!=null)
        holder.rollno.setText(user.getRollNo());
        else {
            holder.rollno.setText("Not-Nitian");
        }
        holder.score.setText("Score: "+Integer.toString(user.getScore()));
        holder.sets.setText("Sets: "+Integer.toString(user.getSets()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class LeaderBoardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView username;
        TextView rollno;
        TextView score;
        TextView sets;
        Context context;
        public LeaderBoardViewHolder(View view, ArrayList<LeaderBoardActivity.LeaderBoardUserModel> users, Context context) {
            super(view);
            view.setOnClickListener(this);
            username=(TextView)view.findViewById(R.id.leader_username);
            rollno=(TextView)view.findViewById(R.id.leader_rollno);
            score=(TextView)view.findViewById(R.id.leader_score);
            sets=(TextView)view.findViewById(R.id.leader_sets);
            this.context=context;
        }

        @Override
        public void onClick(View view) {
            //what to do on click?
        }
    }
}
