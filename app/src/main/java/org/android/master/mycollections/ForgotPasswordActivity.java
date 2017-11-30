package org.android.master.mycollections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {


    public String usuario_de_inicio_sesion;
    public EditText editText_email;
    public String el_email;
    public String casilla_vacia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olvidoclave);

        //Bundle extras=getIntent().getExtras();
        //usuario_de_inicio_sesion=extras.getString("usuario");

        editText_email=(EditText)findViewById(R.id.editText_email);
        casilla_vacia=editText_email.getText().toString();
        //editText_email.setText(usuario_de_inicio_sesion);

        el_email="";


    }

    public void enviarNuevaClave_porolvido(View view){
        el_email=editText_email.getText().toString();

        if(el_email.equals(casilla_vacia)){
            Toast.makeText(this, "Rellene el campo de e-mail para enviarle una nueva contraseña", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Le acabamos de mandar una nueva contraseña. \n Mire en su bandeja de entrada", Toast.LENGTH_LONG).show();
        }

    }

}
