package ar.edu.unlu.poo.juego.modelos;

import java.io.Serializable;

public class Carta implements Serializable {
    private Palo palo;
    private int valor;
    private int puntos;



    public Carta(Palo palo,int valor,int puntos){
        this.palo = palo;
        this.valor = valor;
        this.puntos = puntos;
    }

    public int getPuntos(){
        return puntos;
    }



    public Palo getPalo() {
        return palo;
    }
    public boolean mismoPalo(Palo p){
        return this.palo == p;
    }


    @Override
    public String toString() {
        return valor +
                " " + palo +
                "\n";
    }


    public String getNombre() {
        return valor + " " + getPalo();
    }
}
