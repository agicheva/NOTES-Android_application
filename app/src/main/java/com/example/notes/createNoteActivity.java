package com.example.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class createNoteActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.notes.MESSAGE";

    private boolean isEditing = false;
    private int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        Intent intent = getIntent();
        int index = intent.getIntExtra(EXTRA_MESSAGE, -1);
        if(index != -1){
            EditText editText = (EditText) findViewById(R.id.editText2);
            editText.setText(NotesContainer.Notes.get(index));
            isEditing = true;
            currentIndex = index;
            Button deleteButton = (Button) findViewById(R.id.deleteButton);
            deleteButton.setVisibility(View.VISIBLE);
        }
    }

    public void saveNote(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String note = editText.getText().toString();
        if(!isEditing){
            NotesContainer.Notes.add(note);
        }
        else{
            NotesContainer.Notes.set(currentIndex, note);
        }
        startActivity(intent);
    }

    public void deleteNote(View view){
        NotesContainer.Notes.remove(currentIndex);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
