package granados.mynotepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterNotesActivity extends AppCompatActivity {
    private EditText titleInput;
    private Spinner spinnerInput;
    private EditText descriptionInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_notes);

        titleInput = (EditText)findViewById(R.id.title_input);
        spinnerInput = (Spinner) findViewById(R.id.spinner_input);
        descriptionInput = (EditText)findViewById(R.id.description_input);
    }

    public void callRegisterNotes(View view){
        String title = titleInput.getText().toString();
        String type = spinnerInput.getSelectedItem().toString();
        String description = descriptionInput.getText().toString();

        if(title.isEmpty() || type.isEmpty() || description.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        NoteRepository.create(title, type, description);

        finish();

    }

}