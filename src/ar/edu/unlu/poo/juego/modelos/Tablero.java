package ar.edu.unlu.poo.juego.modelos;

import observadores.Observado;
import observadores.Observador;

import java.util.ArrayList;
import java.util.List;

public class Tablero implements Observado {
    private Baza baza;
    private Carta cartaDeTriunfo;
    private Mazo mazo;
    private ArrayList<Jugador> jugadores;
    private int turnoActual = 0;
    private int cartasJugadas = 0;
    private int ultimoGanador;

    private ArrayList<Observador> observadores = new ArrayList<>();




    public Tablero(Mazo mazo){
        this.mazo = mazo;
        this.baza = new Baza();
        jugadores = new ArrayList<>();
    }


    public int getCantidadBaza(){
        return baza.cantidad;
    }
    public int getCantidadJugadores(){
        return jugadores.size();
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        notificarObservador(Eventos.AGREGAR_JUGADOR);
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

    public int siguienteTurno(){
        turnoActual = (turnoActual + 1)% jugadores.size();
        notificarObservador(Eventos.SIGUIENTE_TURNO);
        return turnoActual;
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
        ultimoGanador = baza.getDueño(baza.cartaGanadoraRonda(cartaDeTriunfo),getTurnoActual(),getCantidadJugadores());
        return ultimoGanador;
    }


    @Override
    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    @Override
    public void notificarObservador(Eventos evento) {
        for (Observador observador : observadores) {
            observador.notificar(evento);
        }
    }

    public Carta getUltimaCartaJugada(){
        return baza.getUltimaAgregada();
    }

    public void jugadorJuegaCarta(int idJugador,int posCarta) {
        cartasJugadas++;
        baza.agregarCarta(jugadores.get(idJugador).jugarCarta(posCarta));
        notificarObservador(Eventos.CARTA_JUGADA);

    }

    public Carta getCartaBaza(int numeroDeCarta) {
        return baza.getCarta(numeroDeCarta);
    }

    public int getCartasJugadas() {
        return cartasJugadas;
    }

    public void setCartasJugadas(int i) {
        cartasJugadas = i;
    }

    public void darBazaAlGanador() {
        getJugador(ganadorDeRonda()).agregarCartasGanadas(this.baza);
        this.baza.borrar();
        notificarObservador(Eventos.RONDA_TERMINADA);
    }

    public int getUltimoGanador() {
        return ultimoGanador;
    }

    public void darTurnoAlGanador() {
        setTurnoActual(ultimoGanador);
        notificarObservador(Eventos.SIGUIENTE_TURNO);
    }


}
