package org.jrzdy.master.mycollections;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenColecciones {
    private Vector<String> porcentajeCompleto;
    private Vector<String> colecciones;
    private Vector<Integer> imagcol;

    public AlmacenColecciones() {
        colecciones = new Vector<>();
        colecciones.add("cromos");
        colecciones.add("Muñecos heman");
        colecciones.add("sellos");
        colecciones.add("zapatos");
        colecciones.add("monedas");

        porcentajeCompleto = new Vector<>();
        porcentajeCompleto.add("200/563");
        porcentajeCompleto.add("47/300");
        porcentajeCompleto.add("389/1234");
        porcentajeCompleto.add("14/inf");
        porcentajeCompleto.add("790/inf");

        imagcol = new Vector<>();
        imagcol.add(R.drawable.coleccion_cromos);
        imagcol.add(R.drawable.coleccion_heman);
        imagcol.add(R.drawable.coleccion_sellos);
        imagcol.add(R.drawable.shoes_collection);
        imagcol.add(R.drawable.coins_collection);

    }


    public Vector<String> getColecciones() {
        return colecciones;
    }


    public Vector<Integer> getImagcol() {
        return imagcol;
    }

    public Vector<String> getPorcentajeCompleto() {
        return porcentajeCompleto;
    }

}
