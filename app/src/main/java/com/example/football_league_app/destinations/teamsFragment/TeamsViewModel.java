package com.example.football_league_app.destinations.teamsFragment;

import android.util.Log;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.football_league_app.pojo.Team;
import com.example.football_league_app.pojo.TeamsResponse;
import com.example.football_league_app.repository.Repository;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class TeamsViewModel extends ViewModel {
    private static final String TAG = "TeamsViewModel";
    Repository repository;

    @ViewModelInject
    public TeamsViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getTeams() {
        Observable<TeamsResponse> observable = repository.getTeams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<TeamsResponse> observer = new Observer<TeamsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onNext(@NonNull TeamsResponse teamsResponse) {
                repository.insertTeamsToDatabase(teamsResponse.getTeamsArrayList());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Done");
            }
        };

        observable.subscribe(observer);
    }

    LiveData<List<Team>> getTeamsFromDataBase() {
        return repository.getTeamsFromDataBase();
    }
}

