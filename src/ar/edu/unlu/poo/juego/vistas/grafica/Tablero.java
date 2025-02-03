package ar.edu.unlu.poo.juego.vistas.grafica;

import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.Carta;
import ar.edu.unlu.poo.juego.vistas.grafica.utilidades.MapeoCartas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tablero extends JFrame {
    private JPanel panelPrincipal;
    private JButton botonCarta1;
    private JButton botonCarta2;
    private JButton botonCarta3;
    private JTextArea txtTablero;
    private JLabel mazo;
    private JLabel cartaTriunfo;
    private JLabel baza1;
    private JLabel baza2;
    private JLabel baza3;
    private JLabel baza4;
    private JLabel gif;
    private Controlador controlador;
    private final VistaGrafica padre;
    private MapeoCartas mapeo;
    private ArrayList<JButton> botones = new ArrayList<>();
    private ArrayList<JLabel> labels = new ArrayList<>();
    private int siguienteLabel = 0;


    public Tablero(Controlador controlador,VistaGrafica padre){
        setResizable(false);
        this.padre = padre;
        this.controlador = controlador;
        botones.add(botonCarta1);
        botones.add(botonCarta2);
        botones.add(botonCarta3);
        labels.add(baza1);
        labels.add(baza2);
        labels.add(baza3);
        labels.add(baza4);
        setTitle("Tablero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        mapeo = new MapeoCartas();
        actualizarMano();
        txtTablero.setEditable(false);

        botonCarta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.jugarCarta(1);
                controlador.siguienteTurno();

            }
        });
        botonCarta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.jugarCarta(2);
                controlador.siguienteTurno();
            }
        });
        botonCarta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.jugarCarta(3);
                controlador.siguienteTurno();

            }
        });
    }


    public void iniciarCartaTriunfo(){

        //mazo y carta del triunfo
        ImageIcon carta = new ImageIcon("src/ImagenesCartas/reverso.png");
        Image cartaescalada = carta.getImage().getScaledInstance(85,150,0);
        mazo.setIcon(new ImageIcon(cartaescalada));

        carta = (mapeo.getImagen(controlador.getCartaTriunfo().getNombre()));
        cartaescalada = carta.getImage().getScaledInstance(85,150,0);
        cartaTriunfo.setIcon(new ImageIcon(cartaescalada));

        //sacar
        carta = new ImageIcon("src/ImagenesCartas/balatro-mult.gif");
        cartaescalada = carta.getImage().getScaledInstance(150,150,0);
        gif.setIcon(new ImageIcon(cartaescalada));

    }

    public void desactivarBotones(){
        botonCarta1.setEnabled(false);
        botonCarta2.setEnabled(false);
        botonCarta3.setEnabled(false);
    }
    public void activarBotones(){
        switch (controlador.cantidadCartasJugador()){
            case(1):
                botonCarta1.setEnabled(true);
                botonCarta2.setEnabled(false);
                botonCarta3.setEnabled(false);
            break;
            case(2):
                botonCarta1.setEnabled(true);
                botonCarta2.setEnabled(true);
                botonCarta3.setEnabled(false);
            break;
            case(3):
                botonCarta1.setEnabled(true);
                botonCarta2.setEnabled(true);
                botonCarta3.setEnabled(true);
            break;
        }

    }



    //podria hacer otro loop
    public void actualizarMano(){
        switch (controlador.cantidadCartasJugador()){
            case(3):
                for(int i = 1;i<=3;i++){
                    ImageIcon carta = (mapeo.getImagen(controlador.cartaJugador(i).getNombre()));
                    Image cartaescalada = carta.getImage().getScaledInstance(85,150,0);
                    //dudoso
                    botones.get(i-1).setIcon(new ImageIcon(cartaescalada));
                }
                break;
            case(2):
                for(int i = 1;i<=2;i++){
                    ImageIcon carta = (mapeo.getImagen(controlador.cartaJugador(i).getNombre()));
                    Image cartaescalada = carta.getImage().getScaledInstance(85,150,0);
                    //dudoso
                    botones.get(i-1).setIcon(new ImageIcon(cartaescalada));
                }
                botones.get(2).setIcon(null);
                break;
            case(1):
                ImageIcon carta = (mapeo.getImagen(controlador.cartaJugador(1).getNombre()));
                Image cartaescalada = carta.getImage().getScaledInstance(85,150,0);
                //dudoso
                botones.get(0).setIcon(new ImageIcon(cartaescalada));
                botones.get(1).setIcon(null);
                botones.get(2).setIcon(null);
                break;
        }
    }

    public void limpiarPantalla(){
        txtTablero.setText("");
    }

    public void print(String string) {
        txtTablero.append(string);
    }

    public void println(String string) {
        print(string + "\n");
    }

    public void actualizarBaza(Carta ultimaCartaJugada) {
        ImageIcon carta = (mapeo.getImagen(ultimaCartaJugada.getNombre()));
        Image cartaescalada = carta.getImage().getScaledInstance(85,150,0);
        labels.get(siguienteLabel).setIcon(new ImageIcon(cartaescalada));
        siguienteLabel++;
        borrarSiguientesBaza();
    }

    private void borrarSiguientesBaza() {
        for (int i = siguienteLabel; i <= 3 ;i++){
            labels.get(i).setIcon(null);
        }

    }

    public void borrarBaza() {
        siguienteLabel = 0;
    }
}
