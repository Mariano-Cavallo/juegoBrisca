package ar.edu.unlu.poo.juego.vistas.grafica;
import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ganador extends JFrame {
    private final VistaGrafica padre;
    private Controlador controlador;

    public Ganador(VistaGrafica padre, Controlador Controlador) {
        this.padre = padre;
        this.controlador = Controlador;

        setResizable(false);
        // Configuración básica de la ventana
        setTitle("Fin de la partida");
        setSize(430, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        toFront();
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
        var fuente = new Font("jetbrains monospace", 1,20);
        textArea.setFont(fuente);

        textArea.append("-------------|PARTIDA TERMINADA| -------------\n" +
        "Ganador/es de la partida : " + controlador.ganadorDePartida() +"\n" +
        "Con una puntuacion de  : " + controlador.puntuacionGanadora());


        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.reiniciarPartida();

            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.mostrarTablaPuntuaciones();
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.cerrar();
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