package org.android.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Vector;

import static org.android.master.mycollections.MainActivity.almacenArticulos;
import static org.android.master.mycollections.MainActivity.almacenColecciones;

/**
 * Created by nakis on 29/11/2017.
 */

public class EditCollectionActivity extends AppCompatActivity {

    public ImageView imagart;
    public String[]lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcollection);
        imagart=(ImageView)findViewById(R.id.imagart);
        lista=new String[4];
        lista[0]="R.drawable.web_cab_circulo";
        lista[1]="R.drawable.cromomessi";
        lista[2]="R.drawable.reyemerito";
        lista[3]="R.drawable.dobla";
        imagart.setImageResource(R.drawable.web_cab_circulo);


        FloatingActionButton mas = (FloatingActionButton)findViewById(R.id.masartFB);
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NuevoArticulo.class);
                startActivity(i);
            }
        });


        FloatingActionButton lapiz = (FloatingActionButton)findViewById(R.id.lapizartFB);
        lapiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewCollectionActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton papelera = (FloatingActionButton)findViewById(R.id.papeleraartFB);
        papelera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Colección borrada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }




}
