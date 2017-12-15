package org.jrzdy.master.mycollections;


import java.io.Serializable;

public class Entidad implements Serializable{

    private int imgFoto;
    private String titulo;
    private String contenido;
    private String descripcion;
    private String fecha;

    public Entidad(int imgFoto, String titulo, String contenido, String descripcion, String fecha) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getImgFoto() {return imgFoto;}

    public String getTitulo() {return titulo;}

    public String getContenido() {return contenido;}

    public String getDescripcion(){return descripcion;}

    public String getFecha() {return fecha;}
}


