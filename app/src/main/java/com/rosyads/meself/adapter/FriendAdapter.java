package com.rosyads.meself.adapter;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rosyads.meself.R;
import com.rosyads.meself.model.FriendModel;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {

    private Context mContext;
    private List<FriendModel> mData;

    public FriendAdapter(Context mContext, List<FriendModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_friend,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.tv_friend_title.setText(mData.get(position).getTitle());
        myViewHolder.tv_friend_desc.setText(mData.get(position).getInfo());
        myViewHolder.img_friend_thumbnail.setImageResource(mData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_friend_title, tv_friend_desc;
        ImageView img_friend_thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_friend_title = (TextView) itemView.findViewById(R.id.friend_title_id);
            tv_friend_desc = (TextView) itemView.findViewById(R.id.friend_desc_id);
            img_friend_thumbnail = (ImageView) itemView.findViewById(R.id.friend_img_id);
        }
    }
}
