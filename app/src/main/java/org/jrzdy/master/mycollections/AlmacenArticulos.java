package org.jrzdy.master.mycollections;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AlmacenArticulos implements AlmacenObjetos {
    private Vector<String> articulos;
    private Vector<String> precio;
    private Vector<Integer> imagart;


    public AlmacenArticulos(){
        articulos=new Vector<String>();
        precio=new Vector<String>();
        imagart =new Vector<Integer>();


        articulos.add("Messi");
        articulos.add("Messi");
        articulos.add("Messi");
        articulos.add("Messi");
        articulos.add("Messi");

        imagart.add(R.drawable.cromomessi);
        imagart.add(R.drawable.cromomessi);
        imagart.add(R.drawable.cromomessi);
        imagart.add(R.drawable.cromomessi);
        imagart.add(R.drawable.cromomessi);

        precio.add("36€");
        precio.add("36€");
        precio.add("36€");
        precio.add("36€");
        precio.add("36€");

    }

    @Override
    public Vector<String> listaObjetos(int tipo) {
        articulos.clear();

        switch (tipo){
            case 0:
                articulos.add(0,"Messi");
                articulos.add(1,"Messi");
                articulos.add(2,"Messi");
                articulos.add(3,"Messi");
                articulos.add(4,"Messi");

            break;
            case 1:
                articulos.add(0,"reyemerito");
                articulos.add(1,"reyemerito");
                articulos.add(2,"reyemerito");
                articulos.add(3,"reyemerito");
                articulos.add(4,"reyemerito");

            break;
            default:
                articulos.add(0,"dobla");
                articulos.add(1,"dobla");
                articulos.add(2,"dobla");
                articulos.add(3,"dobla");
                articulos.add(4,"dobla");

        }

        return articulos;
    }

    @Override
    public Vector<Integer> listaFotos(int tipo) {
        imagart.clear();

        switch (tipo){
            case 0:
                imagart.add(0,R.drawable.cromomessi);
                imagart.add(1,R.drawable.cromomessi);
                imagart.add(2,R.drawable.cromomessi);
                imagart.add(3,R.drawable.cromomessi);
                imagart.add(4,R.drawable.cromomessi);
                break;
            case 1:
                imagart.add(0,R.drawable.reyemerito);
                imagart.add(1,R.drawable.reyemerito);
                imagart.add(2,R.drawable.reyemerito);
                imagart.add(3,R.drawable.reyemerito);
                imagart.add(4,R.drawable.reyemerito);
                break;
            default:
                imagart.add(0,R.drawable.dobla);
                imagart.add(1,R.drawable.dobla);
                imagart.add(2,R.drawable.dobla);
                imagart.add(3,R.drawable.dobla);
                imagart.add(4,R.drawable.dobla);

        }

        return imagart;
    }

    @Override
    public Vector<String> cantidades(int tipo) {
        return escogePrecio(tipo);
    }

    public Vector<String> escogePrecio(int tipo){
        precio.clear();
        switch (tipo){
            case 0:
                precio.add(0,"36€");
                precio.add(1,"36€");
                precio.add(2,"36€");
                precio.add(3,"36€");
                precio.add(4,"36€");
                break;
            case 1:
                precio.add(0,"7€");
                precio.add(1,"7€");
                precio.add(2,"7€");
                precio.add(3,"7€");
                precio.add(4,"7€");

                break;
            default:
                precio.add(0,"2500€");
                precio.add(1,"2500€");
                precio.add(2,"2500€");
                precio.add(3,"2500€");
                precio.add(4,"2500€");

        }

        return precio;
    }
}
