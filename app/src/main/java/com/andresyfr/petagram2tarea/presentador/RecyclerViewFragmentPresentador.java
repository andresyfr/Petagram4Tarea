package com.andresyfr.petagram2tarea.presentador;

import android.content.Context;

import com.andresyfr.petagram2tarea.db.ConstructorMascotas;
import com.andresyfr.petagram2tarea.pojo.Mascota;
import com.andresyfr.petagram2tarea.vista.fragment.IPerfilFragmentView;
import com.andresyfr.petagram2tarea.vista.fragment.IRecyvlerViewFragmentView;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by andres on 5/03/17.
 */

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresenter{

    private IRecyvlerViewFragmentView iRecyvlerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresentador(IRecyvlerViewFragmentView iRecyvlerViewFragmentView, Context context) {
        this.iRecyvlerViewFragmentView = iRecyvlerViewFragmentView;
        this.context = context;
        constructorMascotas = new ConstructorMascotas(context);
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        mascotas=constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyvlerViewFragmentView.inicializarAdaptadorRV(iRecyvlerViewFragmentView.crearAdaptador(mascotas));
        iRecyvlerViewFragmentView.generarLinearLayoutVertical();
    }
}
