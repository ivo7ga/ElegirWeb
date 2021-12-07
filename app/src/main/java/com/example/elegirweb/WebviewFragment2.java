package com.example.elegirweb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WebviewFragment2 extends Fragment {

    WebView webView2;
    String datoRecibido;
    Boolean bool = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String url = "https://www.google.es";
        View view = inflater.inflate(R.layout.fragment_layout2, container, false);
        webView2 = view.findViewById(R.id.web2);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new WebViewClient());


        if (bool) {
            webView2.loadUrl(datoRecibido);
        } else {
            webView2.loadUrl(url);
        }

        return view;
    }

    //recibimos los datos del adapter
    public void recibirDato(String dato) {
        datoRecibido = dato;
        bool = true;
        webView2.setWebViewClient(new WebViewClient());
        webView2.loadUrl(dato);
    }
}
