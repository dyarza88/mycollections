package org.android.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
    }

    protected void loginAction(View view) {
        validateForm();
    }

    protected void loginGoogleAction(View view) {
        String s = "Acceder con tu cuenta de google.";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    protected void forgetPasswordAction(View view) {
        String s = "HE OLVIDADO MI CONTRASEÑA";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    protected void signupAction(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    protected void showPasswordAction(View v) {
        EditText contraseña = (EditText) findViewById(R.id.login_password);
        CheckBox mostrar = (CheckBox) findViewById(R.id.show_hide_password);

        if (mostrar.isChecked()) {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    protected void validateForm() {
        String email = ((EditText) findViewById(R.id.login_emailid)).getText().toString();
        String password = ((EditText) findViewById(R.id.login_password)).getText().toString();
        String s1 = "Introduce tus credenciales.";
        String s2 = "Introduce una dirección de email correcta.";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);

        if (email.equals("") || email.isEmpty()
                || password.equals("") || password.isEmpty()) {

            Toast.makeText(this, s1, Toast.LENGTH_LONG).show();

        } else if (!matcher.find()) {

            Toast.makeText(this, s2, Toast.LENGTH_LONG).show();

        } else {
            finish();
        }
    }
}

