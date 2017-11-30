package org.android.master.mycollections;

import android.graphics.drawable.Drawable;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenArticulos implements AlmacenObjetos {
    private Vector<String> articulos;
    private Vector<String> precio;
    private int[][] imagcol;


    public AlmacenArticulos(){
        articulos=new Vector<String>();
        precio=new Vector<String>();
        imagcol=new int[3][1];
        imagcol[0][0]=  R.drawable.cromomessi;
        imagcol[1][0]=  R.drawable.reyemerito;
        imagcol[2][0]=  R.drawable.dobla;

    }

    @Override
    public Vector<String> listaObjetos(int tipo) {
        switch (tipo){
            case 0: articulos.add("Messi");
            break;
            case 1:
            articulos.add("reyemerito");
            break;
            default:
            articulos.add("dobla");
        }
        return articulos;
    }

    @Override
    public int[] listaFotos(int tipo) {
        return imagcol[tipo];
    }

    @Override
    public Vector<String> cantidades(int tipo) {
        switch (tipo){
            case 0:
                precio.add("36€");
                break;
            case 1:
                precio.add("7€");
                break;
            default:
                precio.add("2500€");
        }
        return precio;
    }
}
