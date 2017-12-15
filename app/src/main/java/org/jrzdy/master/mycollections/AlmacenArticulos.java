package org.jrzdy.master.mycollections;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenArticulos {

    public static Vector<Vector<String>> vArticulo;
    public static Vector<Vector<String>> vPrecio;
    public static Vector<Vector<Integer>> vImagart;

    //TODO Refactor this class to accomplish good practices

    public AlmacenArticulos() {
        vArticulo = new Vector<>();
        vPrecio = new Vector<>();
        vImagart = new Vector<>();

        nuevoArticulo(4, "Cromo", "3", 0);
        nuevoArticulo(5, "Muñeco", "12", 1);
        nuevoArticulo(8, "Sello", "60", 2);
        nuevoArticulo(1, "Zapato", "29", 3);
        nuevoArticulo(3, "Moneda", "1", 4);
        nuevoArticulo(9, "Comic", "2.99", 5);

    }

    private void nuevoArticulo(int numeroArticulos, String nombreColeccion, String precio_elem, int foto) {
        Vector<String> articulos = new Vector<>();
        Vector<String> precio = new Vector<>();
        Vector<Integer> imagart = new Vector<>();
        int drawable = getDrawableForCode(foto);

        for (int i = 0; i <= numeroArticulos; i++) {
            articulos.add(nombreColeccion + " " + i);
            precio.add(precio_elem + "€");
            imagart.add(drawable);
        }
        vArticulo.add(articulos);
        vPrecio.add(precio);
        vImagart.add(imagart);
    }

    public Vector<String> getCollecciones(int tipo) {
        return vArticulo.get(tipo);
    }

    private int getDrawableForCode(int code) {
        switch (code) {
            case 0:
                return R.drawable.cromomessi;
            case 1:
                return R.drawable.heman;
            case 2:
                return R.drawable.reyemerito;
            case 3:
                return R.drawable.zapato;
            case 4:
                return R.drawable.dobla;
            case 5:
                return R.drawable.articulo_comic;
            default:
                return R.drawable.web_cab_circulo;
        }
    }

    public Vector<Integer> getImagcol(int tipo) {
        return vImagart.get(tipo);
    }

    public Vector<String> getCantidades(int tipo) {
        return vPrecio.get(tipo);
    }

    public static Vector<Vector<String>> getvArticulo() {
        return vArticulo;
    }

    public static void setvArticulo(Vector<Vector<String>> vArticulo) {
        AlmacenArticulos.vArticulo = vArticulo;
    }

    public static Vector<Vector<String>> getvPrecio() {
        return vPrecio;
    }

    public static void setvPrecio(Vector<Vector<String>> vPrecio) {
        AlmacenArticulos.vPrecio = vPrecio;
    }

    public static Vector<Vector<Integer>> getvImagart() {
        return vImagart;
    }

    public static void setvImagart(Vector<Vector<Integer>> vImagart) {
        AlmacenArticulos.vImagart = vImagart;
    }

}
