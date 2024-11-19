package ar.edu.unlu.poo.juego.vistas;

import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EsperandoJugadores extends JFrame{
    private final VistaGrafica padre;
    private JPanel panelPrincipal;
    private JButton empezarButton;
    private JTable tablaJugadores;
    private DefaultTableModel modeloTabla;
    private Controlador controlador;




    public EsperandoJugadores(VistaGrafica padre,Controlador controlador){
        setTitle("Esperando jugadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        setSize(200, 180);
        this.padre = padre;

        modeloTabla = new DefaultTableModel();
        tablaJugadores.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("NOMBRE");
        mostrarJugadores(controlador.obtenerJugadores());


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




}
