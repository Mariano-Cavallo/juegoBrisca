package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> cartas;
    private int cantidad;

    public Mano(){
        this.cartas = new ArrayList<>();
        this.cantidad = 0;
    }

    public Carta agregarCarta(Carta carta){
        this.cartas.add(carta);
        cantidad ++;
        return carta;
    }

    public Carta jugar(Carta carta){
        cartas.remove(carta);
        return carta;
    }

}
