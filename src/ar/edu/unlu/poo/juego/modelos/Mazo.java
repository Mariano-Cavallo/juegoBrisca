package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo extends ConjuntoDeCartas{

    //hacer
    private boolean puedeRobar;

    public Mazo(){
        super();
    }


    public Carta robar(){
        cantidad --;
        return cartas.removeLast();

    }
    public void mezclar(){
        Collections.shuffle(cartas);
    }
    public void agregarValorCartas(){
        for(Carta c: cartas){
            c.setValorFicticio();
        }
    }


    @Override
    public String toString() {
        return "Mazo{" +
                "cantidad=" + cantidad +
                ", cartas=" + cartas +
                '}';
    }
}
