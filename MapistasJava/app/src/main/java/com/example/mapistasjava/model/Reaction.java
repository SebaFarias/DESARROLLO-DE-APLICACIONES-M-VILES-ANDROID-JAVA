package com.example.mapistasjava.model;

public class Reaction {

    public final int ME_GUSTA = 0;
    public final int NO_ME_GUSTA = 1;
    private int comentId;
    private int authorId;
    private int tipo;
    private String authorDisplayName;

    public Reaction(int comentId, int authorId, int tipo, String authorDisplayName) {
        this.comentId = comentId;
        this.authorId = authorId;
        this.tipo = tipo;
        this.authorDisplayName = authorDisplayName;
    }

    public void setComentId(int comentId) {
        this.comentId = comentId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public int getComentId() {
        return comentId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getTipo() {
        return tipo;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }
}
