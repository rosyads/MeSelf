package com.rosyads.meself;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rosyads.meself.adapter.FriendAdapter;
import com.rosyads.meself.model.Friend;
import com.rosyads.meself.model.FriendViewModel;

import java.util.List;

public class FriendActivity extends AppCompatActivity {
    public static final int ADD_FRIEND_REQUEST = 1;
    public static final int EDIT_FRIEND_REQUEST = 2;

    private FriendViewModel friendViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton btnAddFriend = findViewById(R.id.btn_add_friend);
        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(FriendActivity.this, AddEditFriendActivity.class);
                startActivityForResult(s, ADD_FRIEND_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final FriendAdapter adapter = new FriendAdapter();
        recyclerView.setAdapter(adapter);

        friendViewModel = ViewModelProviders.of(this).get(FriendViewModel.class);
        friendViewModel.getAllFriends().observe(this, new Observer<List<Friend>>() {
            @Override
            public void onChanged(@Nullable List<Friend> friends) {
                adapter.setFriends(friends);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                friendViewModel.delete(adapter.getFriendAt(viewHolder.getAdapterPosition()));
                Toast.makeText(FriendActivity.this, "Friend Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new FriendAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Friend friend) {
                Intent s = new Intent(FriendActivity.this, AddEditFriendActivity.class);
                s.putExtra(AddEditFriendActivity.EXTRA_ID, friend.getId());
                s.putExtra(AddEditFriendActivity.EXTRA_TITLE, friend.getTitle());
                s.putExtra(AddEditFriendActivity.EXTRA_DESCRIPTION, friend.getDescription());
                s.putExtra(AddEditFriendActivity.EXTRA_PRIORITY, friend.getPriority());
                startActivityForResult(s, EDIT_FRIEND_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_FRIEND_REQUEST && resultCode == RESULT_OK){
            String title = data.getStringExtra(AddEditFriendActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditFriendActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditFriendActivity.EXTRA_PRIORITY,1);

            Friend friend = new Friend(title, description, priority);
            friendViewModel.insert(friend);

            Toast.makeText(this, "Friend Saved", Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_FRIEND_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(AddEditFriendActivity.EXTRA_ID, -1);
            if(id == 1){
                Toast.makeText(this, "Friend can't be Updated", Toast.LENGTH_SHORT).show();
                return;
            }

            String title = data.getStringExtra(AddEditFriendActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditFriendActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditFriendActivity.EXTRA_PRIORITY,1);

            Friend friend = new Friend(title, description, priority);
            friend.setId(id);
            friendViewModel.update(friend);

            Toast.makeText(this, "Friend updated", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Friend not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_all_friends:
                friendViewModel.deleteAllFriends();
                Toast.makeText(this, "All friends deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
