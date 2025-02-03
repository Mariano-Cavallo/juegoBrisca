package ar.edu.unlu.poo.juego.modelos;

import java.io.Serializable;

public class Jugador implements Serializable {
    private int id = -1;
    private String nombre;
    private ConjuntoDeCartas mano;
    private int puntuacion;
    private ConjuntoDeCartas cartasGanadas;


    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new ConjuntoDeCartas();
        this.puntuacion = 0;
        this.cartasGanadas = new ConjuntoDeCartas();
    }

    public Carta mostrarCarta(int numeroCarta){
        return mano.getCarta(numeroCarta);
    }

    public Carta jugarCarta(int PosDeCarta){
        return mano.jugar(PosDeCarta);
    }

    //dudoso
    public void agregarCartasGanadas(ConjuntoDeCartas cartasGanadas){
        this.cartasGanadas.agregarCartas(cartasGanadas);
    }

    public void agregarCarta(Carta carta){
        mano.agregarCarta(carta);
    }


    public void contarPuntuacion(){
        puntuacion = cartasGanadas.contarPuntuacion();
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int cantidadCartas(){
        return mano.cantidad;
    }

    public boolean tieneEl7DelPalo(Carta carta){
        for(Carta c : mano.cartas){
            if(c.mismoPalo(carta.getPalo()) && c.getValor() == 7){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                "id=" + id;
    }

    public Carta get7Triunfo(Carta carta) {
        for(Carta c : mano.cartas){
            if(c.mismoPalo(carta.getPalo()) && c.getValor() == 7){
                return mano.sacar(c);
            }
        }
        return null;
    }

    public void reiniciarPuntuacion() {
        this.puntuacion = 0;
        this.cartasGanadas.borrar();
    }
}
