package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;

public class ConjuntoDeCartas {
    protected ArrayList<Carta> cartas;
    protected int cantidad;


    public Carta getUltimaAgregada(){
        return cartas.getLast();

    }
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
        cantidad--;
        return cartas.remove(posDeCarta-1);
    }
    public Carta sacar(Carta carta){
        cartas.remove(carta);
        cantidad--;
        return carta;
    }
    public Carta getCarta(int posDeCarta){
        return cartas.get(posDeCarta-1);
    }

    public ArrayList<Carta> devolverCartas(){
        ArrayList<Carta> cartasDevueltas = new ArrayList<>(cartas);
        cartas.clear();
        cantidad = 0;
        return cartasDevueltas;
    }

    public void agregarCartas(ConjuntoDeCartas conjuntoDeCartas){
        cartas.addAll(conjuntoDeCartas.cartas);
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

    //OJO TIENEN QUE SER DEL MISMO PALO
    public Carta mayorPuntuacion(){
        Carta mayorPuntos = cartas.getFirst();
        for(Carta c: cartas){
            if(c.getPuntos() > mayorPuntos.getPuntos()){
                mayorPuntos = c;
            }
        }
        return mayorPuntos;
    }


    public void borrar() {
        cartas.clear();
        cantidad = 0;
    }
}




