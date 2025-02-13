package ar.edu.unlu.poo.juego.vistas.Consola;


import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Baza;
import ar.edu.unlu.poo.juego.modelos.Carta;
import ar.edu.unlu.poo.juego.modelos.Jugador;
import ar.edu.unlu.poo.juego.vistas.IVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

public class VistaConsolaGrafica extends JFrame implements IVista {
    private  Controlador controlador;
    private JTextArea txtSalida;
    private JPanel panelPrincipal;
    private JTextField txtEntrada;
    private JButton btnEnter;
    private EstadoVistaConsola estado;
    private String tituloLibro;
    private String autorLibro;
    private EstadoVistaConsola estadoAnt;

    public VistaConsolaGrafica(Controlador controlador)throws RemoteException {
        setTitle("Brisca Consola");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        this.controlador = controlador;
        txtSalida.setEditable(false);


        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarEntrada(txtEntrada.getText());
                txtEntrada.setText("");
            }
        });
        mostrarMenuPrincipal();
        txtEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarEntrada(txtEntrada.getText());
                txtEntrada.setText("");
            }
        });
    }

    private void print(String string) {
        txtSalida.append(string);
    }

    private void println(String string) {
        print(string + "\n");
    }

    private void procesarEntrada(String entrada) {
        switch (estado) {
            case MENU_PRINCIPAL:
                procesarEntradaMenuPrincipal(entrada);
                break;
            case AGREGANDO_JUGADOR:
                procesarAgregandoJugador(entrada);
                break;
            case ESPERANDO_JUGADOR:
                procesarEsperandoJugadores(entrada);
                break;
            case JUGANDO_TURNO:
                procesarJugandoTurno(entrada);
                break;
            case ESPERANDO_TURNO:
                procesarEsperandoTurno(entrada);
                break;
            case TABLA_DE_PUNTUACION:
                procesarTablaDePuntuacion(entrada);
                break;
            case PARTIDA_TERMINADA:
                procesarPartidaTerminada(entrada);
                break;

        }

    }


    private void procesarTablaDePuntuacion(String entrada) {
        switch (entrada){
            case "1":
                if(estadoAnt == EstadoVistaConsola.PARTIDA_TERMINADA){
                    terminarPartida();
                }else{
                    mostrarMenuPrincipal();
                }
        }

    }

    private void procesarPartidaTerminada(String entrada) {
        switch (entrada){
            case "1":
                volverAJugar();
                break;
            case "2":
                verPuntuaciones();
                break;
            case "3":
                controlador.cerrarJugador();
                break;
        }
    }

    private void volverAJugar(){
        controlador.reiniciarPartida();
    }

    public void terminarPartida() {
        estado = EstadoVistaConsola.PARTIDA_TERMINADA;
        limpiarPantalla();
        println("-------------|PARTIDA TERMINADA| -------------");
        println("Ganador/es de la partida : " + controlador.ganadorDePartida()) ;
        println("Con una puntuacion de  : " + controlador.puntuacionGanadora()) ;


        println("1. Volver a jugar");
        println("2. Ver Puntuacion");
        println("3. Salir");
    }


    private void procesarEsperandoTurno(String entrada) {
        mostraTablero();
        println("-Esperando Turno-");
    }

    // pasar de estado

    private void procesarJugandoTurno(String entrada) {
        println(entrada);
        switch (entrada){
            case "1": controlador.jugarCarta(1);
            mostraTablero();
            controlador.siguienteTurno();
            break;
            case "2": controlador.jugarCarta(2);
            mostraTablero();
            controlador.siguienteTurno();
            break;
            case "3": controlador.jugarCarta(3);
            mostraTablero();
            controlador.siguienteTurno();
            break;
        }

    }
    private void mostrarAgragandoJugador(){
        estado = EstadoVistaConsola.AGREGANDO_JUGADOR;
        println("Ingrese su nombre: ");

    }

    private void procesarAgregandoJugador(String entrada) {
        controlador.crearJugadorEnTablero(entrada);
        this.setTitle(controlador.getNombre());
        println("Jugador agregado");
        mostrarEsperandoJugadores();
        controlador.repartir3Jugador();
    }

    private void procesarEntradaMenuPrincipal(String entrada) {
        println(entrada);
        switch (entrada) {
            case "1":
                mostrarAgragandoJugador();
                controlador.setCartaTriunfo();
                break;
            case "2":verPuntuaciones();
                break;
            case "3":
                println("Gracias por jugar. ¡Hasta luego!");
                System.exit(0);
                break;
            default:
                println("Opción no válida. Por favor, elija una opción válida.");
        }
    }


    private void mostrarMenuPrincipal() {
        limpiarPantalla();
        estado = EstadoVistaConsola.MENU_PRINCIPAL;
        println("Menú Principal:");
        println("1. Jugar");
        println("2. Tabla de puntuacion");
        println("3. Salir");

        print("Seleccione una opción: ");
    }
    //ver si es privado o publico
    public void mostrarEsperandoJugadores() {
        estado = EstadoVistaConsola.ESPERANDO_JUGADOR;
        limpiarPantalla();
        println("Esperando a uno o mas jugadores");
        mostrarJugadores(controlador.obtenerJugadores());
        println("1. Empezar partida");
        println("2. Salir");

    }

    private void procesarEsperandoJugadores(String entrada){
        println(entrada);
        switch (entrada){
            //cambiar
            case "1":
                if(controlador.cantidadJugadores()<2 || controlador.cantidadJugadores()>4) {
                    println("Faltan Jugadores");
                }
                else{
                    controlador.empezarPartida();
                }
                break;
            case "2":
                System.exit(0);

        }


    }

    public void mostraTablero() {
        limpiarPantalla();
        println("-------------------------");
        println("Carta del triunfo:");
        println(controlador.getCartaTriunfo().toString());
        println("Cartas en la mano:");
        switch (controlador.cantidadCartasJugador()){
            case(1):
                println("1) "+ controlador.cartaJugador(1).toString());
                break;
            case(2):
                println("1) "+ controlador.cartaJugador(1).toString());
                println("2) "+ controlador.cartaJugador(2).toString());
                break;
            case(3):
                println("1) "+ controlador.cartaJugador(1).toString());
                println("2) "+ controlador.cartaJugador(2).toString());
                println("3) "+ controlador.cartaJugador(3).toString());
                break;
        }
        println("Baza:");
        mostrarBaza();
    }

    @Override
    public void reiniciarBaza() {
        mostraTablero();
    }

    @Override
    public void nuevaBaza() {
        println("Baza actual : \n");
    }

    @Override
    public void bazaGanadora() {
        println(controlador.bazaGanadora());
    }

    @Override
    public void verPuntuaciones() {
        limpiarPantalla();
        println("TABLA DE PUNTUACION");
        println("-------------------------------------");
        estadoAnt = estado;
        estado = EstadoVistaConsola.TABLA_DE_PUNTUACION;
        try{
            StringBuilder sb = new StringBuilder();
            Object[][] tabla = this.controlador.getTablaRanking();
            sb.append(String.format("%-15s %-5s%n", "Nombre", "Puntaje"));
            sb.append("-------------------------------------\n");
            for (Object[] fila : tabla){
                sb.append(String.format("%-15s ----- %-5s%n\n", fila[0], fila[1]));
            }
            println(sb.toString());
            println("1. Volver");
            txtSalida.setCaretPosition(0);


        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


    private void mostrarBaza(){
        if(controlador.cantidadCartasBaza()>0){
            for(int i=1;i <= controlador.cantidadCartasBaza();i++){
                println(controlador.cartaBaza(i).toString());
            }
        }
    }

    public void mostrarJugadores(List<Jugador> jugadores){
        println("Lista de jugadores:");
        for(Jugador j : jugadores){
            println("ID: "+ j.getId() + " Nombre: "+ j.getNombre());
        }
    }


    public void mostrarCarta(Carta carta){
        println(carta.toString());
    }



    public void limpiarPantalla(){
        txtSalida.setText("");
    }


    public void actualizarBaza(Carta carta) {
        txtSalida.append(carta.toString());
    }

    public void actualizarEstadoJugador(){
        if(controlador.esMiTurno()){
            estado = EstadoVistaConsola.JUGANDO_TURNO;
        }else {estado = EstadoVistaConsola.ESPERANDO_TURNO;}

    }


    public void actualizarvista() {
        mostraTablero();
    }

    public void actualizarAgregadoJugador() {
        if(estado == EstadoVistaConsola.ESPERANDO_JUGADOR){
            mostrarEsperandoJugadores();
        }
    }

    public void volverMenuPincipal() {
        mostrarMenuPrincipal();
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        println(mensaje);
    }

    @Override
    public void iniciar() {
        setVisible(true);

    }

    @Override
    public void cerrar() {
        System.exit(0);
    }


}
