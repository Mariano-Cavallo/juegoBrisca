package serializador;

import ar.edu.unlu.poo.juego.modelos.Jugador;

import java.io.*;
import java.util.ArrayList;




public class AdministradorPuntuacion {

    private final String archivo = "Datos.dat";


    public void guardarRanking(ArrayList<Jugador> jugadores) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(this.archivo))) {
            salida.writeObject(jugadores);
            System.out.println("Jugadores guardados");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar los jugadores");
        }
    }

    public ArrayList<Jugador> cargarRanking() {
        ArrayList<Jugador> jugadores = null;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(this.archivo))) {
            jugadores = (ArrayList<Jugador>) entrada.readObject();
            System.out.println("Jugadores cargados exitosamente");
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe, se devolvera una lista vacia");
            jugadores = new ArrayList<Jugador>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error al cargar los jugadores");
        }
        return jugadores;
    }



}
