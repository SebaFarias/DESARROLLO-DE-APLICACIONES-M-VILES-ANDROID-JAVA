package com.example.gatosebas.model;

public class Tablero {

    boolean finalizado;
    String[][] arreglo;
    Turno turno;

    public Tablero (){
        this.arreglo = new String[][]{{" "," "," "},{" "," "," ",},{" "," "," "}};
        this.turno = new Turno();
        this.finalizado = false;
    }
    public void reiniciar(){
        this.arreglo = new String[][]{{" "," "," "},{" "," "," ",},{" "," "," "}};
        this.turno = new Turno();
        this.finalizado = false;
    }
    private boolean isFree(int fila, int columna){
        return arreglo[fila][columna].equals(" ");
    }
    public String getTurno (){
        return this.turno.getTurno();
    }
    public String getTurnoAnterior(){
        String anterior;
        if(this.turno.getTurno().equals("x")){
            anterior = "o";
        }else{
            anterior = "x";
        }
        return anterior;
    }
    public boolean marcarCelda(int fila, int columna){
        if(isFree(fila,columna) && !this.finalizado){
            this.arreglo[fila][columna] = this.getTurno();
            this.turno.proximoTurno();
            return true;
        }else{
            return false;
        }
    }
    public String checkWin(){
        return "";
    }
}
