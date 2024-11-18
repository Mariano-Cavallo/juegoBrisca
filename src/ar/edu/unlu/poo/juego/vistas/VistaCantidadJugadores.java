package ar.edu.unlu.poo.juego.vistas;

import javax.swing.*;

public class VistaCantidadJugadores extends JFrame {
    private JPanel panelPrincipal;
    private JButton a3JugadoresButton;
    private JButton a2JugadoresButton;
    private JButton a4JugadoresButton;
    private final VistaGrafica padre;


    public VistaCantidadJugadores(VistaGrafica padre) {
        setTitle("Nuevo Jugador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        setSize(180, 130);
        this.padre = padre;
        pack();


    }
}