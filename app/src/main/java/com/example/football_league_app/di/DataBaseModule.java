package com.example.football_league_app.di;

import android.app.Application;
import androidx.room.Room;
import com.example.football_league_app.database.AppDataBase;
import com.example.football_league_app.database.TeamsDao;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)

public class DataBaseModule {
    @Provides
    @Singleton
    public static AppDataBase provideDataBase(Application application) {
        return Room.databaseBuilder(application, AppDataBase.class, "DataBase")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Singleton
    @Provides
    public static TeamsDao provideTeamDao(AppDataBase dataBase) {
        return dataBase.Teamsdao();
    }

}
