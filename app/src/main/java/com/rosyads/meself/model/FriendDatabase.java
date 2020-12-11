package com.rosyads.meself.model;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = Friend.class,version = 1)
public abstract class FriendDatabase extends RoomDatabase {

    private static FriendDatabase instance;

    public abstract FriendDAO friendDAO();

    public static synchronized FriendDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FriendDatabase.class, "friend_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallBack = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private FriendDAO friendDAO;

        private PopulateDbAsyncTask(FriendDatabase db){
            friendDAO = db.friendDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            friendDAO.insert(new Friend("Rijal Wrisaba R.", "NIM : 10116367\n" +
                    "Kelas : IF 8\nTelepon : +6282299588330\nEmail : rijalwrisaba@gmail.com\n" +
                    "Instagram : @rijalwris", 1));
            friendDAO.insert(new Friend("Yudha Jeremy Y.", "NIM : 10116554\n" +
                    "Kelas : IF 12\nTelepon : +6285320228870\nEmail : yudhje@gmail.com\n" +
                    "Instagram : @yudhajemmy", 2));
            friendDAO.insert(new Friend("Yola A.", "NIM : 16210166\nKelas : A 2\n" +
                    "Telepon : +6282119615239\nEmail : yolaargarani@gmail.com\n" +
                    "Instagram : @yolaargarani", 3));
            return null;
        }
    }

}
