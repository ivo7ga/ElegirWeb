package com.example.elegirweb;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class setfragment extends Fragment implements View.OnClickListener {

    EditText texto1;
    EditText texto2;
    Button boton;
    Button boton2;
    ProgressBar barra;
    ProgressBar barra2;
    int i = 0;
    CountDownTimer time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.set_layout, container, false);
        texto1 = view.findViewById(R.id.texto1);
        texto2 = view.findViewById(R.id.texto2);
        boton = view.findViewById(R.id.boton);
        boton2 = view.findViewById(R.id.boton2);
        boton.setOnClickListener(this);
        boton2.setOnClickListener(this);
        barra = view.findViewById(R.id.barra);
        barra2 = view.findViewById(R.id.barra2);
        return view;
    }

    //con el metdodo del onclick enviamos el String introducido en el setfragment hacia el main activity el cual lo enviara al adaptador para comunicarse con los fragments
    @Override
    public void onClick(View v) {
        MainActivity mainActivity = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.boton:
                String texto = texto1.getText().toString();
                mainActivity.recibirDatoWebview1(texto);
                View vista = getView().findViewById(R.id.snack);
                if ((texto.startsWith("https://www.") || texto.startsWith("http://www.")) && (texto.endsWith(".com") || texto.endsWith(".es"))) {
                    barra.setVisibility(View.VISIBLE);
                    timer(barra);
                } else {
                    Snackbar.make(vista, getString(R.string.errorUrl), Snackbar.LENGTH_LONG).show();
                }

                break;
            case R.id.boton2:
                String text = texto2.getText().toString();
                mainActivity.recibirDatoWebview2(text);
                View vista2 = getView().findViewById(R.id.snack);
                if ((text.startsWith("https://www.") || text.startsWith("http://www.")) && (text.endsWith(".com") || text.endsWith(".es"))) {
                    barra2.setVisibility(View.VISIBLE);
                    timer(barra2);
                } else {
                    Snackbar.make(vista2, getString(R.string.errorUrl), Snackbar.LENGTH_LONG).show();
                }
                break;
        }

    }

    //He creado esta funcion para hacer que el progressbar tenga una duracion de 2,5 segundos y vaya aumentando para la carga de la web
    public void timer(ProgressBar progressBar) {
        progressBar.setProgress(0);
        i = 0;
        time = new CountDownTimer(2500, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(i += 10);
                Log.d("onTick", "" + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                if (progressBar.getId() == R.id.barra) {
                    Snackbar.make(getView(), getString(R.string.valido1), Snackbar.LENGTH_LONG).show();
                } else {

                    Snackbar.make(getView(), getString(R.string.valido2), Snackbar.LENGTH_LONG).show();
                }
            }
        };
        time.start();
    }
}


