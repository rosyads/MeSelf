package com.rosyads.meself.model;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.rosyads.meself.model.FriendDAO;
import com.rosyads.meself.model.FriendModel;

@Database(entities = {FriendModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FriendDAO friendDAO();

}
