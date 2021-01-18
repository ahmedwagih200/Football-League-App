package com.example.football_league_app.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.football_league_app.pojo.Team;
import java.util.List;

@Dao
public interface TeamsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeams(List<Team> teams);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeam(Team teams);

    @Query("select * from Teams_table ")
    LiveData<List<Team>> getTeamsFromDataBase();

    @Query("select * from Teams_table WHERE id =:id")
    LiveData<Team> getTeamFromDataBase(int id);
}
