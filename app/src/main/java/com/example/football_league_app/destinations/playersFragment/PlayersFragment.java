package com.example.football_league_app.destinations.playersFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.football_league_app.adapters.PlayersAdapter;
import com.example.football_league_app.databinding.FragmentPlayersBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PlayersFragment extends Fragment {

    FragmentPlayersBinding binding;
    TeamViewModel teamViewModel;
    PlayersAdapter playersAdapter;

    public PlayersFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayersBinding.inflate(inflater,container,false);

        playersAdapter = new PlayersAdapter();
        binding.playersRecyclerView.setAdapter(playersAdapter);

        teamViewModel = new ViewModelProvider(this).get(TeamViewModel.class);
        assert getArguments() != null;
        teamViewModel.getTeam(PlayersFragmentArgs.fromBundle(getArguments()).getTeamID());
        int teamID = Integer.parseInt(PlayersFragmentArgs.fromBundle(getArguments()).getTeamID());
        teamViewModel.getPlayersFromDataBase(teamID).observe(getViewLifecycleOwner(), team -> playersAdapter.setList(team.getSquad()));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
