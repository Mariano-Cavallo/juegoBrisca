package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;

public class Puntuaciones extends JFrame{
    private final VistaGrafica padre;
    private Controlador controlador;
    private JTable tablaRanking;


    public Puntuaciones(VistaGrafica padre,Controlador Controlador) {
        this.padre = padre;
        this.controlador = Controlador;


        // Configuración básica de la ventana
        setTitle("Puntos");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        tablaRanking = new JTable();
        tablaRanking.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(tablaRanking);

        JButton boton3 = new JButton("Salir");

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear un panel para los botones
        Dimension buttonSize = new Dimension(150, 50); // Tamaño preferido para los botones


        boton3.setPreferredSize(buttonSize);


        // Configurar el layout de la ventana
        setLayout(new BorderLayout());

        // Añadir el JScrollPane (con el JTextArea) en la parte superior
        add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel de botones en la parte inferior
        add(boton3, BorderLayout.SOUTH);



    }

    public void cargarDatos(Object[][] datosRanking) {
        String[] columnas = {"Nombre", "Puntaje"};
        DefaultTableModel modeloTabla = new DefaultTableModel(datosRanking, columnas);
        tablaRanking.setModel(modeloTabla);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
        tablaRanking.setRowSorter(sorter);
        sorter.setSortKeys(Arrays.asList(new SortKey(1, SortOrder.ASCENDING)));

    }



}
