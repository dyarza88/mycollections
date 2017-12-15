package org.jrzdy.master.mycollections;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private static String KEY_COLLECTION = "num_colecc";
    private static String KEY_LOGGED = "logged";
    private boolean isLoged = false;
    private String[] mTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    public static AlmacenColecciones almacenColecciones = new AlmacenColecciones();
    public static AlmacenArticulos almacenArticulos = new AlmacenArticulos();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdaptadormC adaptadormC;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-2551868595254778~9143474070");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Toast.makeText(MainActivity.this, "Anuncio cargado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Toast.makeText(MainActivity.this, "Error cargando el anuncio", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(KEY_LOGGED)) {
                isLoged = extras.getBoolean(KEY_LOGGED);
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.contenedor_rv_miscoleccsB);
        adaptadormC = new AdaptadormC(this, almacenColecciones.getColecciones(), almacenColecciones.getImagcol(), almacenColecciones.getPorcentajeCompleto());
        recyclerView.setAdapter(adaptadormC);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adaptadormC.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = recyclerView.getChildAdapterPosition(v);
                Intent i = new Intent(getApplicationContext(), EditCollectionActivity.class);
                i.putExtra(KEY_COLLECTION, pos);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this,
                        new Pair<View, String>(v, getString(R.string.transition_name_camara)));
                ActivityCompat.startActivity(MainActivity.this, i, options.toBundle());
            }
        });

        mTitles = getResources().getStringArray(R.array.menu_array);
        if (isLoged) {
            mTitles[4] = "Configuracion";
        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        new RateMyApp(this).app_launched();
    }

    @Override
    protected void onResume() {
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        super.onResume();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.menu_new:
                Intent i = new Intent(this, NewCollectionActivity.class);
                startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                // Abre el anuncio
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Toast.makeText(this, "El anuncio no está cargado aún", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                // Handle left menu actions
                return super.onOptionsItemSelected(item);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        switch (position) {

            case 1:
                startActivity(
                        new Intent(this, MarketActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case 2:
                Intent intentForo = new Intent(this, ForoActivity.class);
                startActivity(intentForo, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case 3:
                Intent i = new Intent(this, TablonAnuncios.class);
                startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case 4:
                if (isLoged) {
                    Intent intent_editarperfil = new Intent(this, EditarPerfil.class);
                    intent_editarperfil.putExtra("Name", "A");
                    intent_editarperfil.putExtra("Email", "a@gmail.com");
                    intent_editarperfil.putExtra("Telefono", "555555555");
                    intent_editarperfil.putExtra("Direccion", "C/ A nº12, 1º A");
                    startActivity(intent_editarperfil, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(
                            new Intent(this, LoginActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
