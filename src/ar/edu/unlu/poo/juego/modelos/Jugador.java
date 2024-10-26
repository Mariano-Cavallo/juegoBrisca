package ar.edu.unlu.poo.juego.modelos;

public class Jugador {
    private String nombre;
    private ConjuntoDeCartas mano;
    private int puntuacion;
    private ConjuntoDeCartas cartasGanadas;


    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new ConjuntoDeCartas();
        this.puntuacion = 0;
        this.cartasGanadas = new ConjuntoDeCartas();
    }


    public Carta jugarCarta(Carta carta){
        return mano.jugar(carta);
    }

    //dudoso
    public void agregarCartasGanadas(ConjuntoDeCartas CartasGanada){
        this.cartasGanadas.agregarCartas(cartasGanadas);
    }




}
