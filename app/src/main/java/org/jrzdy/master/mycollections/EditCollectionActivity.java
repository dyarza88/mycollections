package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static org.jrzdy.master.mycollections.MainActivity.almacenArticulos;


/**
 * Created by nakis on 29/11/2017.
 */

public class EditCollectionActivity extends AppCompatActivity {

    private static int REQUEST_CODE_1 = 1234;
    private static String KEY_COLLECTION = "num_colecc";
    private static String KEY_POSITION = "num_col";
    private static String KEY_ARTICLE = "num_art";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdaptadormA adaptadormA;
    private int coleccion_pasada;
    public static int reinicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcolectionnuevo);

        Bundle extras = getIntent().getExtras();
        coleccion_pasada = extras.getInt(KEY_COLLECTION);
        getSupportActionBar().setTitle(getTitleForCode(coleccion_pasada));
        recyclerView = (RecyclerView) findViewById(R.id.recicladorarticulos);
        adaptadormA = new AdaptadormA(this, almacenArticulos.getCollecciones(coleccion_pasada),
                almacenArticulos.getImagcol(coleccion_pasada),
                almacenArticulos.getCantidades(coleccion_pasada));

        recyclerView.setAdapter(adaptadormA);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adaptadormA.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = recyclerView.getChildAdapterPosition(v);
                Intent i = new Intent(getApplicationContext(), EditArticleActivity.class);
                i.putExtra(KEY_ARTICLE, pos);
                i.putExtra(KEY_POSITION, coleccion_pasada);
                startActivityForResult(i, REQUEST_CODE_1);
            }
        });

        FloatingActionButton mas = (FloatingActionButton) findViewById(R.id.masartFBnuevo);
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NuevoArticulo.class);
                i.putExtra(KEY_POSITION, coleccion_pasada);
                startActivity(i);
            }
        });

    }

    private String getTitleForCode(int code) {
        switch (code) {
            case 0:
                return "Cromos";
            case 1:
                return "Muñecos Heman";
            case 2:
                return "sellos";
            case 3:
                return "Zapatos";
            case 4:
                return "Monedas";
            case 5:
                return "Comics ";
            default:
                return "Nueva Coleccion";
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageSelectActivity.pantalla_foto = 1;
        adaptadormA.updateAdaptadormA(this,
                almacenArticulos.getCollecciones(coleccion_pasada),
                almacenArticulos.getImagcol(coleccion_pasada),
                almacenArticulos.getCantidades(coleccion_pasada));
        adaptadormA.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editar_coleccion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_1 && requestCode == RESULT_OK) {
            //Do nothing since the logic is not implemented yet
        }
    }
}
