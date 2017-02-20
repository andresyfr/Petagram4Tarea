package com.andresyfr.petagram2tarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private MascotaAdaptador mascotaAdaptador;

    private Acciones accionesMenus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accionesMenus = Acciones.getInstance();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvLstMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        //inicializarListaContactos();
        //inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return accionesMenus.accionesMune(item, super.onOptionsItemSelected(item), this);
    }

    public void inicializarListaContactos(){
        mascotas = accionesMenus.getMascotas();
    }

    public void inicializarAdaptador(){
        mascotaAdaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(mascotaAdaptador);

        mascotaAdaptador.notifyDataSetChanged();
        //invalidateViews();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
        intent.putExtra(getResources().getString(R.string.pNombre), mascotas.get(position).getNombre());
        intent.putExtra(getResources().getString(R.string.pTelefono), mascotas.get(position).getTelefono());
        intent.putExtra(getResources().getString(R.string.pEmail), mascotas.get(position).getEmail());
        startActivity(intent); */
        //finish();
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
