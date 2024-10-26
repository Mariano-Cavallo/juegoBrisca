package ar.edu.unlu.poo.juego.modelos;

import observadores.ObservadorTablero;

public class Tablero implements ObservadorTablero {
    private ConjuntoDeCartas baza;
    private Carta cartaDeTriunfo;
    private Mazo mazo;
    private Jugador jugador1;
    private Jugador jugador2;




    public Tablero(Mazo mazo,Jugador jugador1,Jugador jugador2){
        this.mazo = mazo;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.baza = new ConjuntoDeCartas();
    }

    public void setCartaDeTriunfo(Carta carta){
        cartaDeTriunfo = carta;
    }


}
