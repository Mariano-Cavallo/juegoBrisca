package ar.edu.unlu.poo.juego.vistas;

import ar.edu.unlu.poo.juego.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearJugador extends JFrame{
    private final VistaGrafica padre;
    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JButton aceptarButton;



    public CrearJugador(VistaGrafica padre, Controlador controlador){
        setTitle("Nuevo Jugador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        setSize(180, 130);


        this.padre = padre;

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.agregarJugador(txtNombre.getText());
                var ventanaEsperaJugadores = new EsperandoJugadores(padre,controlador);
                ventanaEsperaJugadores.setVisible(true);
                dispose();
            }
        });
    }
}
