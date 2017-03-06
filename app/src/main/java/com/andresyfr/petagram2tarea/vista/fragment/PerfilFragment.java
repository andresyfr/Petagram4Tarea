package com.andresyfr.petagram2tarea.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.andresyfr.petagram2tarea.presentador.IRecyclerViewFragmentPresenter;
import com.andresyfr.petagram2tarea.presentador.PerfilFragmentPresentador;
import com.andresyfr.petagram2tarea.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragmentView{

    private RecyclerView listaPerfilesMascotas;
    private PerfilAdaptador mascotaAdaptadorPerfil;
    private IRecyclerViewFragmentPresenter presenter;


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

        listaPerfilesMascotas = (RecyclerView) v.findViewById(R.id.rvLstMascotasPerfil);

        presenter = new PerfilFragmentPresentador(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        //listaPerfilesMascotas.setHasFixedSize(true);
        listaPerfilesMascotas.setLayoutManager(llm);
    }

    @Override
    public PerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        if(mascotas.isEmpty()) Toast.makeText(getActivity(),"La mascota no tiene calificaciones!",Toast.LENGTH_SHORT).show();
        mascotaAdaptadorPerfil = new PerfilAdaptador(mascotas,getActivity());
        return mascotaAdaptadorPerfil;
    }

    @Override
    public void inicializarAdaptadorRV(PerfilAdaptador adaptador) {
        listaPerfilesMascotas.setAdapter(mascotaAdaptadorPerfil);
        mascotaAdaptadorPerfil.notifyDataSetChanged();
    }
}
