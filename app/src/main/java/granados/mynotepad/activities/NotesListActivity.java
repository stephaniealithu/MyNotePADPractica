package granados.mynotepad.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import granados.mynotepad.R;
import granados.mynotepad.business.NoteAdapter;
import granados.mynotepad.business.NoteRepository;
import granados.mynotepad.models.Note;

public class NotesListActivity extends AppCompatActivity {

    private static final String TAG = NotesListActivity.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private SharedPreferences sharedPreferences;
    private RecyclerView notesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        // Configure ReciclerView
        notesList = (RecyclerView) findViewById(R.id.note_list);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<Note> notes = NoteRepository.list();
        notesList.setAdapter(new NoteAdapter(notes));

        // init SharedPreferences
        sharedPreferences = this.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        // get username from SharedPreferences
        String email = sharedPreferences.getString("email", null);
        Log.d(TAG, "email: " + email);


    }

    public void callLogout(View view) {
        // remove from SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor.putBoolean("islogged", false).commit();
//        boolean success = editor.clear().commit(); // not recommended

        finish();
    }


    public void callRegisterNotesForm(View view){
        startActivityForResult(new Intent(this, RegisterNotesActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterNotesActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NoteAdapter adapter = (NoteAdapter)notesList.getAdapter();

        List<Note> notes = NoteRepository.list();
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }
}
