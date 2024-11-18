package ar.edu.unlu.poo.juego.modelos;

public class Carta {
    private Palo palo;
    private int valor;
    private int puntos;
    private int valorFicticio;


    public Carta(Palo palo,int valor,int puntos){
        this.palo = palo;
        this.valor = valor;
        this.puntos = puntos;
    }

    public int getPuntos(){
        return puntos;
    }

    public int getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }
    public boolean mismoPalo(Palo p){
        return this.palo == p;
    }
    public boolean tieneMayorValorFicticio(Carta c){
        return c.getValorFicticio() > this.getValorFicticio();

    }

    public void setValorFicticio() {
        switch (this.valor){
            case(1)-> valorFicticio = 1;
            case(3)->valorFicticio = 2;
            case(12)-> valorFicticio = 4;
            case(11)-> valorFicticio = 5;
            case(10)-> valorFicticio = 6;
            default-> valorFicticio = 7;
        }
    }

    public int getValorFicticio() {
        return valorFicticio;
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
