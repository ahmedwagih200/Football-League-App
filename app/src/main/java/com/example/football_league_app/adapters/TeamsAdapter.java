package com.example.football_league_app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.football_league_app.R;
import com.example.football_league_app.databinding.TeamsListItemBinding;
import com.example.football_league_app.destinations.teamsFragment.TeamsFragmentDirections;
import com.example.football_league_app.pojo.Team;
import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {
    private List<Team> teamsList ;
    Context context;

    public TeamsAdapter(Context context ) {
        this.context = context;
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TeamsListItemBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), R.layout.teams_list_item,parent,false);
        return new TeamsViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
        holder.binding.teamName.setText(teamsList.get(position).getName());
        holder.binding.teamColor.setText("TeamColors: " + teamsList.get(position).getClubColors());
        holder.binding.teamVenue.setText("TeamVenue: "+ teamsList.get(position).getVenue());
        openTeamSite(holder,position);

        int id =teamsList.get(position).getId();
        String id2 = String.valueOf(id);
        TeamsFragmentDirections.ActionTeamsFragmentToPlayersFragment action =
                TeamsFragmentDirections.actionTeamsFragmentToPlayersFragment(id2);
        holder.binding.showPlayers.setOnClickListener(view -> Navigation.findNavController(view).navigate(action));
    }

    @Override
    public int getItemCount() {
        return teamsList == null ? 0 : teamsList.size();
    }

    public void setList(List<Team> teamsList) {
        this.teamsList = teamsList;
        notifyDataSetChanged();
    }

    public static class TeamsViewHolder extends RecyclerView.ViewHolder {
        TeamsListItemBinding binding;

        public TeamsViewHolder(@NonNull TeamsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    void openTeamSite(TeamsViewHolder holder, final int position){
        String textLink = "Visit The Team Web Site";
        SpannableString ss = new SpannableString(textLink);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Uri uri = Uri.parse(teamsList.get(position).getWebsite());
                context.startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        };
        ss.setSpan(clickableSpan,10,23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.binding.teamWebsite.setText(ss);
        holder.binding.teamWebsite.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
