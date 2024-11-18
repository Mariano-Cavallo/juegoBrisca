package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;

public class Tablero {
    private ConjuntoDeCartas baza;
    private Carta cartaDeTriunfo;
    private Mazo mazo;
    private ArrayList<Jugador> jugadores;
    private int turnoActual = -1;



    public Tablero(Mazo mazo){
        this.mazo = mazo;
        this.baza = new ConjuntoDeCartas();
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void setCartaDeTriunfo(Carta carta){
        cartaDeTriunfo = carta;
    }

    public Carta getCartaDeTriunfo() {
        return cartaDeTriunfo;
    }

    public void agregarCartaBaza(Carta carta){
        baza.agregarCarta(carta);
    }

    public ConjuntoDeCartas darBaza(){
        return baza;
    }
    public int getCantidadMazo(){
        return mazo.getCantidad();
    }

    public Jugador getJugador(int i){
        return jugadores.get(i);
    }

    public int cantidadJugadores(){
        return jugadores.size();
    }
    public Carta robarCartaMazo(){
        return mazo.robar();
    }

    public void siguienteTurno(){
        turnoActual = (turnoActual + 1)% jugadores.size();
    }
    public int getTurnoActual(){
        return turnoActual;
    }
    public void setTurnoActual(int turno){
        this.turnoActual = turno;
    }
    // ver cuando no se pueda robar
    public void repartir(int idJugador,int cantidad){
        for(int i = 0;i < cantidad;i++) {
            getJugador(idJugador).agregarCarta(robarCartaMazo());
        }
    }
    public void jugadorRoba(int idJugador){
        getJugador(idJugador).agregarCarta(robarCartaMazo());
    }



    public int ganadorDeRonda(){
        return baza.getDueño(baza.cartaGanadoraRonda(cartaDeTriunfo));

    }



}
