package ar.edu.unlu.poo.juego.vistas;

import ar.edu.unlu.poo.juego.Mensaje.Mensaje;
import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGrafica extends JFrame{
    private JPanel panelPrincipal;
    private JButton jugarButton;
    private JButton tablaDePuntuacionButton;
    private JButton salirButton;
    private Controlador controlador;



    public VistaGrafica(Controlador controlador){
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
        var tablero = new TableroDeCartas(this,controlador);



    }
    public void mostrarMensaje(String mensaje) {
        var ventanaMensaje = new Mensaje(mensaje);
        ventanaMensaje.setVisible(true);
    }

    public void agregarJugador(String nombre){
        controlador.crearJugadorEnTablero(nombre);

    }

}



