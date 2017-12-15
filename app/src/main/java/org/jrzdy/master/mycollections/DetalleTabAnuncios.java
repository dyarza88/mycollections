package org.jrzdy.master.mycollections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;



public class DetalleTabAnuncios extends AppCompatActivity {

    private Entidad Item;
    private TextView tvTitulo, tvDescripcion, tvFecha, tvDescDetallada;
    private ImageView imgFoto;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.detalle_item);

        Item = (Entidad) getIntent().getSerializableExtra("objetoData");

        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        imgFoto = (ImageView)findViewById(R.id.imgFoto);
        tvDescDetallada = (TextView)findViewById(R.id.tvDescDetallada);

        tvTitulo.setText(Item.getTitulo());
        imgFoto.setImageResource(Item.getImgFoto());
        tvDescripcion.setText(Item.getContenido());
        tvFecha.setText(Item.getFecha());
        tvDescDetallada.setText(Item.getDescripcion());
    }
}

