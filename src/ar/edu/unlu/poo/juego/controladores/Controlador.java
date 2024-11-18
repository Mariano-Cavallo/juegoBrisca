package ar.edu.unlu.poo.juego.controladores;

import ar.edu.unlu.poo.juego.modelos.Jugador;
import ar.edu.unlu.poo.juego.modelos.Tablero;
import ar.edu.unlu.poo.juego.vistas.VistaGrafica;

import java.util.ArrayList;

public class Controlador {
    private Tablero modeloTablero;
    //inteface
    private VistaGrafica vista;


    public Controlador(Tablero modeloTablero){
        this.modeloTablero = modeloTablero;
    }

    public void setVista(VistaGrafica vista) {
        this.vista = vista;
    }

    // Cambiar nombre
    public void crearJugadorEnTablero(String nombre){
        var jugador = new Jugador(nombre);
        modeloTablero.agregarJugador(jugador);

    }

    public Jugador jugadorTurnoActual(){
        return modeloTablero.getJugador(modeloTablero.getTurnoActual());
    }

    public int cantidadJugadores(){
        return modeloTablero.cantidadJugadores();
    }






}
