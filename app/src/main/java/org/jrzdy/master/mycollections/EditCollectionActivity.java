package org.jrzdy.master.mycollections;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static org.jrzdy.master.mycollections.MainActivity.almacenArticulos;


/**
 * Created by nakis on 29/11/2017.
 */

public class EditCollectionActivity extends AppCompatActivity {

    private static int REQUEST_CODE_1 = 1234;
    private static String KEY_COLLECTION = "num_colecc";
    private static String KEY_POSITION = "num_col";
    private static String KEY_ARTICLE = "num_art";
    private static String KEY_MARKET = "market";
    private boolean fromMarket = false;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdaptadormA adaptadormA;
    private int coleccion_pasada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcolectionnuevo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(KEY_MARKET)) {
                fromMarket = extras.getBoolean(KEY_MARKET);
            }
            if (extras.containsKey(KEY_COLLECTION)) {
                coleccion_pasada = extras.getInt(KEY_COLLECTION);
            }
        }

        initCollapsingToolbar();
        recyclerView = (RecyclerView) findViewById(R.id.recicladorarticulos);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adaptadormA = new AdaptadormA(this, almacenArticulos.getCollecciones(coleccion_pasada),
                almacenArticulos.getImagcol(coleccion_pasada),
                almacenArticulos.getCantidades(coleccion_pasada));

        recyclerView.setAdapter(adaptadormA);
        if (fromMarket) {
            layoutManager = new LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL, false);
        } else {
            layoutManager = new GridLayoutManager(this, 2);
        }

        recyclerView.setLayoutManager(layoutManager);
        adaptadormA.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = recyclerView.getChildAdapterPosition(v);
                Intent i = new Intent(getApplicationContext(), EditArticleActivity.class);
                i.putExtra(KEY_ARTICLE, pos);
                i.putExtra(KEY_POSITION, coleccion_pasada);
                startActivity(i);
            }
        });

        FloatingActionButton mas = (FloatingActionButton) findViewById(R.id.masartFBnuevo);
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NuevoArticuloActivity.class);
                i.putExtra(KEY_POSITION, coleccion_pasada);
                startActivity(i);
            }
        });

        try {
            Glide.with(this).load(getDrawableForCode(coleccion_pasada)).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getDrawableForCode(int code) {
        switch (code) {
            case 0:
                return R.drawable.coleccion_cromos;
            case 1:
                return R.drawable.coleccion_heman;
            case 2:
                return R.drawable.coleccion_sellos;
            case 3:
                return R.drawable.shoes_collection;
            case 4:
                return R.drawable.coins_collection;
            case 5:
                return R.drawable.coleccion_comics;
            default:
                return R.drawable.coleccion_comics;
        }
    }

    private String getTitleForCode(int code) {
        switch (code) {
            case 0:
                return "Cromos";
            case 1:
                return "Muñecos Heman";
            case 2:
                return "sellos";
            case 3:
                return "Zapatos";
            case 4:
                return "Monedas";
            case 5:
                return "Comics ";
            default:
                return "Nueva Coleccion";
        }
    }

    private String getAutorForCode(int code) {
        switch (code) {
            case 0:
                return "Nuria";
            case 1:
                return "Dyarza";
            case 2:
                return "Esther";
            case 3:
                return "Nuria";
            case 4:
                return "Dieyo Garza";
            case 5:
                return "Jarucas92 ";
            default:
                return "Ziego Yarda";
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        final TextView titleTextView = (TextView) findViewById(R.id.header_title);
        final TextView autorTextView = (TextView) findViewById(R.id.header_author);
        collapsingToolbar.setTitle("");
        titleTextView.setText(getTitleForCode(coleccion_pasada));
        if (fromMarket) {
            autorTextView.setText(getAutorForCode(coleccion_pasada));
        } else {
            autorTextView.setText("");
        }
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getTitleForCode(coleccion_pasada));
                    titleTextView.setText("");
                    autorTextView.setText("");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("");
                    titleTextView.setText(getTitleForCode(coleccion_pasada));
                    if (fromMarket) {
                        autorTextView.setText(getAutorForCode(coleccion_pasada));
                    }
                    isShow = false;
                }
            }
        });
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageSelectActivity.pantalla_foto = 1;
        adaptadormA.updateAdaptadormA(this,
                almacenArticulos.getCollecciones(coleccion_pasada),
                almacenArticulos.getImagcol(coleccion_pasada),
                almacenArticulos.getCantidades(coleccion_pasada));
        adaptadormA.notifyDataSetChanged();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_1 && requestCode == RESULT_OK) {
            //Do nothing since the logic is not implemented yet
        }
    }

    public void editCollection(View view) {
        Intent i = new Intent(EditCollectionActivity.this, NewCollectionActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share:
                compatirTexto("Mira esta colección en la aplicación: http://play.google.com/store/apps/details?id=" + getPackageName());
                return true;
            default:
                // Handle left menu actions
                return super.onOptionsItemSelected(item);
        }
    }

    void compatirTexto(String texto) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, texto);
        startActivity(Intent.createChooser(i, "Selecciona aplicación"));
    }

}
