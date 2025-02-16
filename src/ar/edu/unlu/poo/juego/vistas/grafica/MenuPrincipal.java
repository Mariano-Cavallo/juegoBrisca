package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.Mensaje.Mensaje;
import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Carta;

import ar.edu.unlu.poo.juego.vistas.IVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;

public class MenuPrincipal extends JFrame{
    private JPanel panelPrincipal;
    private JButton jugarButton;
    private JButton tablaDePuntuacionButton;
    private JButton salirButton;
    private JButton comoJugar;
    private Controlador controlador;
    private VistaGrafica padre;





    public MenuPrincipal(VistaGrafica padre){
        //hacer el menu principal aparte o dejarlo asi
        this.padre = padre;
        this.controlador = controlador;
        setResizable(false);
        setTitle("Brisca!!!");
        setSize(500, 440);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        panelPrincipal.setBackground(new Color(52, 73, 94));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controlador.cerrar();
            }
        });
        


        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onJugar();
            }
        });
        tablaDePuntuacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPuntuacion();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSalir();
            }
        });
        comoJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onComoJugar();
            }
        });
    }

    private void onComoJugar() {
        var comoJugar = new ComoJugar();

    }

    //cerrar juego no se porque no funciona con system.exit(0);
    private void onSalir() {
        padre.cerrar();
    }

    private void onPuntuacion() {
        padre.mostrarTablaPuntuaciones();
    }

    private void onJugar() {
        var crearJugador = new CrearJugador(padre,controlador);
        crearJugador.setVisible(true);
        padre.actualizarAgregadoJugador();

    }


}



