package com.example.football_league_app.destinations.playersFragment;

import android.util.Log;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.football_league_app.pojo.Team;
import com.example.football_league_app.repository.Repository;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TeamViewModel extends ViewModel {
    static final String TAG = "TeamViewModel";
    Repository repository;

    @ViewModelInject
    public TeamViewModel(Repository repository) {
        this.repository = repository;
    }
    public void getTeam(String id){
        Observable<Team> observable = repository.getTeam(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Team> observer = new Observer<Team>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Team team) {
                repository.insertTeamToDatabase(team);
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

    LiveData<Team> getPlayersFromDataBase(int id){
        return repository.getTeamFromDataBase(id);
    }
}
