package org.android.master.mycollections;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenColecciones implements AlmacenObjetos {
    private Vector<String> porcentaje_completo;
    private Vector<String> colecciones;
    private int[] imagcol;

    public AlmacenColecciones(){
        colecciones=new Vector<String>();
        colecciones.add("cromos");
        colecciones.add("Muñecos heman");
        colecciones.add("sellos");
        colecciones.add("zapatos");
        colecciones.add("monedas");

        porcentaje_completo=new Vector<String>();
        porcentaje_completo.add("200/563");
        porcentaje_completo.add("47/300");
        porcentaje_completo.add("389/1234");
        porcentaje_completo.add("14/inf");
        porcentaje_completo.add("790/inf");

        imagcol=new int[5];
        imagcol[0]= R.drawable.coleccion_cromos;
        imagcol[1]=  R.drawable.coleccion_heman;
        imagcol[2]=  R.drawable.coleccion_sellos;
        imagcol[3]=  R.drawable.ic_shoes_collection;
        imagcol[4]=  R.drawable.ic_coins_collection;

    }

    @Override
    public Vector<String> listaObjetos(int cantidad) {
        return colecciones;
    }

    @Override
    public int[] listaFotos(int cantidad){return imagcol;}

    @Override
    public Vector<String> cantidades() {
        return porcentaje_completo;
    }


}
