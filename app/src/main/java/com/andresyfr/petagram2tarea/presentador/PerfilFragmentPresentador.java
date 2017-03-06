package com.andresyfr.petagram2tarea.presentador;

import android.content.Context;

import com.andresyfr.petagram2tarea.db.ConstructorMascotas;
import com.andresyfr.petagram2tarea.pojo.Mascota;
import com.andresyfr.petagram2tarea.vista.fragment.IPerfilFragmentView;
import com.andresyfr.petagram2tarea.vista.fragment.IRecyvlerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by andres on 5/03/17.
 */

public class PerfilFragmentPresentador implements IRecyclerViewFragmentPresenter{

    private IPerfilFragmentView iPerfilFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public PerfilFragmentPresentador(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;
        constructorMascotas = new ConstructorMascotas(context);
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        mascotas=constructorMascotas.obtenerDatosPrimeraMascota();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iPerfilFragmentView.inicializarAdaptadorRV(iPerfilFragmentView.crearAdaptador(mascotas));
        iPerfilFragmentView.generarLinearLayoutVertical();
    }
}
