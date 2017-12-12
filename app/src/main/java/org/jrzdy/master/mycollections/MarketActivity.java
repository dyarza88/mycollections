package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import java.util.ArrayList;

public class MarketActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ArrayList<Colecciones> listaColecciones;
    RecyclerAdapterr recyclerAdapterr;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        recyclerView = (RecyclerView) findViewById(R.id.rvColecciones);
        cargarColecciones();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_buscador, menu);
        MenuItem item = menu.findItem(R.id.buscador);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                recyclerAdapterr.setFilter(listaColecciones);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        try {
            ArrayList<Colecciones> listaFiltrada =filter(listaColecciones, s);
            recyclerAdapterr.setFilter(listaFiltrada);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private ArrayList<Colecciones> filter(ArrayList<Colecciones> colecciones, String texto) {
        ArrayList<Colecciones> listaFiltrada = new ArrayList<>();

        try {
            texto = texto.toLowerCase();
            for (Colecciones coleccion : colecciones) {
                String tituloColeccion = coleccion.getColeccion().toLowerCase();
                if (tituloColeccion.contains(texto)) {
                    listaFiltrada.add(coleccion);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFiltrada;
    }

    public void nuevaColeccion(MenuItem item){
        //Toast.makeText(getApplicationContext(), "Añadiendo nueva colección...", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, PublishCollectionActivity.class));
    }

    public void misColecciones(MenuItem item){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void cargarColecciones() {
        //Llamamos el recycler iniciamos y declaramos la orientacion
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        listaColecciones = new Colecciones().getlistaColecciones();

        if (listaColecciones != null) {
            recyclerAdapterr = new RecyclerAdapterr(listaColecciones, new RecyclerAdapterr.OnItemClickListener() {
                @Override
                //Obtenemos la posicion
                public void onItemClick(final int position) {
                    Toast.makeText(getApplicationContext(), "posiciòn " + position, Toast.LENGTH_LONG).show();
                }
            });

            recyclerView.setAdapter(recyclerAdapterr);
        }

    }
}