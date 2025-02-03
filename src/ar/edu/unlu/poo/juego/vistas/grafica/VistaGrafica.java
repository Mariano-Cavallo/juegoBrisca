package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.Mensaje.Mensaje;
import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Carta;

import ar.edu.unlu.poo.juego.vistas.IVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGrafica extends JFrame implements IVista {
    private JPanel panelPrincipal;
    private JButton jugarButton;
    private JButton tablaDePuntuacionButton;
    private JButton salirButton;
    private JButton comoJugar;
    private Controlador controlador;
    private EsperandoJugadores ventanaEspera;
    private boolean estadoVentanaAgregadoJugador = false;
    private EstadoVistaGrafica estado;
    private Tablero tablero;
    private Ganador ganador;





    public VistaGrafica(Controlador controlador){
        //hacer el menu principal aparte o dejarlo asi
        setResizable(false);
        setTitle("Brisca!!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 440);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        this.controlador = controlador;
        panelPrincipal.setBackground(new Color(52, 73, 94));

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onJugar();
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
        comoJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onComoJugar();
            }
        });
    }

    private void onComoJugar() {
        var comoJugar = new ComoJugar();

    }

    //cerrar juego capaz
    private void onSalir() {
        //probar
        System.exit(0);
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
        if(tablero == null){
            new Mensaje(mensaje);
        }else{
            tablero.println(mensaje);
        }
    }

    @Override
    public void iniciar() {
        setVisible(true);
    }

    @Override
    public void cerrar() {
        tablero.dispose();
        ganador.dispose();
        System.exit(0);
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


    //hacer print en el log del tablero
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
        //y reiniciar baza
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
        ventanaEspera.setVisible(false);
        ganador.setVisible(false);
        tablero.setVisible(false);
        this.setVisible(true);

    }

    @Override
    public void mostraTablero() {
        //o poner invicible
        ventanaEspera.setVisible(false);
        tablero = new Tablero(controlador,this);
        this.setVisible(false);
        tablero.setVisible(true);
        tablero.iniciarCartaTriunfo();
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

    public void comenzarPartida(){
        if(controlador.cantidadJugadores()>1) {
            //sel set este ac o cuando pongo el mazo en el tablero
            controlador.setCartaTriunfo();
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



