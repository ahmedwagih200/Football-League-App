package com.example.football_league_app.destinations.teamsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.football_league_app.adapters.TeamsAdapter;
import com.example.football_league_app.databinding.FragmentTeamsBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TeamsFragment extends Fragment {
    public TeamsFragment() {
        // Required empty public constructor
    }

    FragmentTeamsBinding binding;
    TeamsViewModel teamsViewModel;
    TeamsAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTeamsBinding.inflate(inflater, container, false);

        adapter = new TeamsAdapter(binding.getRoot().getContext());
        binding.teamsRecyclerView.setAdapter(adapter);

        teamsViewModel = new ViewModelProvider(this).get(TeamsViewModel.class);
        teamsViewModel.getTeams();
        teamsViewModel.getTeamsFromDataBase().observe(getViewLifecycleOwner(), teams -> adapter.setList(teams));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

