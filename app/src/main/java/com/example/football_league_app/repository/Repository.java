package com.example.football_league_app.repository;

import androidx.lifecycle.LiveData;
import com.example.football_league_app.database.TeamsDao;
import com.example.football_league_app.networking.TeamsApiService;
import com.example.football_league_app.pojo.Team;
import com.example.football_league_app.pojo.TeamsResponse;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.core.Observable;

public class Repository {
    TeamsApiService teamsApiService;
    TeamsDao teamsDao;

    @Inject
    public Repository(TeamsApiService teamsApiService, TeamsDao dao) {
        this.teamsApiService = teamsApiService;
        this.teamsDao = dao;
    }


    public Observable<TeamsResponse> getTeams() {
        return teamsApiService.getTeams();
    }

    public Observable<Team> getTeam(String id) {
        return teamsApiService.getTeam(id);
    }

    public LiveData<List<Team>> getTeamsFromDataBase() {
        return teamsDao.getTeamsFromDataBase();
    }

    public LiveData<Team> getTeamFromDataBase(int id) {
        return teamsDao.getTeamFromDataBase(id);
    }

    public void insertTeamsToDatabase(List<Team> teams) {
        teamsDao.insertTeams(teams);
    }

    public void insertTeamToDatabase(Team teams) {
        teamsDao.insertTeam(teams);
    }
}
