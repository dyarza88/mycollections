package org.jrzdy.master.mycollections;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenArticulos {
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

    //TODO Refactor this class to accomplish good practices

    public AlmacenArticulos() {
        articulo_0 = "Articulo";
        precio_0 = "";
        imagart_0 = R.drawable.web_cab_circulo;

        articulos = new Vector<String>();
        precio = new Vector<String>();
        imagart = new Vector<Integer>();
        coche = new Vector<Integer>();

        articulos.add(articulo_0);
        imagart.add(imagart_0);
        precio.add(precio_0);

        articulos.add(articulo_0);
        imagart.add(imagart_0);
        precio.add(precio_0);

        v_articulo = new Vector<Vector<String>>();
        v_precio = new Vector<Vector<String>>();
        v_imagart = new Vector<Vector<Integer>>();
        v_articulo_apoyo = new ArrayList<Vector<String>>();
        v_precio_apoyo = new ArrayList<Vector<String>>();
        v_imagart_apoyo = new ArrayList<Vector<Integer>>();

        for (int i = 0; i <= 4; i++) {
            v_articulo.add(i, articulos);
            v_precio.add(i, precio);
            v_imagart.add(i, imagart);
            v_articulo_apoyo.add(i, articulos);
            v_precio_apoyo.add(i, precio);
            v_imagart_apoyo.add(i, imagart);
        }
    }

    public void introduce_articulo(int indice_coleccion, String nombre, int imag_R_drawable, String precio_elem) {
        //incorpora un articulo al final (se usa a partir del 1er articulo)

        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();

        //memorizo la fila
        articulos = v_articulo.get(indice_coleccion);
        precio = v_precio.get(indice_coleccion);
        imagart = v_imagart.get(indice_coleccion);

        //añado nuevo elemento
        articulos.add(nombre);
        precio.add(precio_elem);
        imagart.add(imag_R_drawable);

        //incorporo fila
        v_articulo.add(indice_coleccion, articulos);
        v_precio.add(indice_coleccion, precio);
        v_imagart.add(indice_coleccion, imagart);

    }

    public void borrar_un_articulo(int indice_coleccion, int indice_articulo) {
        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();

        //memorizo la fila
        articulos = v_articulo.get(indice_coleccion);
        precio = v_precio.get(indice_coleccion);
        imagart = v_imagart.get(indice_coleccion);

        //compruebo el número de artículos de la colección, ya que si solo quedara uno, no lo podría borrar

        if (articulos.size() != 1) {
            //permitido borrar
            //borro elemento
            articulos.remove(indice_articulo);
            precio.remove(indice_articulo);
            imagart.remove(indice_articulo);

            //incorporo fila
            v_articulo.add(indice_coleccion, articulos);
            v_precio.add(indice_coleccion, precio);
            v_imagart.add(indice_coleccion, imagart);
        } else {
            //pongo el artículo por defecto
            //valores iniciales
            articulos.set(indice_articulo, articulo_0);
            imagart.set(indice_articulo, imagart_0);
            precio.set(indice_articulo, precio_0);
            //incorporo fila
            v_articulo.add(indice_coleccion, articulos);
            v_precio.add(indice_coleccion, precio);
            v_imagart.add(indice_coleccion, imagart);
        }
    }

    public void editar_articulo(int indice_coleccion, int indice_articulo, String nombre, int imag_R_drawable, String precio_elem) {
        //borro lo que habia
        articulos.clear();
        precio.clear();
        imagart.clear();

        //memorizo la fila   //cero que no estoy memorizando nada
        int j = 0;
        for (j = 0; j < v_articulo.get(indice_coleccion).size(); j++) {

            articulos.add(j, v_articulo.get(indice_coleccion).get(j));
            precio.add(j, v_precio.get(indice_coleccion).get(j));
            imagart.add(j, v_imagart.get(indice_coleccion).get(j));

        }

        articulos.add(indice_articulo, nombre);
        precio.add(indice_articulo, precio_elem);
        imagart.add(indice_articulo, imag_R_drawable);
    }

    public Vector<String> getCollecciones(int tipo) {
        return v_articulo.get(tipo);
    }


    public Vector<Integer> getImagcol(int tipo) {
        return v_imagart.get(tipo);
    }

    public Vector<String> getCantidades(int tipo) {
        return v_precio.get(tipo);
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

}
