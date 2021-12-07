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

public class WebviewFragment extends Fragment {


    WebView webView;
    String datoRecibido;
    Boolean bool = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String url = "https://www.marca.com";
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        webView = view.findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        if (bool) {
            webView.loadUrl(datoRecibido);
        } else {
            webView.loadUrl(url);
        }

        return view;
    }

    //recibimos los datos del adapter
    @Override
    public void onResume() {
        super.onResume();
    }

    public void recibirDato(String dato) {
        datoRecibido = dato;
        bool = true;
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(dato);
    }
}