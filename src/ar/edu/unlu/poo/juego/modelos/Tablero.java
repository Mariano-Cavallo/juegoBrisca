package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;
import java.util.List;

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
    public List<Jugador> getJugadores(){
        return jugadores;
    }
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
    public int cantidadJugadores(){
        return jugadores.size();
    }
    public void agregarCartaBaza(Carta carta){
        baza.agregarCarta(carta);
    }

    public void setCartaDeTriunfo(Carta carta){
        cartaDeTriunfo = carta;
    }

    public Carta getCartaDeTriunfo() {
        return cartaDeTriunfo;
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
