package ar.edu.unlu.poo.juego.modelos;

public class Jugador {
    private static int  contadorId = -1;
    private int id;
    private String nombre;
    private ConjuntoDeCartas mano;
    private int puntuacion;
    private ConjuntoDeCartas cartasGanadas;


    public Jugador(String nombre){
        contadorId ++;
        this.id = contadorId;
        this.nombre = nombre;
        this.mano = new ConjuntoDeCartas();
        this.puntuacion = 0;
        this.cartasGanadas = new ConjuntoDeCartas();
    }

    public Carta mostrarCarta(int numeroCarta){
        return mano.getCarta(numeroCarta);
    }

    public Carta jugarCarta(int PosDeCarta){
        return mano.jugar(PosDeCarta);
    }

    //dudoso
    public void agregarCartasGanadas(ConjuntoDeCartas cartasGanadas){
        this.cartasGanadas.agregarCartas(cartasGanadas);
    }

    public void agregarCarta(Carta carta){
        mano.agregarCarta(carta);
    }


    public int contarPuntuacion(){
        return cartasGanadas.contarPuntuacion();
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getId() {
        return id;
    }

    public int cantidadCartas(){
        return mano.cantidad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                "id=" + id;
    }
}
