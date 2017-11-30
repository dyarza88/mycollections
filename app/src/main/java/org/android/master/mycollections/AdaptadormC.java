package org.android.master.mycollections;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public class AdaptadormC extends RecyclerView.Adapter<AdaptadormC.ViewHolder> {

    private LayoutInflater inflador;
    private Vector<String> lista;
    private Vector<String> porcentaje_completo;
    private int[]fotos;
    int coloOart;


    protected View.OnClickListener onClickListener;

    public AdaptadormC(Context context, Vector<String> strings, int[] listaFotos,Vector<String> porcentaje_completo) {
        this.lista=strings;
        inflador=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.porcentaje_completo=porcentaje_completo;
        fotos=new int[5];
        fotos=listaFotos;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflador.inflate(R.layout.adaptador_colecc_priv,parent,false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.titulo.setText(lista.get(position));

            holder.icon.setImageResource(fotos[position]);


        holder.subtitulo.setText(porcentaje_completo.get(position));//hacer otra lógica al respecto
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titulo,subtitulo;
        public ImageView icon;
        ViewHolder(View itemview){
            super(itemview);
            //AQUI SE PONEN LOS ID DEL LAYOUT DEL ELEMENTO

            titulo=(TextView)itemview.findViewById(R.id.nombreColecc_txt);
            subtitulo=(TextView)itemview.findViewById(R.id.cantColecc_txt);
            icon=(ImageView)itemview.findViewById(R.id.imagenColeccion);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }


}
