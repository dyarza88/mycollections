package org.jrzdy.master.mycollections;

/**
 * Created by nakis on 01/12/2017.
 */

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

public class AdaptadormA extends RecyclerView.Adapter<AdaptadormA.ViewHolder> {

    private LayoutInflater inflador;
    private Vector<String> lista;
    private Vector<String> porcentaje_completo;
    private Vector<Integer> fotos;

    protected View.OnClickListener onClickListener;

    public AdaptadormA(Context context, Vector<String> strings, Vector<Integer> listaFotos,Vector<String> porcentaje_completo) {
        this.lista=strings;
        inflador=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.porcentaje_completo=porcentaje_completo;
        fotos=listaFotos;

    }

    public void updateAdaptadormA(Context context, Vector<String> strings, Vector<Integer> listaFotos,Vector<String> porcentaje_completo) {
        this.lista=strings;
        inflador=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.porcentaje_completo=porcentaje_completo;
        fotos=listaFotos;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflador.inflate(R.layout.adaptador_colecc_priv,parent,false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadormA.ViewHolder holder, int position) {
        holder.titulo.setText(lista.get(position));
        holder.icon.setImageResource(fotos.get(position));
        holder.subtitulo.setText(porcentaje_completo.get(position));
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
