package ar.edu.unlu.poo.juego.modelos;

public class Jugador {
    private static int  id = -1;
    private String nombre;
    private ConjuntoDeCartas mano;
    private int puntuacion;
    private ConjuntoDeCartas cartasGanadas;


    public Jugador(String nombre){
        this.id ++;
        this.nombre = nombre;
        this.mano = new ConjuntoDeCartas();
        this.puntuacion = 0;
        this.cartasGanadas = new ConjuntoDeCartas();
    }


    public Carta jugarCarta(int PosDeCarta){
        return mano.jugar(PosDeCarta);
    }

    //dudoso
    public void agregarCartasGanadas(ConjuntoDeCartas CartasGanada){
        this.cartasGanadas.agregarCartas(cartasGanadas);
    }

    public void agregarCarta(Carta carta){
        mano.agregarCarta(carta);
    }


    public int contarPuntuacion(){
        return cartasGanadas.contarPuntuacion();
    }

}
