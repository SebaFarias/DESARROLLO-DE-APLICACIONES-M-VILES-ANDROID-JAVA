package com.example.mapistasjava.model;

import java.util.ArrayList;

public class Mapa {

    private int id;
    private int authorId;
    private String nombre;
    private String authorDisplayName;
    private String descripción;
    private ArrayList<Spot> puntos;
    private ArrayList<Coment> comentarios;
    private ArrayList<Reaction> reacciones;

    public Mapa(
            int id,
            int authorId,
            String nombre,
            String authorDisplayName,
            String descripción,
            ArrayList<Spot> puntos,
            ArrayList<Coment> comentarios,
            ArrayList<Reaction> reacciones)
    {
        this.id = id;
        this.authorId = authorId;
        this.nombre = nombre;
        this.authorDisplayName = authorDisplayName;
        this.descripción = descripción;
        this.puntos = puntos;
        this.comentarios = comentarios;
        this.reacciones = reacciones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public void setPuntos(ArrayList<Spot> puntos) {
        this.puntos = puntos;
    }

    public void setComentarios(ArrayList<Coment> comentarios) {
        this.comentarios = comentarios;
    }

    public void setReacciones(ArrayList<Reaction> reacciones) {
        this.reacciones = reacciones;
    }

    public int getId() {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public String getDescripción() {
        return descripción;
    }

    public ArrayList<Spot> getPuntos() {
        return puntos;
    }

    public ArrayList<Coment> getComentarios() {
        return comentarios;
    }

    public ArrayList<Reaction> getReacciones() {
        return reacciones;
    }

    public boolean agregarSpot(Spot newPunto )
    {
        try {
            puntos.add(newPunto);
            return true;
        }catch( Exception ex ){
            return false;
        }
    }
}
