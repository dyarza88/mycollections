package org.jrzdy.master.mycollections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

public class Editararticulo extends AppCompatActivity {

    public int posicion_articulo;
    public int posicion_coleccion;
    public  String nombre_articulo;
    public String precio_articulo;
    //public String descripc_articulo //aun no está implementado
    public int foto_articulo;
    public TextView nombre_TV;
    public TextView precio_TV;
    public ImageView foto_IV;
    public EditText descrip_ET;
    //public TextView descripc_articulo_TV;
    public Button btn_guardar;
    public Button btn_borrar;

    public static int reinicio_editar_articulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editarticulo);

        nombre_articulo="";
        precio_articulo="";
        foto_articulo=R.drawable.web_cab_circulo;

        reinicio_editar_articulo=0;

        nombre_TV=(TextView)findViewById(R.id.nombre_editar_articulo);
        precio_TV=(TextView)findViewById(R.id.precio_editar_articulo);
        foto_IV=(ImageView)findViewById(R.id.imagen_editar_articulo);
        descrip_ET=(EditText)findViewById(R.id.descripc_editar_articulo);
        btn_borrar=(Button)findViewById(R.id.borrar_editar_articulo);
        btn_guardar=(Button)findViewById(R.id.guardar_editar_articulo);

        foto_IV.setImageResource(getV_imagart().get(posicion_coleccion).get(posicion_articulo));

        Bundle extras=getIntent().getExtras();
        posicion_articulo=extras.getInt("num_art");
        posicion_coleccion=extras.getInt("num_col");
        Toast.makeText(this, "pantalla "+posicion_coleccion, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "articulo "+posicion_articulo, Toast.LENGTH_SHORT).show();

        mostrar_datos_iniciales();


        FloatingActionButton camera = (FloatingActionButton)findViewById(R.id.camara_editar_articulo);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageSelectActivity.class);
                i.putExtra("fte",2);
                pantalla_foto=2;
                i.putExtra("mi_colec",posicion_coleccion);
                i.putExtra("mi_artic",posicion_articulo);
                startActivity(i);
                //startActivityForResult(i,1233);
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar_articulo();
            }
        });

        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrar_articulo();
                finish();
            }
        });

        EditCollectionActivity.reinicio=1;

    }//fin onCreate

    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume EditCollection", Toast.LENGTH_SHORT).show();

        if(reinicio_editar_articulo==1){
            finish();
            startActivity(getIntent());
        }
    }


    public void recoger_datos(){
        nombre_articulo=nombre_TV.getText().toString();
        precio_articulo=precio_TV.getText().toString();
        foto_articulo=getV_imagart().get(posicion_coleccion).get(posicion_articulo);

    }

    public void mostrar_datos_iniciales(){
        Vector<String> articulos;
        articulos=new Vector<String>();
        Vector<String> precio;
        precio=new Vector<String>();
        Vector<Integer> imagart;
        imagart=new Vector<Integer>();
        Vector<Vector<String>> miv_articulo;
        Vector<Vector<String>> miv_precio;
        Vector<Vector<Integer>> miv_imagart;
        miv_articulo=getV_articulo();
        miv_precio=getV_precio();
        miv_imagart=getV_imagart();

        int j=0;
        for(j=0;j<miv_articulo.get(posicion_coleccion).size();j++){

            articulos.add(j,miv_articulo.get(posicion_coleccion).get(j));
            precio.add(j,miv_precio.get(posicion_coleccion).get(j));
            imagart.add(j,miv_imagart.get(posicion_coleccion).get(j));

        }

        nombre_articulo=articulos.get(posicion_articulo);
        precio_articulo=precio.get(posicion_articulo);
        foto_articulo= imagart.get(posicion_articulo);

        try{
            nombre_TV.setText(nombre_articulo);
            precio_TV.setText(precio_articulo);
            foto_IV.setImageResource(foto_articulo);
        }catch (Exception e){
            Toast.makeText(this, "Excepción en mostrar", Toast.LENGTH_SHORT).show();
        }

    }

    public void editar_articulo(){
        Toast.makeText(Editararticulo.this, "Artículo introducido", Toast.LENGTH_SHORT).show();

        //principio
        recoger_datos();
        Vector<String> articulos;
        articulos=new Vector<String>();
        Vector<String> precio;
        precio=new Vector<String>();
        Vector<Integer> imagart;
        imagart=new Vector<Integer>();
        Vector<Vector<String>> miv_articulo;
        Vector<Vector<String>> miv_precio;
        Vector<Vector<Integer>> miv_imagart;
        miv_articulo=getV_articulo();
        miv_precio=getV_precio();
        miv_imagart=getV_imagart();

        int j=0;
        for(j=0;j<miv_articulo.get(posicion_coleccion).size();j++){

            articulos.add(j,miv_articulo.get(posicion_coleccion).get(j));
            precio.add(j,miv_precio.get(posicion_coleccion).get(j));
            imagart.add(j,miv_imagart.get(posicion_coleccion).get(j));

        }


        //articulos.add(posicion_articulo,nombre_articulo);
        //precio.add(posicion_articulo,precio_articulo);
        //imagart.add(posicion_articulo,foto_articulo);

        //acción que da nombre al método
        articulos.set(posicion_articulo,nombre_articulo);
        precio.set(posicion_articulo,precio_articulo);
        imagart.set(posicion_articulo,foto_articulo);

        //guardo cambios
        miv_articulo.set(posicion_coleccion,articulos);
        miv_precio.set(posicion_coleccion,precio);
        miv_imagart.set(posicion_coleccion,imagart);

        setV_articulo(miv_articulo);
        setV_precio(miv_precio);
        setV_imagart(miv_imagart);

    }


    public void borrar_articulo(){

        //principio
        recoger_datos();
        Vector<String> articulos;
        articulos=new Vector<String>();
        Vector<String> precio;
        precio=new Vector<String>();
        Vector<Integer> imagart;
        imagart=new Vector<Integer>();
        Vector<Vector<String>> miv_articulo;
        Vector<Vector<String>> miv_precio;
        Vector<Vector<Integer>> miv_imagart;
        miv_articulo=getV_articulo();
        miv_precio=getV_precio();
        miv_imagart=getV_imagart();

        int j=0;
        for(j=0;j<miv_articulo.get(posicion_coleccion).size();j++){
            //memorizo la fila
            articulos.add(j,miv_articulo.get(posicion_coleccion).get(j));
            precio.add(j,miv_precio.get(posicion_coleccion).get(j));
            imagart.add(j,miv_imagart.get(posicion_coleccion).get(j));

        }

        //acción que da nombre al método
        //compruebo el número de artículos de la colección, ya que si solo quedara uno, no lo podría borrar
            if(articulos.size()!=1){
                //permitido borrar
                //borro elemento
                articulos.remove(posicion_articulo);
                precio.remove(posicion_articulo);
                imagart.remove(posicion_articulo);

                //guardo cambios
                miv_articulo.set(posicion_coleccion,articulos);
                miv_precio.set(posicion_coleccion,precio);
                miv_imagart.set(posicion_coleccion,imagart);

                setV_articulo(miv_articulo);
                setV_precio(miv_precio);
                setV_imagart(miv_imagart);
            }
            else{
                //pongo el artículo por defecto
                //valores iniciales

                //acción que da nombre al método
                articulos.set(posicion_articulo,"MyCollections");
                precio.set(posicion_articulo,"0€");
                imagart.set(posicion_articulo,R.drawable.web_cab_circulo);

                //guardo cambios
                miv_articulo.set(posicion_coleccion,articulos);
                miv_precio.set(posicion_coleccion,precio);
                miv_imagart.set(posicion_coleccion,imagart);

                setV_articulo(miv_articulo);
                setV_precio(miv_precio);
                setV_imagart(miv_imagart);

            }

        nombre_TV.setText("");
        precio_TV.setText("");
        foto_IV.setImageResource(R.drawable.web_cab_circulo);


    }
/*
    @Override
    public void onBackPressed(){
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            if (this.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
            }
            //nombre_TV.clearFocus();
            //precio_TV.clearFocus();
            //descrip_ET.clearFocus();
        }else{
            super.onBackPressed();
        }

    }
*/

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==1233&&requestCode==RESULT_OK){
            //Hacer algo
            foto_articulo=data.getExtras().getInt("numerofoto");
            foto_IV.setImageResource(foto_articulo);
        }
    }

    */
}
