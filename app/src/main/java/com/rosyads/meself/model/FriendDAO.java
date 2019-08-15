package com.rosyads.meself.model;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

public interface FriendDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFriend(FriendModel friend);
}
