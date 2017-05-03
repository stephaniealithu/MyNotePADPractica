package granados.mynotepad.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import granados.mynotepad.R;
import granados.mynotepad.models.User;
import granados.mynotepad.models.UserBL;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();

    private EditText fullname;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fullname = (EditText) findViewById(R.id.fullname_input);
        email = (EditText) findViewById(R.id.email_input);
        password = (EditText) findViewById(R.id.password_input);
    }

    public void callRegisterUser(View view) {
        User user = new User();
        user.setFullname(fullname.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());

        UserBL.registrar(user);

        finish();

    }


}
