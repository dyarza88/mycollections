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
    int coloOart;


    protected View.OnClickListener onClickListener;

    public AdaptadormC(Context context, Vector<String> strings) {
        this.lista=strings;
        inflador=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        //hacer lógicca para el holder icon
        if(lista.size()==3){
            switch (position){
                case 0:
                    holder.icon.setImageResource(R.drawable.cromomessi);
                    break;
                case 1:
                    holder.icon.setImageResource(R.drawable.reyemerito);
                    break;
                case 2:
                    holder.icon.setImageResource(R.drawable.dobla);
                    break;
            }

        }else {
            switch (position) {
                case 0:
                    holder.icon.setImageResource(R.drawable.coleccion_cromos);
                    break;
                case 1:
                    holder.icon.setImageResource(R.drawable.coleccion_heman);
                    break;
                case 2:
                    holder.icon.setImageResource(R.drawable.coleccion_sellos);
                    break;
                case 3:
                    holder.icon.setImageResource(R.drawable.coleccion_cromos);
                    break;
                case 4:
                    holder.icon.setImageResource(R.drawable.ic_shoes_collection);
                    break;
                case 5:
                    holder.icon.setImageResource(R.drawable.ic_coins_collection);
                    break;

            }
        }
        holder.subtitulo.setText("50/200");//hacer otra lógica al respecto
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
