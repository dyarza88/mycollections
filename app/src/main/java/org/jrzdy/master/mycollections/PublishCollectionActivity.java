package org.jrzdy.master.mycollections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static org.jrzdy.master.mycollections.RecyclerAdapterr.ViewHolder.getDrawableFromName;

public class PublishCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_collection);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_collections);
        String[] colecciones = {"Coleccion de Heman", "Coleccion de sellos", "Coleccion de Cromos", "Coleccion de comics de DC"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colecciones));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                ImageView imageView = (ImageView) findViewById(R.id.id_img_coleccion);
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        imageView.setImageResource(getDrawableFromName(adapterView.getContext(), "coleccion_heman"));
                        break;
                    case 1:
                        imageView.setImageResource(getDrawableFromName(adapterView.getContext(), "coleccion_sellos"));
                        break;
                    case 2:
                        imageView.setImageResource(getDrawableFromName(adapterView.getContext(), "coleccion_sellos"));
                        break;
                    default:
                        imageView.setImageResource(getDrawableFromName(adapterView.getContext(), "coleccion_cromos"));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // vacio

            }
        });
    }


    public void publishCollection(View view) {
        finish();
    }
}
