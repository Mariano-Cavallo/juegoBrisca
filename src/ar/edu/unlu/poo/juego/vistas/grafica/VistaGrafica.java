package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.Mensaje.Mensaje;
import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Carta;
import ar.edu.unlu.poo.juego.vistas.Consola.EstadoVistaConsola;
import ar.edu.unlu.poo.juego.vistas.IVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGrafica extends JFrame implements IVista {
    private JPanel panelPrincipal;
    private JButton jugarButton;
    private JButton tablaDePuntuacionButton;
    private JButton salirButton;
    private Controlador controlador;
    private EsperandoJugadores ventanaEspera;
    private boolean estadoVentanaAgregadoJugador = false;
    private EstadoVistaGrafica estado;
    private Tablero tablero;





    public VistaGrafica(Controlador controlador){
        //hacer el menu principal aparte o dejarlo asi
        setTitle("Brisca!!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 440);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        this.controlador = controlador;
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onJugar();
                //probar
                jugarButton.setEnabled(false);

            }
        });
        tablaDePuntuacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPuntuacion();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSalir();
            }
        });
    }

    private void onSalir() {
        dispose();
    }

    private void onPuntuacion() {
        mostrarMensaje("Apretaste Puntuacion ");

    }

    private void onJugar() {
        var crearJugador = new CrearJugador(this,controlador);
        crearJugador.setVisible(true);
        actualizarAgregadoJugador();

    }

    public void agregarVentanaDeEspera(){
        ventanaEspera = new EsperandoJugadores(this,controlador);
        ventanaEspera.setVisible(true);
    }

    public void estadoDeVentanaEsperaJugadore(boolean estado){
        this.estadoVentanaAgregadoJugador = estado;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMensaje(String mensaje) {
        tablero.println(mensaje);
    }

    @Override
    public void iniciar() {
        setVisible(true);
    }

    @Override
    public void cerrar() {
        setVisible(false);
    }

    @Override
    public void actualizarAgregadoJugador() {
        if(estadoVentanaAgregadoJugador){
            ventanaEspera.actualizarEspera();
        }
    }

    @Override
    public void actualizarBaza(Carta ultimaCartaJugada) {

    }


    //hacer print en el log del tablero
    @Override
    public void actualizarEstadoJugador() {
        if(controlador.esMiTurno()){
            estado = EstadoVistaGrafica.JUGANDO_TURNO;
            tablero.activarBotones();
            tablero.println("Es su turno");
        }else {
            estado = EstadoVistaGrafica.ESPERANDO_TURNO;
            tablero.desactivarBotones();
            tablero.println("Esperando turno");
        }
    }


    @Override
    public void actualizarvista() {

    }

    @Override
    public void terminarPartida() {

    }

    @Override
    public void volverMenuPincipal() {

    }

    @Override
    public void mostraTablero() {
        //o poner invicible
        ventanaEspera.dispose();
        tablero = new Tablero(controlador,this);
        tablero.setVisible(true);
        tablero.println("Que disfrunten el juego! ");
    }

    public void comenzarPartida(){
        //cambiar el >=
        if(controlador.cantidadJugadores()>0) {
            controlador.empezarPartida();
        }else{
            mostrarMensaje("Se necesitan por al menos 2 jugadores");
        }
    }

    public void agregarJugador(String nombre){
        controlador.crearJugadorEnTablero(nombre);
        controlador.repartir3Jugador();

    }

    public Controlador getControlador(){
        return this.controlador;
    }

}



