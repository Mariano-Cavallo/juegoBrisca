package ar.edu.unlu.poo.juego.ClienteYServidor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.vistas.Consola.VistaConsolaGrafica;
import ar.edu.unlu.poo.juego.vistas.IVista;
import ar.edu.unlu.poo.juego.vistas.grafica.VistaGrafica;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.Util;
import ar.edu.unlu.rmimvc.cliente.Cliente;

public class AppCliente {

    public static void main(String[] args) throws RemoteException {
        ArrayList<String> ips = Util.getIpDisponibles();
        /*
        String ip = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la IP en la que escuchará peticiones el cliente", "IP del cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ips.toArray(),
                null
        );

         */
        String port = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el puerto en el que escuchará peticiones el cliente", "Puerto del cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                9999
        );
        /*
        String ipServidor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la IP en la corre el servidor", "IP del servidor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );
        String portServidor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el puerto en el que corre el servidor", "Puerto del servidor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                8888
        );

         */

        Controlador controlador = new Controlador();
        IVista vista;

        String[] opciones = {"Vista Consola ", "Vista grafica "};
        int seleccion = JOptionPane.showOptionDialog(null, "Elige una vista :", "Vistas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if(Objects.equals(opciones[seleccion], "Vista grafica ")){
            vista = new VistaGrafica(controlador);
        }else{
            vista = new VistaConsolaGrafica(controlador);
        }

        controlador.setVista(vista);
        //Cliente c = new Cliente(ip, Integer.parseInt(port), ipServidor, Integer.parseInt(portServidor));
        Cliente c = new Cliente("127.0.0.1", Integer.parseInt(port), "127.0.0.1", 8888);
        vista.iniciar();
        try {
            c.iniciar(controlador);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (RMIMVCException e) {
            e.printStackTrace();
        }
    }

}