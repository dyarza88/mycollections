package org.jrzdy.master.mycollections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nakis on 13/12/2017.
 */

public class ForoActivity extends AppCompatActivity {
    //vbles web
    public String miurl="http://www.rincondelcoleccionista.com/foro/";
    public WebView navegador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foro);


        navegador=(WebView)findViewById(R.id.webkit);

        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.setWebChromeClient(new WebChromeClient());
        navegador.setWebViewClient(new WebViewClient());
        navegador.loadUrl(miurl);


    }
}
