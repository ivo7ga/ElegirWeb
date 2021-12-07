package com.example.elegirweb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager paginas;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabs);

        paginas = findViewById(R.id.paginas);
        adaptador = new Adaptador(getSupportFragmentManager(), this);
        paginas.setAdapter(adaptador);

        tabs.setupWithViewPager(paginas);
    }

    //Con estas funciones recibimos los datos desde el setFragment y los enviamos al adapter
    public void recibirDatoWebview1(String dato) {
        adaptador.enviarDatoWebview1(dato);
    }

    public void recibirDatoWebview2(String dato) {
        adaptador.enviarDatoWebview2(dato);
    }

}