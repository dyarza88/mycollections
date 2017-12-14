package org.jrzdy.master.mycollections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by esthe on 30/11/2017.
 */

public class DetalleTabAnuncios extends AppCompatActivity {

    private Entidad Item;
    private TextView tvTitulo, tvDescripcion, tvFecha;
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

        tvTitulo.setText(Item.getTitulo());
        imgFoto.setImageResource(Item.getImgFoto());
        tvDescripcion.setText(Item.getContenido());
        tvFecha.setText(Item.getFecha());
    }
}
