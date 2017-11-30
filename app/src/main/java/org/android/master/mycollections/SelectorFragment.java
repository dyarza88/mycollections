package org.android.master.mycollections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nakis on 30/11/2017.
 */

public class SelectorFragment extends Fragment {
    private RecyclerView recyclerViewmC;
    public static AdaptadormC adaptadormC;
    /*
    public SelectorFragment{}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contenedor_recyclerview_miscoleccs, container, false);
        recyclerViewmC= (RecyclerView) rootView.findViewById(R.id.contenedor_rv_miscoleccs);
        //
        RecyclerView.LayoutManager layoutManagermC=new LinearLayoutManager(getContext());
        recyclerViewmC.setLayoutManager(layoutManagermC);
        //layoutManagermC.setAutoMeasureEnabled(true);//se puede quitar
        adaptadormC=new AdaptadormC(getContext(),MainActivity.almacenColecciones.listaObjetos(1));
        //
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        RecyclerView.LayoutManager layoutManagermC=new LinearLayoutManager(getContext());
        recyclerViewmC.setLayoutManager(layoutManagermC);
        //layoutManagermC.setAutoMeasureEnabled(true);//se puede quitar
        adaptadormC=new AdaptadormC(getContext(),MainActivity.almacenColecciones.listaObjetos(1));


        //o esto
        adaptadormC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=recyclerViewmC.getChildAdapterPosition(v);
                String s=MainActivity.almacenColecciones.listaObjetos(1).get(pos);
                Intent i=new Intent(getContext(),EditCollectionActivity.class);
                //i.putExtra("clave",valor);
                startActivity(i);
            }
        });

        //o esto
        adaptadormC.setOnItemClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(getContext(),EditCollectionActivity.class);
                //i.putExtra("clave",valor);
                startActivity(i);
            }
        });


        recyclerViewmC.setAdapter(adaptadormC);
    }

*/

}
