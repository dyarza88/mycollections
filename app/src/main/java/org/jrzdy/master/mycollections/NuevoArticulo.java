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
 * Created by nakis on 30/11/2017.
 */

public class NuevoArticulo extends AppCompatActivity {

    public static int reinicio_pantalla_nuevo_articulo=R.drawable.web_cab_circulo;
    public static int fotonuevoarticulo=R.drawable.web_cab_circulo;
    public int indice_colecc;

    public TextView nombre_TV;
    public TextView precio_TV;
    public ImageView imagen_IV;
    public Button guardar_btn;
    public TextView titulocoleccion_TV;

    public String nombre;
    public String precio;
    public int foto;
    public  String titulocoleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevoarticulo);

        Bundle extras=getIntent().getExtras();
        indice_colecc=extras.getInt("nuevoart_c");
        EditCollectionActivity.reinicio=1;

        nombre="";
        nombre_TV=(TextView)findViewById(R.id.nombre_nuevo_articulo);
        precio="";
        precio_TV=(TextView)findViewById(R.id.precio_nuevo_articulo);
        imagen_IV=(ImageView)findViewById(R.id.id_img_art_A);
        guardar_btn=(Button)findViewById(R.id.guardar_nuevo_articulo);
        titulocoleccion="";
        titulocoleccion_TV=(TextView) findViewById(R.id.titulocolecceditart);

        titulocoleccion=MainActivity.almacenColecciones.getColecciones().get(indice_colecc);
        titulocoleccion_TV.setText (titulocoleccion);

        reinicio_pantalla_nuevo_articulo=0;
        pantalla_foto=3;


        FloatingActionButton camera = (FloatingActionButton)findViewById(R.id.camara);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageSelectActivity.class);
                i.putExtra("fte",2);
                //startActivity(i);
                ActivityOptionsCompat options= ActivityOptionsCompat.makeSceneTransitionAnimation(
                        NuevoArticulo.this,
                        new Pair<View, String>(v.findViewById(R.id.camara), getString(R.string.transition_name_camara)));
                ActivityCompat.startActivity(NuevoArticulo.this, i, options.toBundle());
            }
        });


        guardar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoger_datos();
                insertar_articulo();
                Toast.makeText(NuevoArticulo.this, "Nuevo artículo creado", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        if(reinicio_pantalla_nuevo_articulo==1){
            finish();
            startActivity(getIntent());
            try{
                imagen_IV.setImageResource(fotonuevoarticulo);
                foto=fotonuevoarticulo;
            }catch (Exception e){
                //imposible
            }
        }else{
            try{
                //válido cuando se escoja foto
                imagen_IV.setImageResource(fotonuevoarticulo);
                foto=fotonuevoarticulo;
            }catch (Exception e){
                //imposible
            }
        }
    }

    public void recoger_datos(){
        nombre=nombre_TV.getText().toString();
        precio=precio_TV.getText().toString();
    }

    public void insertar_articulo(){

        //principio
        recoger_datos();
        Vector<String> articulos;
        articulos=new Vector<String>();
        Vector<String> precios;
        precios=new Vector<String>();
        Vector<Integer> imagart;
        imagart=new Vector<Integer>();
        Vector<Vector<String>> miv_articulo;
        Vector<Vector<String>> miv_precio;
        Vector<Vector<Integer>> miv_imagart;
        miv_articulo=getV_articulo();
        miv_precio=getV_precio();
        miv_imagart=getV_imagart();

        int j=0;
        for(j=0;j<miv_articulo.get(indice_colecc).size();j++){

            articulos.add(j,miv_articulo.get(indice_colecc).get(j));
            precios.add(j,miv_precio.get(indice_colecc).get(j));
            imagart.add(j,miv_imagart.get(indice_colecc).get(j));

        }

        //acción que da nombre al método
        articulos.add(miv_articulo.get(indice_colecc).size(),nombre);
        precios.add(miv_precio.get(indice_colecc).size(),precio);
        imagart.add(miv_imagart.get(indice_colecc).size(),foto);


        //articulos.set(posicion_articulo,nombre);
        //precios.set(posicion_articulo,precio);
        //imagart.set(posicion_articulo,foto);

        //guardo cambios
        miv_articulo.set(indice_colecc,articulos);
        miv_precio.set(indice_colecc,precios);
        miv_imagart.set(indice_colecc,imagart);

        setV_articulo(miv_articulo);
        setV_precio(miv_precio);
        setV_imagart(miv_imagart);

    }


}

