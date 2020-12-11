package com.rosyads.meself.model;
/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class FriendViewModel extends AndroidViewModel {
    private FriendRepository repository;
    private LiveData<List<Friend>> allFriends;

    public FriendViewModel(@NonNull Application application) {
        super(application);
        repository = new FriendRepository(application);
        allFriends = repository.getAllFriends();
    }

    public void insert(Friend friend){
        repository.insert(friend);
    }

    public void update(Friend friend){
        repository.update(friend);
    }

    public void delete(Friend friend){
        repository.delete(friend);
    }

    public void deleteAllFriends(){
        repository.deleteAllFriends();
    }

    public LiveData<List<Friend>> getAllFriends(){
        return allFriends;
    }

}
