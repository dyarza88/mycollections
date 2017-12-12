package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Vector;

import static org.jrzdy.master.mycollections.AlmacenArticulos.getV_articulo;
import static org.jrzdy.master.mycollections.AlmacenArticulos.getV_imagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.getV_precio;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setV_articulo;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setV_imagart;
import static org.jrzdy.master.mycollections.AlmacenArticulos.setV_precio;
import static org.jrzdy.master.mycollections.Editararticulo.reinicio_editar_articulo;
import static org.jrzdy.master.mycollections.NuevoArticulo.fotonuevoarticulo;
import static org.jrzdy.master.mycollections.NuevoArticulo.reinicio_pantalla_nuevo_articulo;

public class ImageSelectActivity extends AppCompatActivity {

    //esta clase va a comprobar (en función del getextras() ) qué actividad le ha llamado
    //y en función de ésto, propone una serie de fotos a mostrar

    public int pantalla; // valores a tomar: i=1,,coleccion; i=2,,articulo
    public int foto_R_drawable_x;
    public Drawable mi_drawable;
    public ImageView imagen;
    public Vector<Integer> buscafotosCol;
    public Vector<Integer> buscafotosArt;
    public  Vector<Integer> buscafotos;
    public int tamaño_buscafotos;
    public  int mi_colec,mi_artic;
    public int[] lista_articulos;
    public int[] lista_colecciones;
    public int[] lista_perfiles;
    public int puntero_lista;
    public static int pantalla_foto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectorimagenes);

        Bundle extras=getIntent().getExtras();
        pantalla= pantalla_foto;//extras.getInt("fte");//i=1,,coleccion; i=2,,articulo


        foto_R_drawable_x=R.drawable.web_cab_circulo;
        imagen=(ImageView)findViewById(R.id.imagenselectorimagen);//imagenselectorimagen
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);

        puntero_lista=0;
        lista_articulos=new int[6];
        lista_articulos[0]=R.drawable.web_cab_circulo;
        lista_articulos[1]=R.drawable.cromomessi;
        lista_articulos[2]=R.drawable.reyemerito;
        lista_articulos[3]=R.drawable.dobla;
        lista_articulos[4]=R.drawable.heman;
        lista_articulos[5]=R.drawable.zapato;
        lista_colecciones=new int[6];
        lista_colecciones[0]=R.drawable.web_cab_circulo;
        lista_colecciones[1]=R.drawable.coleccion_cromos;
        lista_colecciones[2]=R.drawable.coleccion_sellos;
        lista_colecciones[3]=R.drawable.coins_collection;
        lista_colecciones[4]=R.drawable.coleccion_heman;
        lista_colecciones[5]=R.drawable.shoes_collection;
        lista_perfiles=new int[2];
        lista_perfiles[0]=R.drawable.web_cab_circulo;
        lista_perfiles[1]=R.drawable.coche;

        reinicio_editar_articulo=1;
        reinicio_pantalla_nuevo_articulo=1;


        switch (pantalla){
            case 1:
                //buscafotos=MainActivity.almacenColecciones.listaFotos(0);
                //tamaño_buscafotos=buscafotos.size();
                break;
            default:
                if(pantalla==2){
                    mi_colec=extras.getInt("mi_colec");
                    mi_artic=extras.getInt("mi_artic");
                    foto_R_drawable_x=getV_imagart().get(mi_colec).get(mi_artic);
                    mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                    imagen.setImageDrawable(mi_drawable);
                }
        }


        FloatingActionButton camera = (FloatingActionButton)findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambia_foto(null);

            }
        });
        FloatingActionButton galeria = (FloatingActionButton)findViewById(R.id.galeriaselectorimagen);//galeriaselectorimagen
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambia_foto(null);

            }
        });
        FloatingActionButton caballo = (FloatingActionButton)findViewById(R.id.caballoselectorimagen);
        caballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pantalla==2){
                    puntero_lista=0;
                    pon_caballo_en_articulo();
                }
                if(pantalla==1){
                    puntero_lista=0;
                    pon_caballo_en_coleccion();
                }
                if(pantalla==3){
                    puntero_lista=0;
                    foto_R_drawable_x=lista_articulos[puntero_lista];
                    mi_drawable = getResources().getDrawable(foto_R_drawable_x);
                    imagen.setImageDrawable(mi_drawable);
                    fotonuevoarticulo=R.drawable.web_cab_circulo;
                }
                if(pantalla==4){
                    puntero_lista=0;
                    pon_caballo_en_perfil();
                }


            }
        });

    }//fin onCreate

    public  void cambia_ptr(){
        if(pantalla==2||pantalla==3){
            if(puntero_lista<lista_articulos.length-1){
                puntero_lista++;
            }else{
                puntero_lista=0;
            }
        }
        if(pantalla==1){
            if(puntero_lista<lista_colecciones.length-1){
                puntero_lista++;
            }else{
                puntero_lista=0;
            }
        }
        if(pantalla==4){
            if(puntero_lista<lista_perfiles.length-1){
                puntero_lista++;
            }else{
                puntero_lista=0;
            }
        }

    }

    public void cambia_foto(View view){

        cambia_ptr();

        //cambia perfil
        if(pantalla==4){
            foto_R_drawable_x=lista_perfiles[puntero_lista];
            mi_drawable = getResources().getDrawable(foto_R_drawable_x);
            imagen.setImageDrawable(mi_drawable);
        }

        //cambiar foto articulo nuevo
        if(pantalla==3){
            foto_R_drawable_x=lista_articulos[puntero_lista];
            mi_drawable = getResources().getDrawable(foto_R_drawable_x);
            imagen.setImageDrawable(mi_drawable);
            fotonuevoarticulo=foto_R_drawable_x;
        }
        //cambiar foto articulo anterior
        if(pantalla==2){
            foto_R_drawable_x=lista_articulos[puntero_lista];
            mi_drawable = getResources().getDrawable(foto_R_drawable_x);
            imagen.setImageDrawable(mi_drawable);
            //imagen.setBackgroundResource(foto_R_drawable_x);

            //guardar cambios
            editar_articulo();
        }
        //cambiar foto colección
        if(pantalla==1){
            foto_R_drawable_x=lista_colecciones[puntero_lista];
            mi_drawable = getResources().getDrawable(foto_R_drawable_x);
            imagen.setImageDrawable(mi_drawable);
            //guardar cambios
            editar_coleccion();
        }

    }

    public void pon_caballo_en_articulo(){
        foto_R_drawable_x=R.drawable.web_cab_circulo;
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);
        //guardar cambios
        editar_articulo();
    }
    public void pon_caballo_en_coleccion(){
        foto_R_drawable_x=R.drawable.web_cab_circulo;
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);
        //guardar cambios
        editar_coleccion();
    }

    public void pon_caballo_en_perfil(){
        foto_R_drawable_x=R.drawable.web_cab_circulo;
        mi_drawable = getResources().getDrawable(foto_R_drawable_x);
        imagen.setImageDrawable(mi_drawable);
    }

    public void editar_articulo(){

        //mensaje
        Toast.makeText(this, "Nueva foto elegida", Toast.LENGTH_SHORT).show();

        //principio

        Vector<Integer> imagart;
        imagart=new Vector<Integer>();

        Vector<Vector<Integer>> miv_imagart;
        miv_imagart=getV_imagart();

        int j=0;
        for(j=0;j<miv_imagart.get(mi_colec).size();j++){
            imagart.add(j,miv_imagart.get(mi_colec).get(j));
        }

        //acción que da nombre al método
        imagart.set(mi_artic,foto_R_drawable_x);

        //guardo cambios
        miv_imagart.set(mi_colec,imagart);

        setV_imagart(miv_imagart);

    }

    public void editar_coleccion(){

    }

}
