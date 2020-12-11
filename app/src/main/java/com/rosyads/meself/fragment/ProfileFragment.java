package com.rosyads.meself.fragment;
/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rosyads.meself.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    CardView facebookCard, instagramCard, gitCard, aboutCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        facebookCard = (CardView) getView().findViewById(R.id.card_facebook);
        instagramCard = (CardView) getView().findViewById(R.id.card_instagram);
        gitCard = (CardView) getView().findViewById(R.id.card_git);
        aboutCard = (CardView) getView().findViewById(R.id.card_about);

        facebookCard.setOnClickListener(this);
        instagramCard.setOnClickListener(this);
        gitCard.setOnClickListener(this);
        aboutCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.card_facebook:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/RosyadSulaiman")));

                break;

            case R.id.card_instagram:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/rosyads/")));

                break;
            case R.id.card_git:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/rosyads")));

                break;
            case R.id.card_about:
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.custom_dialog);
                dialog.show();


        }


    }
}
