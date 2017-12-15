package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

import static org.jrzdy.master.mycollections.AlmacenArticulos.getvArticulo;
import static org.jrzdy.master.mycollections.AlmacenArticulos.getvImagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.getvPrecio;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setvArticulo;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setvImagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setvPrecio;
import static org.jrzdy.master.mycollections.ImageSelectActivity.pantalla_foto;

/**
 * Created by nakis on 30/11/2017.
 */

public class NuevoArticuloActivity extends AppCompatActivity {

    private static String KEY_POSITION = "num_col";
    private static String KEY_FTE = "fte";
    public static int fotonuevoarticulo = R.drawable.web_cab_circulo;
    public int indice_colecc;

    public TextView nombre_TV;
    public TextView precio_TV;
    public ImageView imagen_IV;
    public Button guardar_btn;
    public TextView titulocoleccion_TV;

    public String nombre;
    public String precio;
    public int foto;
    public String titulocoleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevoarticulo);

        Bundle extras = getIntent().getExtras();
        indice_colecc = extras.getInt(KEY_POSITION);

        nombre = "";
        precio = "";
        titulocoleccion = MainActivity.almacenColecciones.getColecciones().get(indice_colecc);

        nombre_TV = (TextView) findViewById(R.id.nombre_nuevo_articulo);
        precio_TV = (TextView) findViewById(R.id.precio_nuevo_articulo);
        imagen_IV = (ImageView) findViewById(R.id.id_img_art_A);
        guardar_btn = (Button) findViewById(R.id.guardar_nuevo_articulo);
        titulocoleccion_TV = (TextView) findViewById(R.id.titulocolecceditart);
        titulocoleccion_TV.setText(titulocoleccion);
        pantalla_foto = 3;

        FloatingActionButton camera = (FloatingActionButton) findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageSelectActivity.class);
                i.putExtra(KEY_FTE, 2);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        NuevoArticuloActivity.this,
                        new Pair<View, String>(v.findViewById(R.id.camara), getString(R.string.transition_name_camara)));
                ActivityCompat.startActivity(NuevoArticuloActivity.this, i, options.toBundle());
            }
        });


        guardar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoger_datos();
                insertar_articulo();
                finish();
                return;
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        imagen_IV.setImageResource(fotonuevoarticulo);
        foto = fotonuevoarticulo;
    }

    public void recoger_datos() {
        nombre = nombre_TV.getText().toString();
        precio = precio_TV.getText().toString();
    }

    public void insertar_articulo() {
        Vector<String> articulos = new Vector<>();
        Vector<String> precios = new Vector<>();
        Vector<Integer> imagart = new Vector<>();
        Vector<Vector<String>> miv_articulo = getvArticulo();
        Vector<Vector<String>> miv_precio = getvPrecio();
        Vector<Vector<Integer>> miv_imagart = getvImagart();

        for (int j = 0; j < miv_articulo.get(indice_colecc).size(); j++) {

            articulos.add(j, miv_articulo.get(indice_colecc).get(j));
            precios.add(j, miv_precio.get(indice_colecc).get(j));
            imagart.add(j, miv_imagart.get(indice_colecc).get(j));

        }
        articulos.add(miv_articulo.get(indice_colecc).size(), nombre);
        precios.add(miv_precio.get(indice_colecc).size(), precio);
        imagart.add(miv_imagart.get(indice_colecc).size(), foto);

        miv_articulo.set(indice_colecc, articulos);
        miv_precio.set(indice_colecc, precios);
        miv_imagart.set(indice_colecc, imagart);

        setvArticulo(miv_articulo);
        setvPrecio(miv_precio);
        setvImagart(miv_imagart);
    }
}

