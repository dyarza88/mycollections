package org.jrzdy.master.mycollections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by esthe on 14/11/2017.
 */

public class EditarPerfil extends Activity {

    Button btnVolver, btnGuardar;
    EditText campoNombre, campoTelefono, campoCorreo, campoLocalidad;
    TextView tvInfoNombre, tvInfoTelefono, tvInfoCorreo, tvInfoLocalidad;
    public Context micontexto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_usuario);
        campoNombre = (EditText)findViewById(R.id.campo_nombre);
        campoTelefono = (EditText)findViewById(R.id.campo_telefono);
        campoCorreo = (EditText)findViewById(R.id.campo_correo);
        campoLocalidad = (EditText)findViewById(R.id.campo_localidad);
        btnVolver = (Button)findViewById(R.id.btnVolver);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);


        tvInfoNombre = (TextView)findViewById(R.id.campo_nombre);
        tvInfoTelefono = (TextView)findViewById(R.id.campo_telefono);
        tvInfoCorreo = (TextView)findViewById(R.id.campo_correo);
        tvInfoLocalidad = (TextView)findViewById(R.id.campo_localidad);

        micontexto=getApplicationContext();


        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("Nombre");
        tvInfoNombre.setText(dato);

        String dato2 = bundle.getString("Telefono");
        tvInfoTelefono.setText(dato2);

        String dato3 = bundle.getString("Email");
        tvInfoCorreo.setText(dato3);

        String dato4 = bundle.getString("Direccion");
        tvInfoLocalidad.setText(dato4);





        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver1 = new Intent(EditarPerfil.this, MainActivity.class);
                startActivity(volver1);
            }
        });

        FloatingActionButton camera = (FloatingActionButton)findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageSelectActivity.class);

                ActivityOptionsCompat options= ActivityOptionsCompat.makeSceneTransitionAnimation(
                        EditarPerfil.this,
                        new Pair<View, String>(v.findViewById(R.id.camara), getString(R.string.transition_name_camara)));
                ActivityCompat.startActivity(EditarPerfil.this, i, options.toBundle());

                //startActivity(i, ActivityOptions.makeSceneTransitionAnimation( ).toBundle());
            }
        });

    }


    @Override protected void onResume() {
        super.onResume();
        ImageSelectActivity.pantalla_foto=4;
    }

}
