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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

import static org.jrzdy.master.mycollections.AlmacenArticulos.getV_articulo;
import static org.jrzdy.master.mycollections.AlmacenArticulos.getV_imagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.getV_precio;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setV_articulo;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setV_imagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setV_precio;
import static org.jrzdy.master.mycollections.ImageSelectActivity.pantalla_foto;

/**
 * Created by nakis on 02/12/2017.
 */

public class EditArticleActivity extends AppCompatActivity {

    private static String KEY_ARTICLE = "num_art";
    private static String KEY_POSITION = "num_col";
    private static String KEY_FTE = "fte";
    private static String KEY_MY_COL = "mi_colec";
    private static String KEY_MY_ART = "mi_artic";
    public int posicionArticulo;
    public int posicionColeccion;
    public String nombreArticulo;
    public String precioArticulo;
    public String tituloColeccion;
    public int fotoArticulo;
    public TextView nombreTV;
    public TextView precioTV;
    public ImageView fotoIV;
    public EditText descripcionET;
    public TextView tituloColeccionTV;
    public Button botonGuardar;
    public Button botonBorrar;

    public static int reinicio_editar_articulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editarticulo);
        inicializarVariables();
        mostrarDatosIniciales();
        tituloColeccion = MainActivity.almacenColecciones.getColecciones().get(posicionColeccion);
        tituloColeccionTV.setText(tituloColeccion);
        FloatingActionButton camera = (FloatingActionButton) findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageSelectActivity.class);
                i.putExtra(KEY_FTE, 2);
                pantalla_foto = 2;
                i.putExtra(KEY_MY_COL, posicionColeccion);
                i.putExtra(KEY_MY_ART, posicionArticulo);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        EditArticleActivity.this,
                        new Pair<View, String>(v.findViewById(R.id.camara), getString(R.string.transition_name_camara)));
                ActivityCompat.startActivity(EditArticleActivity.this, i, options.toBundle());
            }
        });

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarArticulo();
                finish();
                return;
            }
        });

        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarArticulo();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarDatosIniciales();
    }

    private void inicializarVariables() {
        fotoArticulo = R.drawable.web_cab_circulo;
        nombreArticulo = "";
        precioArticulo = "";
        tituloColeccion = "";
        tituloColeccionTV = (TextView) findViewById(R.id.titulocolecceditart);
        nombreTV = (TextView) findViewById(R.id.nombre_editar_articulo);
        precioTV = (TextView) findViewById(R.id.precio_editar_articulo);
        fotoIV = (ImageView) findViewById(R.id.imagen_editar_articulo);
        descripcionET = (EditText) findViewById(R.id.descripc_editar_articulo);
        botonBorrar = (Button) findViewById(R.id.borrar_editar_articulo);
        botonGuardar = (Button) findViewById(R.id.guardar_editar_articulo);
    }

    private void recogerDatos() {
        nombreArticulo = nombreTV.getText().toString();
        precioArticulo = precioTV.getText().toString();
        fotoArticulo = getV_imagart().get(posicionColeccion).get(posicionArticulo);
    }

    private void mostrarDatosIniciales() {
        Bundle extras = getIntent().getExtras();
        posicionArticulo = extras.getInt(KEY_ARTICLE);
        posicionColeccion = extras.getInt(KEY_POSITION);
        fotoIV.setImageResource(getV_imagart().get(posicionColeccion).get(posicionArticulo));

        Vector<String> articulos = new Vector<String>();
        Vector<String> precio = new Vector<String>();
        Vector<Integer> imagart = new Vector<Integer>();
        Vector<Vector<String>> miv_articulo = getV_articulo();
        Vector<Vector<String>> miv_precio = getV_precio();
        Vector<Vector<Integer>> miv_imagart = getV_imagart();

        for (int j = 0; j < miv_articulo.get(posicionColeccion).size(); j++) {
            articulos.add(j, miv_articulo.get(posicionColeccion).get(j));
            precio.add(j, miv_precio.get(posicionColeccion).get(j));
            imagart.add(j, miv_imagart.get(posicionColeccion).get(j));
        }

        nombreArticulo = articulos.get(posicionArticulo);
        precioArticulo = precio.get(posicionArticulo);
        fotoArticulo = imagart.get(posicionArticulo);

        try {
            if (nombreTV.getText().equals("")) {
                nombreTV.setText(nombreArticulo);
            }
            if (precioTV.getText().equals("")) {
                precioTV.setText(precioArticulo);
            }
            fotoIV.setImageResource(fotoArticulo);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void editarArticulo() {
        recogerDatos();
        Vector<String> articulos = new Vector<String>();
        Vector<String> precio = new Vector<String>();
        Vector<Integer> imagart = new Vector<Integer>();
        Vector<Vector<String>> miv_articulo = getV_articulo();
        Vector<Vector<String>> miv_precio = getV_precio();
        Vector<Vector<Integer>> miv_imagart = getV_imagart();

        int j = 0;
        for (j = 0; j < miv_articulo.get(posicionColeccion).size(); j++) {

            articulos.add(j, miv_articulo.get(posicionColeccion).get(j));
            precio.add(j, miv_precio.get(posicionColeccion).get(j));
            imagart.add(j, miv_imagart.get(posicionColeccion).get(j));
        }

        articulos.set(posicionArticulo, nombreArticulo);
        precio.set(posicionArticulo, precioArticulo);
        imagart.set(posicionArticulo, fotoArticulo);

        miv_articulo.set(posicionColeccion, articulos);
        miv_precio.set(posicionColeccion, precio);
        miv_imagart.set(posicionColeccion, imagart);

        setV_articulo(miv_articulo);
        setV_precio(miv_precio);
        setV_imagart(miv_imagart);
    }

    private void borrarArticulo() {
        recogerDatos();
        Vector<String> articulos = new Vector<String>();
        Vector<String> precio = new Vector<String>();
        Vector<Integer> imagart = new Vector<Integer>();
        Vector<Vector<String>> miv_articulo = getV_articulo();
        Vector<Vector<String>> miv_precio = getV_precio();
        Vector<Vector<Integer>> miv_imagart = getV_imagart();

        int j = 0;
        for (j = 0; j < miv_articulo.get(posicionColeccion).size(); j++) {
            //memorizo la fila
            articulos.add(j, miv_articulo.get(posicionColeccion).get(j));
            precio.add(j, miv_precio.get(posicionColeccion).get(j));
            imagart.add(j, miv_imagart.get(posicionColeccion).get(j));
        }

        if (articulos.size() < 1) {
            articulos.remove(posicionArticulo);
            precio.remove(posicionArticulo);
            imagart.remove(posicionArticulo);
        } else {
            articulos.set(posicionArticulo, "Añadir Articulo");
            precio.set(posicionArticulo, "");
            imagart.set(posicionArticulo, R.drawable.web_cab_circulo);
        }

        miv_articulo.set(posicionColeccion, articulos);
        miv_precio.set(posicionColeccion, precio);
        miv_imagart.set(posicionColeccion, imagart);

        setV_articulo(miv_articulo);
        setV_precio(miv_precio);
        setV_imagart(miv_imagart);

        nombreTV.setText("");
        precioTV.setText("");
        fotoIV.setImageResource(R.drawable.web_cab_circulo);
    }
}