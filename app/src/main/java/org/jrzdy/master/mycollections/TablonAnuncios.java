package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class TablonAnuncios extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayentidad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablon_anuncios);

        lvItems = (ListView) findViewById(R.id.lvitems);
        arrayentidad = GetArrayItems();
        adaptador = new Adaptador(this, arrayentidad);
        lvItems.setAdapter(adaptador);

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TablonAnuncios.this, DetalleTabAnuncios.class);
                intent.putExtra("objetoData", arrayentidad.get(position));
                startActivity(intent);
            }
        });
    }
    private ArrayList<Entidad> GetArrayItems (){
        ArrayList<Entidad> listItems = new ArrayList<>();
        listItems.add(new Entidad(R.drawable.ic_trobada_del_disc, "Trobada del disc", "Antigüedades, Arte, Coleccionismo, Coleccionistas, Música",
                "Anualmente, Fira de Lleida programa más de 30 certámenes al año, lo que sitúa Lleida como el segundo municipio de Cataluña que más organiza. La Llotja, el nuevo Palacio de Congresos y Convenciones, ha incrementado decisivamente un potencial que irá a más en el futuro con la ejecución del plan estratégico de Fira de Lleida."
                ,"Del viernes 15 al domingo 17 de diciembre 2017" ));
        listItems.add(new Entidad(R.drawable.ic_lleidantic, "Lleidantic","Antigüedades, Articulos decorarivos, Coleccionismo, Muebles, Pintura",
                "Lleidantic es un salón donde se dan cita los anticuarios, coleccionistas y amantes de las antigüedades para comprar, vender o intercambiar piezas de valor histórico.\n" +
                        "\n" +
                        "En el área expositiva de Lleidantic tienen cabida desde muebles y artículos de decoración hasta pintura, escultura, libros, sellos o joyas con certificado de antigüedad."
                ,"Del viernes 24 al sábado 25 de diciembre 2017"));
        listItems.add(new Entidad(R.drawable.ic_replega,"Replega","Feria Nacional de Coleccionismo General y Popular",
                "Replega es un imán para melómanos que buscan rarezas de vinilos, amantes de los cómics, de los Play Mobil y otros juguetes, pegatinas, postales, pins, llaveros, botellas de cerveza… Pero sobre todo, lo que causa furor son las chapas, los marca páginas y calendarios de bolsillo.",
                "Del viernes 7 al domingo 9 de diciembre 2018"));
        listItems.add(new Entidad(R.drawable.ic_arco_madrid, "Arco Madrid","Arte contemporáneo, Coleccionismo, Escultura, Pintura",
                "ARCO (Feria Internacional de ARte COntemporáneo) es una de las principales ferias de arte contemporáneo del circuito internacional que, organizada por IFEMA, se celebra anualmente en la Feria de Madrid, España.\n" +
                        "\n" +
                        "ARCO reúne una oferta artística que va desde las vanguardias históricas, hasta el arte emergente y actual, pasando por el arte moderno y arte contemporáneo.",
                "Del miércoles 21 al domingo 25 de febrero 2018"));

        return listItems;
    }

}

