package com.rosyads.meself;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditFriendActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.rosyads.learnroom.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.rosyads.learnroom.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.rosyads.learnroom.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.rosyads.learnroom.EXTRA_PRIORITY";

    private EditText editTextTitle, editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_Priority);

        numberPickerPriority.setMaxValue(10);
        numberPickerPriority.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent s = getIntent();
        if(s.hasExtra(EXTRA_ID)){
            setTitle("Edit Friend");
            editTextTitle.setText(s.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(s.getStringExtra(EXTRA_DESCRIPTION));
            numberPickerPriority.setValue(s.getIntExtra(EXTRA_PRIORITY, 1));
        }else{
            setTitle("Add Friend");
        }


    }

    private void saveFriend(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please Insert Title and Description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.add_friend_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_friend:
                saveFriend();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
