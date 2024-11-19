package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;

public class ConjuntoDeCartas {
    protected ArrayList<Carta> cartas;
    protected int cantidad;



    public ConjuntoDeCartas(){
        this.cartas = new ArrayList<>();
        this.cantidad = 0;
    }

    public Carta agregarCarta(Carta carta){
        this.cartas.add(carta);
        cantidad ++;
        return carta;
    }

    public Carta jugar(int posDeCarta){
        cantidad--;
        return cartas.remove(posDeCarta+1);
    }
    public Carta sacar(Carta carta){
        cartas.remove(carta);
        cantidad--;
        return carta;
    }

    public ArrayList<Carta> devolverCartas(){
        ArrayList<Carta> cartasDevueltas = new ArrayList<>(cartas);
        cartas.clear();
        cantidad = 0;
        return cartasDevueltas;
    }

    public void agregarCartas(ConjuntoDeCartas conjuntoDeCartas){
        cartas.addAll(conjuntoDeCartas.devolverCartas());
        this.cantidad += conjuntoDeCartas.getCantidad();
    }

    public int getCantidad() {
        return cantidad;
    }

    public int contarPuntuacion(){
        int puntuacion = 0;
        for(Carta c : cartas){
            puntuacion += c.getPuntos();
        }
        return  puntuacion;
    }
    public boolean hayPalo(Palo palo){
        boolean hay = false;
        for (Carta c: cartas){
            if(c.getPalo() == palo){
                hay = true;
            }
        }
        return hay;
    }
    //OJO TIENEN QUE SER DEL MISMO PALO
    public Carta mayorValorFicticio(){
        Carta mayorValor = cartas.getFirst();
        for(Carta c: cartas){
            if(c.getValorFicticio() < mayorValor.getValor()){
                mayorValor = c;
            }
        }
        return mayorValor;
    }

    // Mejorar, nada mas para el conjunto de cartas "baza"
    public int getDueño(Carta c){
        int i = -1;
        for(Carta carta: cartas){
            i++;
            if(carta == c){
                return i;
            }
        }
        return i;
    }

    //cambiar nombre
    public Carta cartaGanadoraRonda(Carta Triunfo){
        ConjuntoDeCartas posiblesGanadoras = new ConjuntoDeCartas();
        Palo palo = Triunfo.getPalo();
        if(hayPalo(palo)){
            for(Carta c: cartas){
                if (c.mismoPalo(palo)){
                    posiblesGanadoras.agregarCarta(c);
                }
            }
            return posiblesGanadoras.mayorValorFicticio();
        }
        else{
            palo = cartas.getFirst().getPalo();
            if(hayPalo(palo)){
                for(Carta c: cartas){
                    if (c.mismoPalo(palo)){
                        posiblesGanadoras.agregarCarta(c);
                    }
                }
                return posiblesGanadoras.mayorValorFicticio();
            }
            else{
                return cartas.getFirst();
            }
        }

    }



}
