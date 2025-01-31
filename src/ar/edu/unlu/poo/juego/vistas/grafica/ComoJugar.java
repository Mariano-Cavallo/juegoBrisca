package ar.edu.unlu.poo.juego.vistas.grafica;

import javax.swing.*;
import java.awt.*;

public class ComoJugar extends JFrame {
    private JPanel panelPrincipal;
    private JTextArea txt;

    public ComoJugar(){
        setSize(720, 1000);
        setContentPane(panelPrincipal);
        setTitle("Como jugar ?");
        setLocationRelativeTo(null);
        setVisible(true);
        txt.setEditable(false);
        txt.append("REGLAS DE LA BRISCA\n" +
                "---------------------------\n"+
                "Objetivo del Juego\n" +
                "---------------------------\n"+

                "El objetivo es ganar bazas (rondas) para acumular puntos. Gana el jugador\n" +
                "o equipo que termine con mas puntos.\n" +
                "\n" +
                "-------------------------------\n"+
                "Preparación del Juego\n" +
                "-------------------------------\n"+

                "REPARTIR LAS CARTAS:\n" +

                "\n" +
                "Se reparten 3 cartas a cada jugador.\n" +
                "\n" +
                "Las cartas restantes se colocan en un mazo en el centro,\n" +
                " y se voltea la primera carta para determinar el palo de triunfo.\n" +
                "\n" +
                "PALO DE TRIUNFO:\n" +
                "\n" +
                "El palo de la primera carta se voltea y se convierte en el triunfo.\n" +
                "\n" +
                "Las cartas de este palo ganan sobre las cartas de otros palos.\n" +
                "\n" +
                "-----------------------------\n"+
                "Desarrollo del Juego\n" +
                "-----------------------------\n"+

                "El jugador que reparte las cartas comienza el juego.\n" +
                "\n" +
                "En cada turno, un jugador juega una carta de su mano.\n" +
                "\n" +
                "---------------------------\n"+
                "Ganar una Baza\n" +
                "---------------------------\n"+

                "\n" +
                "Si se juega una carta del palo de triunfo, gana la carta más alta de ese palo.\n" +

                "\n" +
                "Si no se juega ningun palo de triunfo el jugador que juega la carta más alta del palo de salida\n" +
                "(el palo de la primera carta jugada en la baza) gana la baza.\n" +

                "------------------------\n"+
                "Recoger Cartas\n" +
                "------------------------\n"+

                "\n" +
                "El jugador que gana la baza recoge las cartas y las coloca en su montón de bazas ganadas.\n" +
                "\n" +
                "Luego, se reponen las cartas jugadas con nuevas cartas del mazo (si quedan cartas).\n" +
                "\n" +
                "----------------------\n"+
                "Fin del Juego\n" +
                "----------------------\n"+

                "El juego termina cuando no quedan cartas en el mazo\n" +
                " y los jugadores han jugado todas las cartas de su mano.\n" +
                "\n" +
                "Se suman los puntos de las cartas obtenidas en las bazas ganadas.\n" +
                "\n" +
                "Gana el jugador o equipo que tenga mas puntaje\n" +
                "\n"+
                "---------------------------\n"+
                "Valor de las Cartas\n" +
                "---------------------------\n"+

                "Cada carta tiene un valor en puntos, que se utiliza para calcular" +
                " el puntaje al final de la partida:\n" +
                "\n" +
                "As: 11 puntos.\n" +
                "\n" +
                "Tres: 10 puntos.\n" +
                "\n" +
                "Rey: 4 puntos.\n" +
                "\n" +
                "Caballo: 3 puntos.\n" +
                "\n" +
                "Sota: 2 puntos.\n" +
                "\n" +
                "Siete, Seis, Cinco, Cuatro y Dos: 0 puntos.\n" +
                "\n");

        txt.setCaretPosition(0);
    }









}
