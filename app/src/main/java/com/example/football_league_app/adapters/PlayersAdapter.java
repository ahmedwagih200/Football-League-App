package com.example.football_league_app.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.football_league_app.R;
import com.example.football_league_app.databinding.PlayerListItemBinding;
import com.example.football_league_app.pojo.Player;
import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {
    private List<Player> playersList ;

    @NonNull
    @Override
    public PlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlayerListItemBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()),R.layout.player_list_item,parent,false);
        return new PlayersViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PlayersViewHolder holder, int position) {
        holder.binding.playerName.setText("Name: " +playersList.get(position).getName());
        holder.binding.playerNation.setText("Nation: "+playersList.get(position).getNationality());
        holder.binding.playerRole.setText("Role: "+playersList.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return playersList == null ? 0 : playersList.size();
    }

    public void setList(List<Player> playersList) {
        this.playersList = playersList;
        notifyDataSetChanged();
    }

    public static class PlayersViewHolder extends RecyclerView.ViewHolder {
        PlayerListItemBinding binding;
        public PlayersViewHolder(@NonNull PlayerListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
