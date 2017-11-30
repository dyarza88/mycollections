package org.android.master.mycollections;



public class Entidad {

    private int imgFoto;
    private String titulo;
    private String contenido;
    private String fecha;

    public Entidad(int imgFoto, String titulo, String contenido, String fecha) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getImgFoto() {return imgFoto;}

    public String getTitulo() {return titulo;}

    public String getContenido() {return contenido;}

    public String getFecha() {return fecha;}
}
