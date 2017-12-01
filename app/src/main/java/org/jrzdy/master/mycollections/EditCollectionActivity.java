package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * Created by nakis on 29/11/2017.
 */

public class EditCollectionActivity extends AppCompatActivity {

    public ImageView imagart;
    public String[]lista;
    public Button editarbtn;
    public Button borrarbtn;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdaptadormA adaptadormA;
    public AlmacenArticulos almacenArticulos=new AlmacenArticulos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcolectionnuevo);
        //imagart=(ImageView)findViewById(R.id.imagart);
        editarbtn=(Button)findViewById(R.id.lapizartbtn);
        borrarbtn=(Button)findViewById(R.id.papeleraartbtn);
//
        recyclerView=(RecyclerView)findViewById(R.id.recicladorarticulos);
        adaptadormA=new AdaptadormA(this,almacenArticulos.listaObjetos(0),almacenArticulos.listaFotos(0),almacenArticulos.cantidades(0));
        recyclerView.setAdapter(adaptadormA);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);


        adaptadormA.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=recyclerView.getChildAdapterPosition(v);
                String s=almacenArticulos.listaObjetos(0).get(pos);
                Intent i = new Intent(getApplicationContext(), NuevoArticulo.class);
                startActivity(i);
                Toast.makeText(EditCollectionActivity.this, "¡Viva!", Toast.LENGTH_SHORT).show();
            }
        });


        lista=new String[4];
        lista[0]="R.drawable.web_cab_circulo";
        lista[1]="R.drawable.cromomessi";
        lista[2]="R.drawable.reyemerito";
        lista[3]="R.drawable.dobla";
        //imagart.setImageResource(R.drawable.web_cab_circulo);


        FloatingActionButton mas = (FloatingActionButton)findViewById(R.id.masartFBnuevo);
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NuevoArticulo.class);
                startActivity(i);
            }
        });


        editarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewCollectionActivity.class);
                startActivity(i);
            }
        });
        borrarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditCollectionActivity.this, "Colección borrada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }




}
