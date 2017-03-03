package com.andresyfr.petagram2tarea.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresyfr.petagram2tarea.R;
import com.andresyfr.petagram2tarea.adapter.MascotaAdaptador;
import com.andresyfr.petagram2tarea.controlador.Acciones;
import com.andresyfr.petagram2tarea.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by andres on 2/03/17.
 */

public class RecyclerViewFragment extends Fragment{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private MascotaAdaptador mascotaAdaptador;

    private Acciones accionesMenus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        accionesMenus = Acciones.getInstance();

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvLstMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();
        inicializarListaPerfiles();
        inicializarAdaptador();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        inicializarListaPerfiles();
        inicializarAdaptador();
    }
*/

    public void inicializarListaContactos(){
        mascotas = accionesMenus.getMascotas();
    }

    public void inicializarAdaptador(){
        mascotaAdaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(mascotaAdaptador);

        mascotaAdaptador.notifyDataSetChanged();
        //invalidateViews();

    }

}
