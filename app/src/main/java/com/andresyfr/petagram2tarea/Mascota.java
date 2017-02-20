package com.andresyfr.petagram2tarea;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by andres on 16/02/17.
 */
@SuppressWarnings("serial")
public class Mascota implements Serializable {

    private int fotoMascota;
    private String nombreMascota;
    private boolean favorito;
    private int calificacion;

    public Mascota(int fotoMascota, String nombreMascota, boolean favorito, int calificacion) {
        this.fotoMascota = fotoMascota;
        this.nombreMascota = nombreMascota;
        this.favorito = favorito;
        this.calificacion = calificacion;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Foto id: "+getFotoMascota()+" Nombre: "+getNombreMascota()+" es favorito: "+isFavorito()+" calificación "+getCalificacion();
    }

}
