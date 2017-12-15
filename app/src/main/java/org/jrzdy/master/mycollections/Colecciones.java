package org.jrzdy.master.mycollections;

import java.util.ArrayList;

/**
 * Created by Javier on 26/11/2017.
 */

public class Colecciones {
    //Creamos variables
    public String coleccion;
    public String usuario;
    public String cantidad;
    public String fondo;
    public boolean fav;

    public Colecciones() {

        //inicializamos las variables
        coleccion = "";
        usuario = "";
        cantidad = "";
        fondo = "";
        fav = false;
    }

    public Colecciones(String coleccion, String usuario, String cantidad, String fondo, boolean fav) {
        //Recibimos parametros del constructor y los agregamos al nuestras variables
        this.coleccion = coleccion;
        this.usuario = usuario;
        this.cantidad = cantidad;
        this.fondo = fondo;
        this.fav = fav;
    }

    public ArrayList<Colecciones> getlistaColecciones() {
        Colecciones objetoColeccion = null;
        ArrayList<Colecciones> listaColecciones = new ArrayList<Colecciones>();

        String[] arrayColecciones = new String[]{"Cromos 2017", "Muñecos heman", "sellos", "Cómics DC"};
        String[] arrayUsuarios = new String[]{"Nuria", "Dyarza", "Esther", "Jarucas92"};
        String[] arrayCantidad = new String[]{"100/50", "7/12", "220/1080", "67/90"};
        String[] arrayFondo = new String[]{"coleccion_cromos", "coleccion_heman", "coleccion_sellos", "coleccion_comics"};

        boolean[] arrayFav = new boolean[]{false, false, false, true};
        try {
            for (int i = 0; i < arrayColecciones.length; i++) {
                objetoColeccion = new Colecciones(arrayColecciones[i], arrayUsuarios[i], arrayCantidad[i], arrayFondo[i], arrayFav[i]);
                listaColecciones.add(objetoColeccion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaColecciones;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
