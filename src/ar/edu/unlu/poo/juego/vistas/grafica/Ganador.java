package ar.edu.unlu.poo.juego.vistas.grafica;
import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ganador extends JFrame {
    private final VistaGrafica padre;
    private Controlador controlador;

    public Ganador(VistaGrafica padre,Controlador controlador) {
        this.padre = padre;
        this.controlador = controlador;

        setResizable(false);
        // Configuración básica de la ventana
        setTitle("Fin de la partida");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        // Crear un JScrollPane para el JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Crear los botones
        JButton boton1 = new JButton("Volver a jugar");
        JButton boton2 = new JButton("Ver puntuaciones");
        JButton boton3 = new JButton("Salir");

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.reiniciarPartida();

            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.cerrarJugador();

            }
        });
        // Crear un panel para los botones
        Dimension buttonSize = new Dimension(150, 50); // Tamaño preferido para los botones
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);
        boton3.setPreferredSize(buttonSize);

        // Crear un panel para los botones con GridLayout
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10)); // 3 filas, 1 columna, con espacio entre botones
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);

        // Configurar el layout de la ventana
        setLayout(new BorderLayout());

        // Añadir el JScrollPane (con el JTextArea) en la parte superior
        add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel de botones en la parte inferior
        add(panelBotones, BorderLayout.SOUTH);
    }


}