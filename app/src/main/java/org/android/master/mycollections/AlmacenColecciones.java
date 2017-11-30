package org.android.master.mycollections;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenColecciones implements AlmacenObjetos {
    private Vector<String> colecciones;
    //private Vector<String> imagcol;

    public AlmacenColecciones(){
        colecciones=new Vector<String>();
        //imagcol=new Vector<String>();
        colecciones.add("Cromos 2017");
        //imagcol.add("coleccion_cromos");
        colecciones.add("Muñecos heman");
        //imagcol.add("coleccion_heman)");
        colecciones.add("sellos");
        //imagcol.add("coleccion_sellos");
        colecciones.add("Cómics DC");
        //imagcol.add("ic_coins_collection");
    }

    @Override
    public Vector<String> listaObjetos(int cantidad) {
        return colecciones;
    }
}
