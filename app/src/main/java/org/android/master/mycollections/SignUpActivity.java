package org.android.master.mycollections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    protected void loginAction(View view) {
        finish();
    }

    protected void loginGoogleAction(View view) {
        String s = "Acceder con tu cuenta de google.";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    protected void conditionAction(View view) {
        String s = "MENTIRA";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    protected void signupAction(View view) {
        finish();
    }
}
