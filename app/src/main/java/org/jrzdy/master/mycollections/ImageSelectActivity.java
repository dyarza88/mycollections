package org.jrzdy.master.mycollections;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Vector;

import static org.jrzdy.master.mycollections.AlmacenArticulos.getvImagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setvImagart;
import static org.jrzdy.master.mycollections.NuevoArticuloActivity.fotonuevoarticulo;

public class ImageSelectActivity extends AppCompatActivity {

    private static String KEY_MY_COL = "mi_colec";
    private static String KEY_MY_ART = "mi_artic";

    public int pantalla; // valores a tomar: i=1,,coleccion; i=2,,articulo
    public int foto_R_drawable_x;
    public Drawable mi_drawable;
    public ImageView imagen;
    public int mi_colec, mi_artic, puntero_lista;
    public int[] lista_articulos, lista_colecciones, lista_perfiles;
    public static int pantalla_foto;

    //TODO Refactor this code in order to accomplish good practices

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectorimagenes);

        Bundle extras = getIntent().getExtras();
        pantalla = pantalla_foto;

        foto_R_drawable_x = R.drawable.web_cab_circulo;
        imagen = (ImageView) findViewById(R.id.imagenselectorimagen);
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);

        puntero_lista = 0;
        lista_articulos = new int[6];
        lista_articulos[0] = R.drawable.web_cab_circulo;
        lista_articulos[1] = R.drawable.cromomessi;
        lista_articulos[2] = R.drawable.reyemerito;
        lista_articulos[3] = R.drawable.dobla;
        lista_articulos[4] = R.drawable.heman;
        lista_articulos[5] = R.drawable.zapato;
        lista_colecciones = new int[6];
        lista_colecciones[0] = R.drawable.web_cab_circulo;
        lista_colecciones[1] = R.drawable.coleccion_cromos;
        lista_colecciones[2] = R.drawable.coleccion_sellos;
        lista_colecciones[3] = R.drawable.coins_collection;
        lista_colecciones[4] = R.drawable.coleccion_heman;
        lista_colecciones[5] = R.drawable.shoes_collection;
        lista_perfiles = new int[2];
        lista_perfiles[0] = R.drawable.web_cab_circulo;
        lista_perfiles[1] = R.drawable.coche;

        switch (pantalla) {
            case 1:
                //buscafotos=MainActivity.almacenColecciones.getImagcol(0);
                //tamaño_buscafotos=buscafotos.size();
                break;
            case 2:
                mi_colec = extras.getInt(KEY_MY_COL);
                mi_artic = extras.getInt(KEY_MY_ART);
                foto_R_drawable_x = getvImagart().get(mi_colec).get(mi_artic);
                mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                imagen.setImageDrawable(mi_drawable);
                break;
            default:
                break;

        }

        FloatingActionButton camera = (FloatingActionButton) findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFoto(null);

            }
        });
        FloatingActionButton galeria = (FloatingActionButton) findViewById(R.id.galeriaselectorimagen);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFoto(null);

            }
        });
        FloatingActionButton caballo = (FloatingActionButton) findViewById(R.id.caballoselectorimagen);
        caballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pantalla == 2) {
                    puntero_lista = 0;
                    pon_caballo_en_articulo();
                }
                if (pantalla == 1) {
                    puntero_lista = 0;
                    pon_caballo_en_coleccion();
                }
                if (pantalla == 3) {
                    puntero_lista = 0;
                    foto_R_drawable_x = lista_articulos[puntero_lista];
                    mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                    imagen.setImageDrawable(mi_drawable);
                    fotonuevoarticulo = R.drawable.web_cab_circulo;
                }
                if (pantalla == 4) {
                    puntero_lista = 0;
                    pon_caballo_en_perfil();
                }
            }
        });
    }

    public void cambia_ptr() {
        if (pantalla == 2 || pantalla == 3) {
            if (puntero_lista < lista_articulos.length - 1) {
                puntero_lista++;
            } else {
                puntero_lista = 0;
            }
        }
        if (pantalla == 1) {
            if (puntero_lista < lista_colecciones.length - 1) {
                puntero_lista++;
            } else {
                puntero_lista = 0;
            }
        }
        if (pantalla == 4) {
            if (puntero_lista < lista_perfiles.length - 1) {
                puntero_lista++;
            } else {
                puntero_lista = 0;
            }
        }
    }

    public void cambiaFoto(View view) {
        cambia_ptr();

        switch (pantalla) {
            case 4:
                foto_R_drawable_x = lista_perfiles[puntero_lista];
                mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                imagen.setImageDrawable(mi_drawable);
                break;

            case 3:
                foto_R_drawable_x = lista_articulos[puntero_lista];
                mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                imagen.setImageDrawable(mi_drawable);
                fotonuevoarticulo = foto_R_drawable_x;
                break;
            case 2:
                foto_R_drawable_x = lista_articulos[puntero_lista];
                mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                imagen.setImageDrawable(mi_drawable);
                editar_articulo();
                break;
            case 1:
                foto_R_drawable_x = lista_colecciones[puntero_lista];
                mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                imagen.setImageDrawable(mi_drawable);
                editar_coleccion();
                break;
        }
    }

    public void pon_caballo_en_articulo() {
        foto_R_drawable_x = R.drawable.web_cab_circulo;
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);
        //guardar cambios
        editar_articulo();
    }

    public void pon_caballo_en_coleccion() {
        foto_R_drawable_x = R.drawable.web_cab_circulo;
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);
        //guardar cambios
        editar_coleccion();
    }

    public void pon_caballo_en_perfil() {
        foto_R_drawable_x = R.drawable.web_cab_circulo;
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);
    }

    public void editar_articulo() {
        Vector<Integer> imagart;
        imagart = new Vector<Integer>();

        Vector<Vector<Integer>> miv_imagart;
        miv_imagart = getvImagart();

        int j = 0;
        for (j = 0; j < miv_imagart.get(mi_colec).size(); j++) {
            imagart.add(j, miv_imagart.get(mi_colec).get(j));
        }

        imagart.set(mi_artic, foto_R_drawable_x);
        miv_imagart.set(mi_colec, imagart);
        setvImagart(miv_imagart);
    }

    public void editar_coleccion() {
        // do nothing bc its not implemented yet
    }

    public void closeActivity(View view) {
        finish();
        return;
    }
}
