package com.example.football_league_app.networking;

import com.example.football_league_app.pojo.Team;
import com.example.football_league_app.pojo.TeamsResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TeamsApiService {
    @Headers("X-Auth-Token:44737f0419d747f1a8af006cedd11ff8")
    @GET("competitions/PL/teams?season=2020")
    Observable<TeamsResponse> getTeams();

    @Headers("X-Auth-Token:44737f0419d747f1a8af006cedd11ff8")
    @GET("teams/{id}")
    Observable<Team> getTeam(@Path("id") String id);
}
