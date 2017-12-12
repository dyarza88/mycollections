package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewCollectionActivity extends AppCompatActivity {


    public Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevacoleccion);

        btn_guardar=(Button)findViewById(R.id.savenewcolection_btn);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewCollectionActivity.this, "Colección creada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        FloatingActionButton camera = (FloatingActionButton)findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageSelectActivity.class);
                i.putExtra("fte",1);
                //startActivity(i);
                ActivityOptionsCompat options= ActivityOptionsCompat.makeSceneTransitionAnimation(
                        NewCollectionActivity.this,
                        new Pair<View, String>(v.findViewById(R.id.camara), getString(R.string.transition_name_camara)));
                ActivityCompat.startActivity(NewCollectionActivity.this, i, options.toBundle());

            }
        });


    }

    @Override protected void onResume() {
        super.onResume();
        ImageSelectActivity.pantalla_foto=1;

    }

}
