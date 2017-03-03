package com.andresyfr.petagram2tarea.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andresyfr.petagram2tarea.R;
import com.andresyfr.petagram2tarea.adapter.MascotaAdaptador;
import com.andresyfr.petagram2tarea.adapter.PerfilAdaptador;
import com.andresyfr.petagram2tarea.controlador.Acciones;
import com.andresyfr.petagram2tarea.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> perfilesMascotas;
    private RecyclerView listaPerfilesMascotas;
    private PerfilAdaptador mascotaAdaptadorPerfil;

    private Acciones acciones;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =inflater.inflate(R.layout.fragment_perfil, container, false);

        acciones = Acciones.getInstance();
        perfilesMascotas = new ArrayList<Mascota>();


        listaPerfilesMascotas = (RecyclerView) v.findViewById(R.id.rvLstMascotasPerfil);

        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        //listaPerfilesMascotas.setHasFixedSize(true);
        listaPerfilesMascotas.setLayoutManager(llm);
        inicializarListaPerfiles();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaPerfiles(){
        perfilesMascotas.clear();
        ArrayList<Mascota> todas = acciones.getMascotas();
        todas.get(4).setCalificacion(5);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(0);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(3);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(10);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(2);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(3);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(4);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(5);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(1);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));
        todas.get(4).setCalificacion(6);
        perfilesMascotas.add(new Mascota().setMascota(todas.get(4)));

        if(perfilesMascotas.isEmpty()) Toast.makeText(getActivity(),"No tienes mascotas Favoritas!",Toast.LENGTH_SHORT).show();
    }

    public void inicializarAdaptador(){
        mascotaAdaptadorPerfil = new PerfilAdaptador(perfilesMascotas,getActivity());
        listaPerfilesMascotas.setAdapter(mascotaAdaptadorPerfil);
        mascotaAdaptadorPerfil.notifyDataSetChanged();
    }

}
