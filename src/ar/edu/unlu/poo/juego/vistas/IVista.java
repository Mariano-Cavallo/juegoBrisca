package ar.edu.unlu.poo.juego.vistas;

import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Carta;

import java.util.List;

public interface IVista {

    void setControlador(Controlador controlador);

    void mostrarMensaje(String mensaje);


    void iniciar();

    void cerrar();

    void actualizarAgregadoJugador();

    void actualizarBaza(Carta ultimaCartaJugada);

    void actualizarEstadoJugador();

    void actualizarvista();

    void terminarPartida();

    void volverMenuPincipal();

    void mostraTablero();
}
