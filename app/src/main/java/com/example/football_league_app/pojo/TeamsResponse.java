package com.example.football_league_app.pojo;

import java.util.ArrayList;

public class TeamsResponse {
    ArrayList<Team> teams;

    public TeamsResponse(ArrayList<Team> teamsArrayList) {
        this.teams = teamsArrayList;
    }

    public ArrayList<Team> getTeamsArrayList() {
        return teams;
    }

    public void setTeamsArrayList(ArrayList<Team> teamsArrayList) {
        this.teams = teamsArrayList;
    }
}
