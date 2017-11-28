package org.android.master.mycollections;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Javier on 26/11/2017.
 */

public class RecyclerAdapterr extends RecyclerView.Adapter<RecyclerAdapterr.ViewHolder>{

    private ArrayList<Colecciones> listaColecciones;
    private  OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int posicion);
    }

    public RecyclerAdapterr(ArrayList<Colecciones> listaColecciones, OnItemClickListener listener){
        this.listaColecciones = listaColecciones;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adaptador_colecciones,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(listaColecciones.get(position),position,listener);
    }

    @Override
    public int getItemCount() {
        return listaColecciones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtColeccion;
        TextView txtUsuario;
        TextView txtCantidad;
        ImageView ivFondo;
        CheckBox fav;

        public ViewHolder(View itemView) {
            super(itemView);

            txtColeccion=(TextView)itemView.findViewById(R.id.txtColeccion);
            txtCantidad=(TextView)itemView.findViewById(R.id.txtNumbers);
            txtUsuario=(TextView)itemView.findViewById(R.id.txtUser);
            ivFondo=(ImageView) itemView.findViewById(R.id.ivColeccion);
            fav=(CheckBox) itemView.findViewById(R.id.checkBox1);

        }

        public void bind(final Colecciones Coleccion, final int posicion, final OnItemClickListener listener) {
            txtColeccion.setText(Coleccion.getColeccion());
            txtCantidad.setText(Coleccion.getCantidad());
            txtUsuario.setText(Coleccion.getUsuario());
            ivFondo.setImageResource(getDrawableFromName(ivFondo.getContext(), Coleccion.getFondo()));
            fav.setChecked(Coleccion.isFav());

            //Metodo onclic cuando nosotros precionemos un elemento se retornara la posicion
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(posicion);
                }
            });

        }

        public static int getDrawableFromName(Context context, String drawableName) {
            return context.getResources().getIdentifier(drawableName, "drawable",
                    context.getPackageName());
        }
    }

    public void setFilter(ArrayList<Colecciones> listaColecciones){
        this.listaColecciones = new ArrayList<>();
        this.listaColecciones.addAll(listaColecciones);
        notifyDataSetChanged();

    }

}