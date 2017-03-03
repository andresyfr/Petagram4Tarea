package com.andresyfr.petagram2tarea.controlador;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.andresyfr.petagram2tarea.BiografiaActivity;
import com.andresyfr.petagram2tarea.Correo.MenuContacto;
import com.andresyfr.petagram2tarea.MascotasFavoritas;
import com.andresyfr.petagram2tarea.R;
import com.andresyfr.petagram2tarea.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by andres on 18/02/17.
 */

public class Acciones implements View.OnClickListener{

    /**objeto Singleton*/
    private static Acciones singlenAcciones=null;
    private ArrayList<Mascota> mascotas;

    private Acciones(){
        this.mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.conejo,"Conejo Pancho", true, 5));
        mascotas.add(new Mascota(R.drawable.gato,"Gato Pancho", false, 4));
        mascotas.add(new Mascota(R.drawable.pato,"Pato Donald", true, 3));
        mascotas.add(new Mascota(R.drawable.tortuga,"Tortuga Nija", false, 2));
        mascotas.add(new Mascota(R.drawable.perro,"Perro Dalmata", true, 4));
        mascotas.add(new Mascota(R.drawable.perro2,"Perra lika", true, 5));
        mascotas.add(new Mascota(R.drawable.perro3,"Perro Lufi", true, 5));
    }

    public static Acciones getInstance() {
        if (singlenAcciones == null) {
            synchronized (Acciones.class) {
                if (singlenAcciones == null) {
                    singlenAcciones = new Acciones();
                }
            }
        }
        return singlenAcciones;
    }

    @Override
    public void onClick(View v) {

    }

    public boolean accionesMune(MenuItem item, boolean superOption, Activity activity){
        Intent intent=null;
        switch (item.getItemId()) {
            case R.id.actionFavoritos:
                intent=new Intent(activity, MascotasFavoritas.class);
                activity.startActivity(intent);
                //Log.i("ActionBar", "actionFavoritos!");
                return true;
            case R.id.actionAcercaDe:
                intent=new Intent(activity, BiografiaActivity.class);
                activity.startActivity(intent);
                Toast.makeText(activity.getApplicationContext(),"Aplicación realizada por ANDRES FELIPE RAMIREZ CAICEDO: andresyfr@gmail.com",Toast.LENGTH_SHORT).show();
                //Log.i("ActionBar", "acerca de!");;
                return true;
            case R.id.actionContacto:
                intent=new Intent(activity, MenuContacto.class);
                activity.startActivity(intent);
                Toast.makeText(activity.getApplicationContext(),"Contacto Aplicación realizada por ANDRES FELIPE RAMIREZ CAICEDO: andresyfr@gmail.com",Toast.LENGTH_SHORT).show();
                //Log.i("ActionBar", "acerca de!");;
                return true;
            default:
                return superOption;
        }
    }

    public boolean cambiarDatosMascotas(Mascota mascotaOriginal, Mascota mascotaCambiada){
        int i=0;
        while (i<mascotas.size()){
            if(mascotas.get(i).getCalificacion()==mascotaOriginal.getCalificacion() && mascotas.get(i).getNombreMascota().equals(mascotaOriginal.getNombreMascota()) && mascotas.get(i).getFotoMascota() == mascotaOriginal.getFotoMascota()){
                mascotas.set(i,mascotaCambiada);
                return true;
            }
            i++;
        }return false;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
}
