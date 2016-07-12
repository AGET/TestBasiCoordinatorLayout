package com.aldo.aget.testbasicoordinatorlayout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lstLista;
    private FloatingActionButton btnFab;
    private CollapsingToolbarLayout ctlLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //App bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Mi Aplicación");

        //RecyclerView
        //RecyclerView lstLista = (RecyclerView)findViewById(R.id.lstLista);
        lstLista = (RecyclerView) findViewById(R.id.lstLista);

        ArrayList<Datos> datos = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            datos.add(new Datos("Título " + i, "Subtítulo item " + i));

        AdaptadorDatos adaptador = new AdaptadorDatos(datos);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("AGET", "Pulsado el elemento " + lstLista.getChildPosition(v));
                Toast.makeText(MainActivity.this, "Pulsado el elemento " + lstLista.getChildPosition(v), Toast.LENGTH_SHORT).show();
            }
        });

        lstLista.setAdapter(adaptador);

        lstLista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lstLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        lstLista.setItemAnimator(new DefaultItemAnimator());

        //TabLayout
        //TabLayout tabLayout = (TabLayout) findViewById(R.id.appbartabs);
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        btnFab = (FloatingActionButton) findViewById(R.id.btnFab);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Esto es una prueba", Snackbar.LENGTH_LONG).show();
            }
        });

        //CollapsingToolbarLayout
        ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle("Mi animacion");
    }
}
