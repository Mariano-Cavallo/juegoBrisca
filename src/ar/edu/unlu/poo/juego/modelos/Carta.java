package ar.edu.unlu.poo.juego.modelos;

public class Carta {
    private Palo palo;
    private int valor;
    private int puntos;
    private Jugador dueño;

    public Carta(Palo palo,int valor,int puntos){
        this.palo = palo;
        this.valor = valor;
        this.puntos = puntos;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    public Jugador getDueño() {
        return dueño;
    }


    public int getPuntos(){
        return puntos;
    }

    /*
    @Override
    public String toString() {
        return "Carta{" +
                "palo=" + palo +
                ", valor=" + valor +
                ", puntos=" + puntos +
                ", dueño=" + dueño +
                "}\n";
    }

    */
    @Override
    public String toString() {
        return valor +
                " " + palo +
                "\n";
    }


}
