package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
    private static String KEY_LOGGED = "logged";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        TextView forgotPasswordButton = (TextView) findViewById(R.id.forgot_password);
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

    }

    public void loginAction(View view) {
        validateForm();
    }

    public void loginGoogleAction(View view) {
        String s = getString(R.string.validation1);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void forgetPasswordAction(View view) {
        String s = getString(R.string.forgotPAssword);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void signupAction(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void showPasswordAction(View v) {
        EditText contraseña = (EditText) findViewById(R.id.login_password);
        CheckBox mostrar = (CheckBox) findViewById(R.id.show_hide_password);

        if (mostrar.isChecked()) {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    public void validateForm() {
        String email = ((EditText) findViewById(R.id.login_emailid)).getText().toString();
        String password = ((EditText) findViewById(R.id.login_password)).getText().toString();
        String s1 = getString(R.string.validation4);
        String s2 = getString(R.string.validation5);

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);

        if (email.equals("") || email.isEmpty()
                || password.equals("") || password.isEmpty()) {

            Toast.makeText(this, s1, Toast.LENGTH_LONG).show();

        } else if (!matcher.find()) {

            Toast.makeText(this, s2, Toast.LENGTH_LONG).show();

        } else {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            i.putExtra(KEY_LOGGED, true);
            startActivity(i);
        }
    }
}

