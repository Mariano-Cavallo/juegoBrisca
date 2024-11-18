package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;

public class ConjuntoDeCartas {
    protected ArrayList<Carta> cartas;
    protected int cantidad;



    public ConjuntoDeCartas(){
        this.cartas = new ArrayList<>();
        this.cantidad = 0;
    }

    public Carta agregarCarta(Carta carta){
        this.cartas.add(carta);
        cantidad ++;
        return carta;
    }

    public Carta jugar(int posDeCarta){
        var cartaJugada = cartas.get(posDeCarta+1);
        cartas.remove(posDeCarta+1);
        cantidad--;
        return cartaJugada;
    }
    public Carta sacar(Carta carta){
        cartas.remove(carta);
        cantidad--;
        return carta;
    }

    public ArrayList<Carta> devolverCartas(){
        ArrayList<Carta> cartasDevueltas = new ArrayList<>(cartas);
        cartas.clear();
        cantidad = 0;
        return cartasDevueltas;
    }

    public void agregarCartas(ConjuntoDeCartas conjuntoDeCartas){
        cartas.addAll(conjuntoDeCartas.devolverCartas());
        this.cantidad += conjuntoDeCartas.getCantidad();
    }

    public int getCantidad() {
        return cantidad;
    }

    public int contarPuntuacion(){
        int puntuacion = 0;
        for(Carta c : cartas){
            puntuacion += c.getPuntos();
        }
        return  puntuacion;
    }

}
