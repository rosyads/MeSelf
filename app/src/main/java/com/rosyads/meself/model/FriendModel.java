package com.rosyads.meself.model;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

public class FriendModel {

    private String Title,Info;
    private int Thumbnail;

    public FriendModel() {
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public FriendModel(String title,String info, int thumbnail) {
        Title = title;
        Info = info;
        Thumbnail = thumbnail;

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
