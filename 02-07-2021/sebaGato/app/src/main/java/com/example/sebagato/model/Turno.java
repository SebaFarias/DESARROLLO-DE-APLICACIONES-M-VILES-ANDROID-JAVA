package com.example.sebagato.model;

public class Turno {
    private String turno;

    public Turno (){
        turno = "x";
    }

    public String proximoTurno(){
        String proximo;
        if(this.turno.equals("x")){
            proximo = "o";
        }else{
            proximo = "x";
        }
        this.turno = proximo;
        return proximo;
    }
    public String getTurno () {
        return this.turno;
    }
}
