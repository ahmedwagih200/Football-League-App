package com.example.football_league_app.di;

import com.example.football_league_app.networking.TeamsApiService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)

public class RetrofitModule {
    @Provides
    @Singleton
    public static TeamsApiService teamsApiServiceProvider() {
        return new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                //note
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(TeamsApiService.class);
    }
}
