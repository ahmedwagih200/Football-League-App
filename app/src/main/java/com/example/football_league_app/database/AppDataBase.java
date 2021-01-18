package com.example.football_league_app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.football_league_app.pojo.Converters;
import com.example.football_league_app.pojo.Team;

@Database(entities = Team.class , version = 1,exportSchema = false)
@TypeConverters(Converters.class)

public abstract class  AppDataBase extends RoomDatabase {
    public abstract TeamsDao Teamsdao();
}
