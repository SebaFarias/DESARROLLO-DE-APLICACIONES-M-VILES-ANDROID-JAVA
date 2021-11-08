package com.example.mapistasjava.model;

import java.util.ArrayList;

public class Coment {

    private int id;
    private int authorId;
    private String authorDisplayName;
    private ArrayList< Coment > respuesta;
    private ArrayList< Reaction > reaccion;

    public Coment(int id, int authorId, String authorDisplayName, ArrayList<Coment> respuesta, ArrayList<Reaction> reaccion) {
        this.id = id;
        this.authorId = authorId;
        this.authorDisplayName = authorDisplayName;
        this.respuesta = respuesta;
        this.reaccion = reaccion;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public void setRespuesta(ArrayList<Coment> respuesta) {
        this.respuesta = respuesta;
    }

    public void setReaccion(ArrayList<Reaction> reaccion) {
        this.reaccion = reaccion;
    }

    public int getId() {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public ArrayList<Coment> getRespuesta() {
        return respuesta;
    }

    public ArrayList<Reaction> getReaccion() {
        return reaccion;
    }
}
