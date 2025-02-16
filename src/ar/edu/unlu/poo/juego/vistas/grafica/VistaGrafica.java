package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.Mensaje.Mensaje;
import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Carta;
import ar.edu.unlu.poo.juego.vistas.IVista;

import java.rmi.RemoteException;

public class VistaGrafica implements IVista {

    private Controlador controlador;
    private EsperandoJugadores ventanaEspera;
    private Tablero tablero;
    private Ganador ganador;
    private MenuPrincipal menuPrincipal;
    private Puntuaciones puntuaciones;
    private boolean estadoVentanaAgregadoJugador = false;


    public VistaGrafica(Controlador controlador){
        this.controlador = controlador;
    }

    public void agregarVentanaDeEspera(){
        ventanaEspera = new EsperandoJugadores(this,controlador);
        ventanaEspera.setVisible(true);
    }


    public void comenzarPartida(){
        if(controlador.cantidadJugadores()>1) {
            //sel set este ac o cuando pongo el mazo en el tablero
            controlador.empezarPartida();
        }else{
            mostrarMensaje("Se necesitan al menos 2 jugadores");
        }
    }

    private void mostrarMenuPrincipal() {
        menuPrincipal = new MenuPrincipal(this);
        menuPrincipal.setVisible(true);
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        if(tablero == null){
            new Mensaje(mensaje);
        }else{
            tablero.println(mensaje);
        }
    }

    @Override
    public void iniciar() {
        mostrarMenuPrincipal();
    }

    @Override
    public void cerrar() {
        controlador.cerrar();

    }

    @Override
    public void actualizarAgregadoJugador() {
        if(estadoVentanaAgregadoJugador){
            ventanaEspera.actualizarEspera();
        }
    }

    @Override
    public void actualizarBaza(Carta ultimaCartaJugada) {
        tablero.actualizarBaza(ultimaCartaJugada);

    }

    @Override
    public void actualizarEstadoJugador() {
        if(controlador.esMiTurno()){
            tablero.activarBotones();
            tablero.println("Es su turno");
        }else {
            tablero.desactivarBotones();
            tablero.println("Esperando turno");
        }

    }

    @Override
    public void actualizarvista() {
        tablero.actualizarMano();
        tablero.borrarBaza();
    }

    @Override
    public void terminarPartida() {
        ganador = new Ganador(this,controlador);
        ganador.setVisible(true);

    }

    @Override
    public void volverMenuPincipal() {
        menuPrincipal.setVisible(true);
        ganador.setVisible(false);
        tablero.setVisible(false);
    }

    @Override
    public void mostraTablero() {
        //o poner invicible
        ventanaEspera.setVisible(false);
        tablero = new Tablero(controlador,this);
        menuPrincipal.setVisible(false);
        tablero.setVisible(true);
        tablero.iniciarNombre(controlador.getNombre());
        tablero.iniciarIconos();
        tablero.println("Que disfrunten el juego! ");


    }

    @Override
    public void reiniciarBaza() {
        tablero.borrarBaza();
    }

    @Override
    public void nuevaBaza() {

    }

    @Override
    public void bazaGanadora() {
    }

    @Override
    public void verPuntuaciones() {
        var ventanaPuntuacion = new Puntuaciones(this,controlador);
        ventanaPuntuacion.setVisible(true);
    }

    public void estadoDeVentanaEsperaJugadore(boolean estado) {
        this.estadoVentanaAgregadoJugador = estado;

    }
    public void agregarJugador(String nombre){
        controlador.crearJugadorEnTablero(nombre);
        controlador.repartir3Jugador();

    }

    public void mostrarTablaPuntuaciones() {
        try {
            puntuaciones = new Puntuaciones(this,controlador);
            puntuaciones.cargarDatos(this.controlador.getTablaRanking());
            puntuaciones.setVisible(true);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public Controlador getControlador(){
        return this.controlador;
    }




}
