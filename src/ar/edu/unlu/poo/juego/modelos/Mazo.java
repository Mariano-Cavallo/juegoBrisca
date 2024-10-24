package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private int cantidad;
    private ArrayList<Carta> cartas;


    public Mazo(){
        this.cantidad = 0;
        this.cartas = new ArrayList<>();
    }

    public Carta agregar(Carta carta){
        cartas.add(carta);
        this.cantidad ++;
        return carta;
    }
    public Carta sacar(Carta carta){
        cartas.remove(carta);
        this.cantidad --;
        return carta;
    }
    public Carta robar(){
        this.cantidad --;
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
