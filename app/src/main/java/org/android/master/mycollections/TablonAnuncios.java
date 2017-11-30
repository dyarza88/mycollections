package org.android.master.mycollections;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;



public class TablonAnuncios extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablon_anuncios);

        lvItems = (ListView) findViewById(R.id.lvitems);
        adaptador = new Adaptador(this, GetArrayItems());
        lvItems.setAdapter(adaptador);
    }
    private ArrayList<Entidad> GetArrayItems (){
        ArrayList<Entidad> listItems = new ArrayList<>();
        listItems.add(new Entidad(R.drawable.trobada_del_disc, "Trobada del disc", "Antigüedades, Arte, Coleccionismo, Coleccionistas, Música"
                ,"Del viernes 15 al domingo 17 de diciembre 2017" ));
        listItems.add(new Entidad(R.drawable.lleidantic, "Lleidantic","Antigüedades, Articulos decorarivos, Coleccionismo, Muebles, Pintura"
                ,"Del viernes 24 al sábado 25 de diciembre 2017"));
        listItems.add(new Entidad(R.drawable.replega,"Replega","Feria Nacional de Coleccionismo General y Popular",
                "Del viernes 7 al domingo 9 de diciembre 2018"));
        listItems.add(new Entidad(R.drawable.arco_madrid, "Arco Madrid","Arte contemporáneo, Coleccionismo, Escultura, Pintura",
                "Del miércoles 21 al domingo 25 de febrero 2018"));

        return listItems;
    }

}