package com.example.elegirweb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adaptador extends FragmentPagerAdapter {
    Context context1;

    public Adaptador(FragmentManager fm, Context context) {
        super(fm);
        context1 = context;
    }

    WebviewFragment webview1;
    WebviewFragment2 webview2;

    //Con esta funcion creamos los fragments.
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                webview1 = new WebviewFragment();
                fragment = webview1;
                break;
            case 1:
                webview2 = new WebviewFragment2();
                fragment = webview2;
                break;
            case 2:
                fragment = new setfragment();
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    //Una vez realizadas los fragments, con esta función hacemos que, una vez que nos movamos por ellos, les demos un nombre a las pestañas de los diferentes fragments.
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String titulo;
        switch (position) {
            case 0:
                titulo = context1.getString(R.string.web1);
                break;
            case 1:
                titulo = context1.getString(R.string.web2);
                break;
            case 2:
                titulo = context1.getString(R.string.eligeweb);
                break;
            default:
                titulo = "";
        }
        return titulo;
    }

    //Enviamos los datos tanto al webview 1 como al webView 2 recibidos desde el main activity

    public void enviarDatoWebview1(String dato) {
        webview1.recibirDato(dato);
    }

    public void enviarDatoWebview2(String dato) {
        webview2.recibirDato(dato);
    }
}
