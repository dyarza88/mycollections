package org.jrzdy.master.mycollections;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenColecciones implements AlmacenObjetos {
    private Vector<String> porcentaje_completo;
    private Vector<String> colecciones;
    private Vector<Integer> imagcol;

    public AlmacenColecciones(){
        colecciones=new Vector<String>();
        colecciones.clear();
        colecciones.add("cromos");
        colecciones.add("Muñecos heman");
        colecciones.add("sellos");
        //colecciones.add("zapatos");
        //colecciones.add("monedas");

        porcentaje_completo=new Vector<String>();
        porcentaje_completo.clear();
        porcentaje_completo.add("200/563");
        porcentaje_completo.add("47/300");
        porcentaje_completo.add("389/1234");
        //porcentaje_completo.add("14/inf");
        //porcentaje_completo.add("790/inf");

        imagcol=new Vector<Integer>();
        imagcol.clear();
        imagcol.add(R.drawable.coleccion_cromos);
        imagcol.add( R.drawable.coleccion_heman);
        imagcol.add( R.drawable.coleccion_sellos);
        //imagcol.add( R.drawable.ic_shoes_collection);
        //imagcol.add( R.drawable.ic_coins_collection);

    }

    @Override
    public Vector<String> listaObjetos(int tipo) {
        return colecciones;
    }

    @Override
    public Vector<Integer> listaFotos(int tipo){return imagcol;}

    @Override
    public Vector<String> cantidades(int tipo) {
        return porcentaje_completo;
    }


}
