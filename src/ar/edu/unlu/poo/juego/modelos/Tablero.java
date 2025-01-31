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




    public Tablero(){
        this.mazo = new Mazo();
        this.baza = new Baza();
        jugadores = new ArrayList<>();
    }

    public void nuevoMazo(){
        this.mazo = new Mazo();
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
    public void borrarObservador(Observador observador) {
        this.observadores.remove(observador);
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

        notificarObservador(Eventos.RONDA_TERMINADA);
        getJugador(ganadorDeRonda()).agregarCartasGanadas(this.baza);
        this.baza.borrar();
    }

    public int getUltimoGanador() {
        return ultimoGanador;
    }

    public void darTurnoAlGanador() {
        setTurnoActual(ultimoGanador);
        notificarObservador(Eventos.SIGUIENTE_TURNO);
    }


    public int jugadorPuedeCambiarLaCartaDeTriunfo() {
        int idJugador = -1;
        for(Jugador jugador : jugadores){
            if(jugador.tieneEl7DelPalo(cartaDeTriunfo)){
                idJugador = jugador.getId();
                break;
            }
        }
        return idJugador;
    }



    public boolean sePuedeRobarCarta() {
        return cantidadJugadores() <= getCantidadMazo();
    }

    //se fija si el primer jugador tiene almenos una carta
    public boolean jugadoresTienenCartas() {
        return getJugador(0).cantidadCartas() > 0;
    }

    public void contarTodosLosPuntos(){
        for(Jugador j : jugadores){
            j.contarPuntuacion();
        }
        notificarObservador(Eventos.TERMINAR_PARTIDA);
    }

    public int ganadorHasta3Jugadores(){
        int ganador = 0;
        int puntuacionGanadora = 0 ;
        int flag = 0 ;
        for (Jugador j : jugadores){
            if(flag == 0){
                puntuacionGanadora = j.getPuntuacion();
                ganador = j.getId();
                flag ++;
            }
            if(j.getPuntuacion() > puntuacionGanadora){
                ganador = j.getId();
                puntuacionGanadora = j.getPuntuacion();
            }
        }
        return ganador;
    }

    public int ganador4Jugadores(){
        int puntosEquipo1;
        int puntosEquipo2;
        puntosEquipo1 = getJugador(0).getPuntuacion() + getJugador(2).getPuntuacion();
        puntosEquipo2 = getJugador(1).getPuntuacion() + getJugador(3).getPuntuacion();

        if(puntosEquipo1 > puntosEquipo2){
            return 0;
        }
        else{
            return 1;
        }

    }


    public void empezarPartida() {
        notificarObservador(Eventos.COMENZAR_PARTIDA);
    }

    public void borrarJugador(int idJugador) {
        jugadores.remove(idJugador);
    }

    public void borrarJugadores() {
        jugadores.get(0).reiniciarContadorId();
        jugadores.clear();
        notificarObservador(Eventos.REINICIO_PARTIDA);
    }
}
