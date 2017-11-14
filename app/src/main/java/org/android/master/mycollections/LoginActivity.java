package org.android.master.mycollections;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
    }

    protected void loginAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
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

    public void showPasswordAction(View v) {
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

}

