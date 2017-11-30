package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    Button signUpBtn;
    EditText fullName, userEmailId, mobileNumber, location, password, confirmPassword;


    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpBtn = (Button)findViewById(R.id.signUpBtn);
        fullName = (EditText)findViewById(R.id.fullName);
        userEmailId = (EditText)findViewById(R.id.userEmailId);
        mobileNumber = (EditText)findViewById(R.id.mobileNumber);
        location = (EditText)findViewById(R.id.location);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,EditarPerfil.class);
                intent.putExtra("Name",fullName.getText().toString());
                intent.putExtra("Email",userEmailId.getText().toString());
                intent.putExtra("Telefono",mobileNumber.getText().toString());
                intent.putExtra("Direccion",location.getText().toString());
                startActivity(intent);

            }
            });
        }



    protected void loginAction(View view) {
        finish();
    }

    protected void loginGoogleAction(View view) {
        String s = getString(R.string.googleAccess);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    protected void conditionAction(View view) {
        String s = getString(R.string.lie);

        findViewById(R.id.signUpBtn).setEnabled(!findViewById(R.id.signUpBtn).isEnabled());
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    protected void signupAction(View view) {
        validateForm();
    }

    protected void validateForm() {
        String email = ((EditText) findViewById(R.id.userEmailId)).getText().toString();
        String password1 = ((EditText) findViewById(R.id.password)).getText().toString();
        String password2 = ((EditText) findViewById(R.id.confirmPassword)).getText().toString();
        String s1 = getString(R.string.validation1);
        String s2 = getString(R.string.validation2);
        String s3 = getString(R.string.validation3);

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);

        if (email.equals("") || email.isEmpty()
                || !matcher.find()) {

            Toast.makeText(this, s1, Toast.LENGTH_LONG).show();

        } else if (password1.equals("") || password1.isEmpty() || password2.equals("") || password2.isEmpty()) {

            Toast.makeText(this, s2, Toast.LENGTH_LONG).show();

        } else if(!password1.equals(password2)){

            Toast.makeText(this, s3, Toast.LENGTH_LONG).show();

        } else{
            finish();
        }
    }
}
