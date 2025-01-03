package ar.edu.unlu.poo.juego.vistas;

import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;
import java.awt.*;

public class TableroDeCartas extends JFrame{
    private final VistaGrafica padre;
    private Controlador controlador;


    public TableroDeCartas(VistaGrafica padre, Controlador controlador){
        // Crear el marco principal
        JFrame frame = new JFrame("Tablero de Cartas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Tamaño de la ventana
        frame.setLayout(new BorderLayout());// Diseño principal

        this.padre = padre;

        // Panel central para el mazo y la carta suelta
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelCentral.setBackground(new Color(71, 125, 71)); // Fondo verde (estilo mesa)

        // Mazo de cartas (simulación con una etiqueta)
        JLabel mazoLabel = new JLabel("Mazo");
        mazoLabel.setPreferredSize(new Dimension(100, 150));
        mazoLabel.setOpaque(true);
        mazoLabel.setBackground(Color.LIGHT_GRAY);
        mazoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mazoLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Carta suelta (otra etiqueta)
        JLabel cartaSueltaLabel = new JLabel("Carta Suelta");
        cartaSueltaLabel.setPreferredSize(new Dimension(100, 150));
        cartaSueltaLabel.setOpaque(true);
        cartaSueltaLabel.setBackground(Color.WHITE);
        cartaSueltaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cartaSueltaLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Agregar el mazo y la carta al panel central
        panelCentral.add(mazoLabel);
        panelCentral.add(cartaSueltaLabel);

        // Panel superior con cuatro etiquetas
        JPanel panelSuperior = new JPanel(new GridLayout(1, 4, 10, 10));
        for (int i = 1; i <= 4; i++) {
            JLabel etiquetaSuperior = new JLabel("Superior " + i, SwingConstants.CENTER);
            etiquetaSuperior.setOpaque(true);
            etiquetaSuperior.setBackground(Color.CYAN);
            etiquetaSuperior.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelSuperior.add(etiquetaSuperior);
        }

        // Panel inferior con cuatro etiquetas debajo del mazo
        JPanel panelInferiorEtiquetas = new JPanel(new GridLayout(1, 4, 10, 10));
        for (int i = 1; i <= 4; i++) {
            JLabel etiquetaInferior = new JLabel("Inferior " + i, SwingConstants.CENTER);
            etiquetaInferior.setOpaque(true);
            etiquetaInferior.setBackground(Color.YELLOW);
            etiquetaInferior.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelInferiorEtiquetas.add(etiquetaInferior);
        }

        // Panel izquierdo con cuatro etiquetas
        JPanel panelIzquierdo = new JPanel(new GridLayout(4, 1, 10, 10));
        for (int i = 1; i <= 4; i++) {
            JLabel etiquetaIzquierda = new JLabel("Izquierdo " + i, SwingConstants.CENTER);
            etiquetaIzquierda.setOpaque(true);
            etiquetaIzquierda.setBackground(Color.green);
            etiquetaIzquierda.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelIzquierdo.add(etiquetaIzquierda);
        }

        // Panel derecho con cuatro etiquetas
        JPanel panelDerecho = new JPanel(new GridLayout(4, 1, 10, 10));
        for (int i = 1; i <= 4; i++) {
            JLabel etiquetaDerecha = new JLabel("Derecho " + i, SwingConstants.CENTER);
            etiquetaDerecha.setOpaque(true);
            etiquetaDerecha.setBackground(Color.PINK);
            etiquetaDerecha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelDerecho.add(etiquetaDerecha);
        }

        // Panel inferior para los botones
        JPanel panelInferiorBotones = new JPanel();
        panelInferiorBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferiorBotones.setBackground(Color.DARK_GRAY);

        // Botones en la parte inferior
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");

        // Agregar botones al panel inferior
        panelInferiorBotones.add(boton1);
        panelInferiorBotones.add(boton2);
        panelInferiorBotones.add(boton3);

        // Agregar paneles al marco principal
        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(panelInferiorEtiquetas, BorderLayout.SOUTH);
        frame.add(panelIzquierdo, BorderLayout.WEST);
        frame.add(panelDerecho, BorderLayout.EAST);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(panelInferiorBotones, BorderLayout.PAGE_END);

        // Hacer visible el marco
        frame.setVisible(true);
    }

}
