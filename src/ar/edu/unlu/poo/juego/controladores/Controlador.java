package ar.edu.unlu.poo.juego.controladores;

import ar.edu.unlu.poo.juego.modelos.Carta;
import ar.edu.unlu.poo.juego.modelos.Eventos;
import ar.edu.unlu.poo.juego.modelos.Jugador;
import ar.edu.unlu.poo.juego.modelos.Tablero;
import ar.edu.unlu.poo.juego.vistas.Consola.VistaConsolaGrafica;

import observadores.Observador;

import java.util.ArrayList;
import java.util.List;

public class Controlador implements Observador {
    private Tablero modeloTablero;
    //inteface
    private VistaConsolaGrafica vista;
    private int idJugador;


    public Controlador(Tablero modeloTablero){
        this.modeloTablero = modeloTablero;
    }


    public int getJugador(){
        return idJugador;
    }

    public void setVista(VistaConsolaGrafica vista) {
        this.vista = vista;
    }

    // Cambiar nombre
    public void crearJugadorEnTablero(String nombre){
        var jugador = new Jugador(nombre);
        idJugador = jugador.getId();
        this.modeloTablero.agregarJugador(jugador);

    }

    public Jugador jugadorTurnoActual(){
        return modeloTablero.getJugador(modeloTablero.getTurnoActual());
    }

    public int cantidadJugadores(){
        return modeloTablero.cantidadJugadores();
    }

    public List<Jugador> obtenerJugadores(){
        return new ArrayList<Jugador>(modeloTablero.getJugadores());
    }

    public boolean esMiTurno(){
        return idJugador == jugadorTurnoActual().getId();
    }

    //setea carta de triunfo y roba 3 cartas para cada jugador
    public void setCartaTriunfo(){
        modeloTablero.setCartaDeTriunfo(modeloTablero.robarCartaMazo());

    }
    //ver si no hay mas cartas en mazo no repartir
    public void repartirUnaCartaTodosLosJugadores(){
        for(int i = 0 ;i<= cantidadJugadores()-1;i++){
            modeloTablero.repartir(i,1);
        }
    }

    public Carta cartaBaza(int numeroDeCarta){
        return modeloTablero.getCartaBaza(numeroDeCarta);
    }
    public int cantidadCartasBaza(){
        return modeloTablero.getCantidadBaza();
    }
    public int cantidadCartasJugador(){
        return modeloTablero.getJugador(idJugador).cantidadCartas();
    }

    public Carta cartaJugador(int numeroDeCarta){
        return modeloTablero.getJugador(idJugador).mostrarCarta(numeroDeCarta);
    }

    public Carta getCartaTriunfo(){return modeloTablero.getCartaDeTriunfo();
    }

    //se ejecuta por cada controlador
    @Override
    public void notificar(Eventos evento) {
        switch (evento){
            case AGREGAR_JUGADOR:
                break;
            case CARTA_JUGADA:
                vista.actualizarBaza(modeloTablero.getUltimaCartaJugada());
                break;
            case SIGUIENTE_TURNO:
                vista.actualizarEstadoJugador();
                break;
            case RONDA_TERMINADA:
                vista.actualizarvista();
                vista.imprimir("El ganador de la ronda es "+ modeloTablero.getJugador((modeloTablero.getUltimoGanador())).getNombre() );
                break;
        }
    }

    // otro if para terminar la partida
    public void siguienteTurno() {
        modeloTablero.siguienteTurno();
        if (modeloTablero.getCartasJugadas() == cantidadJugadores()){
            modeloTablero.setCartasJugadas(0);
            terminarRonda();
        }
    }
    //dar baza al ganador y darle el turno al ganador _/ done
    // robar carta_/ done
    //si no hay mas cartas para robar se termina en dos rondas mas
    //preguntar si estas funciones deverian estar en el controlador o en el modelo
    //en el modelo EJ darBazaAlGanador o el controlador repartirUnaCartaTodosLosJugadores
    public void terminarRonda() {
        repartirUnaCartaTodosLosJugadores();
        modeloTablero.darBazaAlGanador();
        modeloTablero.darTurnoAlGanador();

    }

    public void jugarCarta(int posCarta) {
        modeloTablero.jugadorJuegaCarta(idJugador,posCarta);
    }

    public void repartir3Jugador() {
        modeloTablero.repartir(idJugador,3);
    }
}
