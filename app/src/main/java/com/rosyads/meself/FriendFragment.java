package com.rosyads.meself;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.rosyads.meself.adapter.FriendAdapter;
import com.rosyads.meself.model.FriendModel;

import java.util.ArrayList;
import java.util.List;

public class FriendFragment extends Fragment {

    List<FriendModel> friend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        EditText nama = (EditText) getView().findViewById(R.id.edit_nama);
        EditText info = (EditText) getView().findViewById(R.id.edit_info);

        final String Nama = nama.getText().toString().trim();
        final String Info = info.getText().toString().trim();

        //Activity
        friend = new ArrayList<>();
        friend.add(new FriendModel("Rijal Wrisaba","NIM : 10116367\nKelas : IF 8\nTelepon : +6282299588330\nEmail : rijalwrisaba@gmail.com\nInstagram : @rijalwris",R.drawable.img_rijal));
        friend.add(new FriendModel("Yudha Jeremy","NIM : 10116554\nKelas : IF 12\nTelepon : +6285320228870\nEmail : yudhje@gmail.com\nInstagram : @yudhajemmy",R.drawable.img_jemmy));
        friend.add(new FriendModel("Yola Argarani","NIM : 16210166\nKelas : A 2\nTelepon : +6282119615239\nEmail : yolaargarani@gmail.com\nInstagram : @yolaargarani",R.drawable.img_yols));

        RecyclerView rvFriend = (RecyclerView) getView().findViewById(R.id.rvFriend_id);
        final FriendAdapter friendAdapter = new FriendAdapter(getContext(), friend);
        rvFriend.setLayoutManager(new GridLayoutManager(getContext(),1));
        rvFriend.setAdapter(friendAdapter);

        final LinearLayout linearShow = (LinearLayout) getView().findViewById(R.id.button2);
        Button show = (Button) getView().findViewById(R.id.btn_editTeman);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearShow.setVisibility(View.VISIBLE);
                RecyclerView rvEdit = (RecyclerView) getView().findViewById(R.id.rvFriend_id);
                rvEdit.setLayoutManager(new GridLayoutManager(getContext(),1));
                rvEdit.setAdapter(friendAdapter);
            }
        });



        Button add = (Button) getView().findViewById(R.id.btn_add);
        Button edit = (Button) getView().findViewById(R.id.btn_edit);
        Button delete = (Button) getView().findViewById(R.id.btn_delete);
        Button close = (Button) getView().findViewById(R.id.btn_close);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friend.add(new FriendModel(Nama,Info,R.drawable.ic_add));
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearShow.setVisibility(View.GONE);
            }
        });



    }

}
