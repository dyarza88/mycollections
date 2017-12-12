package org.jrzdy.master.mycollections;

import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenArticulos implements AlmacenObjetos {
    private Vector<String> articulos;
    private Vector<String> precio;
    private Vector<Integer> imagart;

    public static Vector<Vector<String>> v_articulo;
    public static Vector<Vector<String>> v_precio;
    public static Vector<Vector<Integer>> v_imagart;
    public static ArrayList<Vector<String>> v_articulo_apoyo;
    public static ArrayList<Vector<String>> v_precio_apoyo;
    public static ArrayList<Vector<Integer>> v_imagart_apoyo;
    //para inicializar
    private String articulo_0;
    private String precio_0;
    private int imagart_0;

    private Vector<Integer> coche;



    public AlmacenArticulos(){

        //lo que habrá al iniciar la app

        articulo_0="MyCollection";
        precio_0="0€";
        imagart_0=R.drawable.web_cab_circulo;

        articulos=new Vector<String>();
        precio=new Vector<String>();
        imagart =new Vector<Integer>();
        coche=new Vector<Integer>();

        articulos.add(articulo_0);
        imagart.add(imagart_0);
        precio.add(precio_0);

        articulos.add(articulo_0);
        imagart.add(imagart_0);
        precio.add(precio_0);


        v_articulo=new Vector<Vector<String>>();
        v_articulo.add(0,articulos);
        v_articulo.add(1,articulos);
        v_articulo.add(2,articulos);
        v_articulo.add(3,articulos);
        v_articulo.add(4,articulos);


        v_precio=new Vector<Vector<String>>();
        v_precio.add(0,precio);
        v_precio.add(1,precio);
        v_precio.add(2,precio);
        v_precio.add(3,precio);
        v_precio.add(4,precio);


        v_imagart=new Vector<Vector<Integer>>();
        v_imagart.add(0,imagart);
        v_imagart.add(1,imagart);
        v_imagart.add(2,imagart);
        v_imagart.add(3,imagart);
        v_imagart.add(4,imagart);


        v_articulo_apoyo=new ArrayList<Vector<String>>();
        v_articulo_apoyo.add(0,articulos);
        v_articulo_apoyo.add(1,articulos);
        v_articulo_apoyo.add(2,articulos);
        v_articulo_apoyo.add(3,articulos);
        v_articulo_apoyo.add(4,articulos);


        v_precio_apoyo=new ArrayList<Vector<String>>();
        v_precio_apoyo.add(0,precio);
        v_precio_apoyo.add(1,precio);
        v_precio_apoyo.add(2,precio);
        v_precio_apoyo.add(3,precio);
        v_precio_apoyo.add(4,precio);


        v_imagart_apoyo=new ArrayList<Vector<Integer>>();
        v_imagart_apoyo.add(0,imagart);
        v_imagart_apoyo.add(1,imagart);
        v_imagart_apoyo.add(2,imagart);
        v_imagart_apoyo.add(3,imagart);
        v_imagart_apoyo.add(4,imagart);





    }

    @Override
    public Vector<String> listaObjetos(int tipo) {
        return v_articulo.get(tipo);
    }

    @Override
    public Vector<Integer> listaFotos(int tipo) {
        return v_imagart.get(tipo);
    }

    @Override
    public Vector<String> cantidades(int tipo) {
        return v_precio.get(tipo);
    }

    public void inicia_primer_articulo_coleccion(int indice_coleccion){
        //si se borraran todos los artículos de una colección sería necesario usarlo
        //en principio no se ha de usar, porque al menos habrá un artículo para que
        //la app no se cierre al no tener nada el RecyclerView. A pesar de ello
        //lo dejo implementado por posibles modificaciones

        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();
        //valores iniciales
        articulos.add(articulo_0);
        imagart.add(imagart_0);
        precio.add(precio_0);
        //incorporo fila
        v_articulo.add(indice_coleccion,articulos);
        v_precio.add( indice_coleccion,precio);
        v_imagart.add(indice_coleccion,imagart);

    }

    public void introduce_articulo(int indice_coleccion,String nombre, int imag_R_drawable,String precio_elem ){
        //incorpora un articulo al final (se usa a partir del 1er articulo)

        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();

        //memorizo la fila
        articulos=v_articulo.get(indice_coleccion);
        precio=v_precio.get(indice_coleccion);
        imagart=v_imagart.get(indice_coleccion);

        //añado nuevo elemento
        articulos.add(nombre);
        precio.add(precio_elem);
        imagart.add(imag_R_drawable);

        //incorporo fila
        v_articulo.add(indice_coleccion,articulos);
        v_precio.add( indice_coleccion,precio);
        v_imagart.add(indice_coleccion,imagart);

    }

    public void borrar_un_articulo(int indice_coleccion,int indice_articulo ){
        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();

        //memorizo la fila
        articulos=v_articulo.get(indice_coleccion);
        precio=v_precio.get(indice_coleccion);
        imagart=v_imagart.get(indice_coleccion);

        //compruebo el número de artículos de la colección, ya que si solo quedara uno, no lo podría borrar

        if(articulos.size()!=1){
            //permitido borrar
            //borro elemento
            articulos.remove(indice_articulo);
            precio.remove(indice_articulo);
            imagart.remove(indice_articulo);

            //incorporo fila
            v_articulo.add(indice_coleccion,articulos);
            v_precio.add(indice_coleccion,precio);
            v_imagart.add(indice_coleccion,imagart);
        }
        else{
            //pongo el artículo por defecto
            //valores iniciales
            articulos.set(indice_articulo,articulo_0);
            imagart.set(indice_articulo,imagart_0);
            precio.set(indice_articulo,precio_0);
            //incorporo fila
            v_articulo.add(indice_coleccion,articulos);
            v_precio.add( indice_coleccion,precio);
            v_imagart.add(indice_coleccion,imagart);

        }



    }

    public void borrar_todos_articulos(int indice_coleccion){
        //Método peligroso
        //solo se usará cuando se borre la colección entera

        v_articulo.remove(indice_coleccion);
    }

    public static Vector<Vector<String>> getV_articulo() {
        return v_articulo;
    }

    public static void setV_articulo(Vector<Vector<String>> v_articulo) {
        AlmacenArticulos.v_articulo = v_articulo;
    }

    public static Vector<Vector<String>> getV_precio() {
        return v_precio;
    }

    public static void setV_precio(Vector<Vector<String>> v_precio) {
        AlmacenArticulos.v_precio = v_precio;
    }

    public static Vector<Vector<Integer>> getV_imagart() {
        return v_imagart;
    }

    public static void setV_imagart(Vector<Vector<Integer>> v_imagart) {
        AlmacenArticulos.v_imagart = v_imagart;
    }

    public void editar_articulo(int indice_coleccion, int indice_articulo, String nombre, int imag_R_drawable, String precio_elem ){
        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();


        //memorizo la fila   //cero que no estoy memorizando nada
        int j=0;
        for(j=0;j<v_articulo.get(indice_coleccion).size();j++){

            articulos.add(j,v_articulo.get(indice_coleccion).get(j));
            precio.add(j,v_precio.get(indice_coleccion).get(j));
            imagart.add(j,v_imagart.get(indice_coleccion).get(j));

        }


        //distintas formas de editar según el tamaño de Vector<Vector<...>>
        //if(v_articulo.size()==0){
            //modifico elemento
            articulos.add(indice_articulo,nombre);
            precio.add(indice_articulo,precio_elem);
            imagart.add(indice_articulo,imag_R_drawable);
            //articulos.set(indice_articulo,nombre);
            //precio.set(indice_articulo,precio_elem);
            //imagart.set(indice_articulo,imag_R_drawable);
        //}else{
            //articulos.set(indice_articulo,nombre);
            //precio.set(indice_articulo,precio_elem);
            //imagart.set(indice_articulo,imag_R_drawable);
        //}


//aqui: si lo comento daría error la 2a vez?
        //v_articulo.insertElementAt(articulos,indice_coleccion);
        //v_precio.insertElementAt(precio,indice_coleccion);
       // v_imagart.insertElementAt(imagart,indice_coleccion);
//ya
        /*
        int i=0;
        for(i=0;i<v_imagart_apoyo.size();i++){
            if(i==indice_coleccion){
                v_articulo.clear();
                v_articulo=v_articulo_apoyo;
                //incorporo fila
                v_articulo.add(indice_coleccion,articulos);
                v_precio.add(indice_coleccion,precio);
                v_imagart.add(indice_coleccion,imagart);
                //actualizo apoyo
                v_articulo_apoyo=v_articulo;
            }
            else{
                //incorporo v_apoyo
            }
        }
*/




    }

}
