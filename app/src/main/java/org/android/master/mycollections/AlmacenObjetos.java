package org.android.master.mycollections;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.Vector;

/**
 * Created by nakis on 30/11/2017.
 */

public interface AlmacenObjetos {
    public Vector<String> listaObjetos(int tipo);
    public int[] listaFotos(int tipo);
    public Vector<String>cantidades(int tipo);
}
