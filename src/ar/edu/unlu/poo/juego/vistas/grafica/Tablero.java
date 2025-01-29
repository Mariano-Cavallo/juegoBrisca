package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JFrame {
    private JPanel panelPrincipal;
    private JButton botonCarta1;
    private JButton botonCarta2;
    private JButton botonCarta3;
    private JTextArea txtTablero;
    private Controlador controlador;
    private final VistaGrafica padre;


    public Tablero(Controlador controlador,VistaGrafica padre){
        this.padre = padre;
        this.controlador = controlador;
        setTitle("Tablero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);

        botonCarta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.jugarCarta(1);
                controlador.siguienteTurno();
            }
        });
        botonCarta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.jugarCarta(2);
                controlador.siguienteTurno();
            }
        });
        botonCarta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.jugarCarta(3);
                controlador.siguienteTurno();
            }
        });
    }

    public void desactivarBotones(){
        botonCarta1.setEnabled(false);
        botonCarta2.setEnabled(false);
        botonCarta3.setEnabled(false);
    }
    public void activarBotones(){
        switch (controlador.cantidadCartasJugador()){
            case(1):
                botonCarta1.setEnabled(true);
                botonCarta2.setEnabled(false);
                botonCarta3.setEnabled(false);
            break;
            case(2):
                botonCarta1.setEnabled(true);
                botonCarta2.setEnabled(true);
                botonCarta3.setEnabled(false);
            break;
            case(3):
                botonCarta1.setEnabled(true);
                botonCarta2.setEnabled(true);
                botonCarta3.setEnabled(true);
            break;
        }

    }

    public void limpiarPantalla(){
        txtTablero.setText("");
    }

    public void print(String string) {
        txtTablero.append(string);
    }

    public void println(String string) {
        print(string + "\n");
    }

}
