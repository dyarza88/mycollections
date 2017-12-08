package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static org.jrzdy.master.mycollections.MainActivity.almacenArticulos;


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
    //public static AlmacenArticulos almacenArticulos=new AlmacenArticulos();
    private int coleccion_pasada;
    public static int reinicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcolectionnuevo);

        Bundle extras=getIntent().getExtras();
        coleccion_pasada=extras.getInt("num_colecc");
        //imagart=(ImageView)findViewById(R.id.imagart);

        reinicio=0;


        //editarbtn=(Button)findViewById(R.id.lapizartbtn);
        //borrarbtn=(Button)findViewById(R.id.papeleraartbtn);
//
        recyclerView=(RecyclerView)findViewById(R.id.recicladorarticulos);
        //antes
        //adaptadormA=new AdaptadormA(this,almacenArticulos.listaObjetos(0),almacenArticulos.listaFotos(0),almacenArticulos.cantidades(0));
        //ahora
        adaptadormA=new AdaptadormA(this,almacenArticulos.listaObjetos(coleccion_pasada),almacenArticulos.listaFotos(coleccion_pasada),almacenArticulos.cantidades(coleccion_pasada));

        recyclerView.setAdapter(adaptadormA);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adaptadormA.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=recyclerView.getChildAdapterPosition(v);
                //String s=almacenArticulos.listaObjetos(0).get(pos);
                Intent i = new Intent(getApplicationContext(), Editararticulo.class);
                i.putExtra("num_art",pos);
                i.putExtra("num_col",coleccion_pasada);
                //startActivity(i);
                startActivityForResult(i,1234);
                Toast.makeText(EditCollectionActivity.this, "¡Viva!", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton mas = (FloatingActionButton)findViewById(R.id.masartFBnuevo);
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NuevoArticulo.class);
                i.putExtra("nuevoart_c",coleccion_pasada);
                startActivity(i);
            }
        });

    }

    @Override protected void onResume() {
        super.onResume();
        ImageSelectActivity.pantalla_foto=1;
        Toast.makeText(this, "onResume EditCollection", Toast.LENGTH_SHORT).show();
        adaptadormA.notifyDataSetChanged();
        if(reinicio==1){
            finish();
            startActivity(getIntent());
        }

    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editar_coleccion, menu);
        return true;
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.editarcoleccion) {
            Intent i = new Intent(getApplicationContext(), NewCollectionActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.borrarcoleccion) {
            Toast.makeText(EditCollectionActivity.this, "Colección borrada", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==1234&&requestCode==RESULT_OK){
            //Hacer algo
            //imagart=data.getExtras().getInt("numerofoto");
            //finish();
            //startActivity(getIntent());
            //reinicio= data.getExtras().getInt("resultado");
        }
    }




}
