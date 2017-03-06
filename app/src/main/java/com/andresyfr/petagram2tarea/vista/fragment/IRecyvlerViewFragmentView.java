package com.andresyfr.petagram2tarea.vista.fragment;

import com.andresyfr.petagram2tarea.adapter.MascotaAdaptador;
import com.andresyfr.petagram2tarea.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by andres on 5/03/17.
 */

public interface IRecyvlerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
