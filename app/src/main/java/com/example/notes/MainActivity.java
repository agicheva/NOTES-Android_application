package com.example.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int length = NotesContainer.Notes.size();
    public static final String EXTRA_MESSAGE = "com.example.notes.MESSAGE";
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.notesList);
        adapter = new ArrayAdapter(this, R.layout.activity_list_view, NotesContainer.Notes);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long args){
                editNote(position);
            }
        });

    }

    public void createNote(View view){
        Intent intent = new Intent (this, createNoteActivity.class);
        startActivity(intent);
    }

    public void editNote(int noteIndex){
        Intent intent = new Intent (this, createNoteActivity.class);
        intent.putExtra(EXTRA_MESSAGE, noteIndex);
        startActivity(intent);
    }
}
