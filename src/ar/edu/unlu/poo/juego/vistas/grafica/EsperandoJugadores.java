package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EsperandoJugadores extends JFrame{
    private final VistaGrafica padre;
    private JPanel panelPrincipal;
    private JButton empezarButton;
    private JTable tablaJugadores;
    private DefaultTableModel modeloTabla;
    private Controlador controlador;




    public EsperandoJugadores(VistaGrafica padre,Controlador controlador){
        setResizable(false);
        setTitle("Esperando jugadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        setSize(260, 280);
        this.padre = padre;
        this.controlador = padre.getControlador();
        this.padre.estadoDeVentanaEsperaJugadore(true);
        modeloTabla = new DefaultTableModel();
        tablaJugadores.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("NOMBRE");
        mostrarJugadores(controlador.obtenerJugadores());



        empezarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.estadoDeVentanaEsperaJugadore(false);
                padre.comenzarPartida();
                // funcion empezar partida

            }
        });
    }
    public void mostrarJugadores(List<Jugador> jugadores){
        modeloTabla.setRowCount(0);
        for(Jugador j: jugadores){
            modeloTabla.addRow(new Object[]{
                    j.getNombre(),
                    j.getId()
            });
        }
    }
    public void actualizarEspera(){
        mostrarJugadores(controlador.obtenerJugadores());
    }




}
