package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo extends ConjuntoDeCartas{



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


    @Override
    public String toString() {
        return "Mazo{" +
                "cantidad=" + cantidad +
                ", cartas=" + cartas +
                '}';
    }
}
