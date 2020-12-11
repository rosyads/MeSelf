package com.rosyads.meself.model;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class FriendRepository {
    private FriendDAO friendDAO;
    private LiveData<List<Friend>> allFriends;

    public FriendRepository(Application application){
        FriendDatabase database = FriendDatabase.getInstance(application);
        friendDAO = database.friendDAO();
        allFriends = friendDAO.getAllFriends();
    }

    public void insert(Friend friend){
        new InsertFriendAsyncTask(friendDAO).execute(friend);
    }

    public void update(Friend friend){
        new UpdateFriendAsyncTask(friendDAO).execute(friend);
    }

    public void delete(Friend friend){
        new DeleteFriendAsyncTask(friendDAO).execute(friend);
    }

    public void deleteAllFriends(){
        new DeleteAllFriendsAsyncTask(friendDAO).execute();
    }

    public LiveData<List<Friend>> getAllFriends(){
        return allFriends;
    }

    private static class InsertFriendAsyncTask extends AsyncTask<Friend, Void, Void>{
        private FriendDAO friendDAO;

        private InsertFriendAsyncTask(FriendDAO friendDAO){
            this.friendDAO = friendDAO;
        }

        @Override
        protected Void doInBackground(Friend... friends) {
            friendDAO.insert(friends[0]);
            return null;
        }
    }

    private static class UpdateFriendAsyncTask extends AsyncTask<Friend, Void, Void>{
        private FriendDAO friendDAO;

        private UpdateFriendAsyncTask(FriendDAO friendDAO){
            this.friendDAO = friendDAO;
        }

        @Override
        protected Void doInBackground(Friend... friends) {
            friendDAO.update(friends[0]);
            return null;
        }
    }

    private static class DeleteFriendAsyncTask extends AsyncTask<Friend, Void, Void>{
        private FriendDAO friendDAO;

        private DeleteFriendAsyncTask(FriendDAO friendDAO){
            this.friendDAO = friendDAO;
        }

        @Override
        protected Void doInBackground(Friend... friends) {
            friendDAO.delete(friends[0]);
            return null;
        }
    }

    private static class DeleteAllFriendsAsyncTask extends AsyncTask<Void, Void, Void>{
        private FriendDAO friendDAO;

        private DeleteAllFriendsAsyncTask(FriendDAO friendDAO){
            this.friendDAO = friendDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            friendDAO.deleteAllFriends();
            return null;
        }
    }

}
