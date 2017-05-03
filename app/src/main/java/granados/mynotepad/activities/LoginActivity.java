package granados.mynotepad.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import granados.mynotepad.R;
import granados.mynotepad.models.UserBL;
import granados.mynotepad.models.User;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    private EditText emailInput;
    private EditText passwordInput;
    private View loginPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = (EditText)findViewById(R.id.email_input);
        passwordInput = (EditText)findViewById(R.id.password_input);
        loginPanel = findViewById(R.id.login_panel);

        Button registrar = (Button) findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RegisterActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // init SharedPreferences
        sharedPreferences = this.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        // username remember
        String email = sharedPreferences.getString("email", null);
        if (email != null) {
            emailInput.setText(email);
            passwordInput.requestFocus();
        }

        // islogged remember
        if (sharedPreferences.getBoolean("islogged", false)) {
            // Go to Dashboard
            goDashboard();
        }

    }

    public void callLogin(View view) {
        loginPanel.setVisibility(View.GONE);

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }
        // Login logic
        User user = UserBL.login(email, password);

        if (user == null) {
            Toast.makeText(this, "Email or password invalid", Toast.LENGTH_SHORT).show();
            loginPanel.setVisibility(View.VISIBLE);
            return;
        }

        Toast.makeText(this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();

        // Save to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("email", user.getEmail())
                .putBoolean("islogged", true)
                .commit();

        // Go to Dashboard
        goDashboard();
    }

    private void goDashboard() {
        startActivity(new Intent(this, NotesListActivity.class));
        finish();
    }


}
