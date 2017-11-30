package org.android.master.mycollections;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenArticulos implements AlmacenObjetos {
    private Vector<String> articulos;

    public AlmacenArticulos(){
        articulos=new Vector<String>();
        articulos.add("Messi");
        articulos.add("reyemerito");
        articulos.add("dobla");
    }

    @Override
    public Vector<String> listaObjetos(int cantidad) {
        return articulos;
    }
}
