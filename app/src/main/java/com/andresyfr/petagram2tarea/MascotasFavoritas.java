package com.andresyfr.petagram2tarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotasFavoritas;
    private MascotaAdaptador mascotaAdaptadorFavoritas;

    private Acciones acciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        acciones = Acciones.getInstance();
        mascotasFavoritas = new ArrayList<Mascota>();


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritas);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvLstMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFavoritas.setLayoutManager(llm);
        //inicializarListaContactos();
        //inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favoritos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return acciones.accionesMune(item,super.onOptionsItemSelected(item),this);
    }

    public void inicializarListaContactos(){
        mascotasFavoritas.clear();
        ArrayList<Mascota> todas = acciones.getMascotas();
        for (Mascota mascotasFavorita:todas) {
            if(mascotasFavorita.isFavorito()) {
                mascotasFavoritas.add(mascotasFavorita);
            }
        }
        if(mascotasFavoritas.isEmpty())Toast.makeText(MascotasFavoritas.this,"No tienes mascotas Favoritas!",Toast.LENGTH_SHORT).show();
    }

    public void inicializarAdaptador(){
        mascotaAdaptadorFavoritas = new MascotaAdaptador(mascotasFavoritas,this);
        listaMascotasFavoritas.setAdapter(mascotaAdaptadorFavoritas);
        mascotaAdaptadorFavoritas.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        inicializarListaContactos();
        inicializarAdaptador();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        inicializarListaContactos();
        inicializarAdaptador();
    }
}
