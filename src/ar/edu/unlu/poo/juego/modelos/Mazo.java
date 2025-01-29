package ar.edu.unlu.poo.juego.modelos;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo extends ConjuntoDeCartas{

    //hacer
    private boolean puedeRobar;

    public Mazo(){
        super();
        llenarDeCartas();
        mezclar();
    }

    public Carta robar(){
        cantidad --;
        return cartas.removeLast();

    }

    public void mezclar(){
        Collections.shuffle(cartas);
    }

    public void llenarDeCartas(){
        //Cartas Copa
        /*
        Carta copa1 = new Carta(Palo.COPA,1,11);
        Carta copa2 = new Carta(Palo.COPA,2,0);
        Carta copa3 = new Carta(Palo.COPA,3,10);
        Carta copa4 = new Carta(Palo.COPA,4,0);
        Carta copa5 = new Carta(Palo.COPA,5,0);
        Carta copa6 = new Carta(Palo.COPA,6,0);
        Carta copa7 = new Carta(Palo.COPA,7,0);
        Carta copa10 = new Carta(Palo.COPA,10,2);
        Carta copa11 = new Carta(Palo.COPA,11,3);
        Carta copa12 = new Carta(Palo.COPA,12,4);
        //Cartas Oro
        Carta oro1 = new Carta(Palo.ORO,1,11);
        Carta oro2 = new Carta(Palo.ORO,2,0);
        Carta oro3 = new Carta(Palo.ORO,3,10);
        Carta oro4 = new Carta(Palo.ORO,4,0);
        Carta oro5 = new Carta(Palo.ORO,5,0);
        Carta oro6 = new Carta(Palo.ORO,6,0);
        Carta oro7 = new Carta(Palo.ORO,7,0);
        Carta oro10 = new Carta(Palo.ORO,10,2);
        */
        Carta oro11 = new Carta(Palo.ORO,11,3);
        Carta oro12 = new Carta(Palo.ORO,12,4);
        //Cartas Basto
        Carta basto1 = new Carta(Palo.BASTO,1,11);
        Carta basto2 = new Carta(Palo.BASTO,2,0);
        Carta basto3 = new Carta(Palo.BASTO,3,10);
        Carta basto4 = new Carta(Palo.BASTO,4,0);
        Carta basto5 = new Carta(Palo.BASTO,5,0);
        Carta basto6 = new Carta(Palo.BASTO,6,0);
        Carta basto7 = new Carta(Palo.BASTO,7,0);
        Carta basto10 = new Carta(Palo.BASTO,10,2);
        Carta basto11 = new Carta(Palo.BASTO,11,3);
        Carta basto12 = new Carta(Palo.BASTO,12,4);


        //Cartas Espada
        Carta espada1 = new Carta(Palo.ESPADA,1,11);
        Carta espada2 = new Carta(Palo.ESPADA,2,0);
        Carta espada3 = new Carta(Palo.ESPADA,3,10);
        Carta espada4 = new Carta(Palo.ESPADA,4,0);
        Carta espada5 = new Carta(Palo.ESPADA,5,0);
        Carta espada6 = new Carta(Palo.ESPADA,6,0);
        Carta espada7 = new Carta(Palo.ESPADA,7,0);
        Carta espada10 = new Carta(Palo.ESPADA,10,2);
        Carta espada11 = new Carta(Palo.ESPADA,11,3);
        Carta espada12 = new Carta(Palo.ESPADA,12,4);
       /*
        agregarCarta(copa1);
        agregarCarta(copa2);
        agregarCarta(copa3);
        agregarCarta(copa4);
        agregarCarta(copa5);
        agregarCarta(copa6);
        agregarCarta(copa7);
        agregarCarta(copa10);
        agregarCarta(copa11);
        agregarCarta(copa12);
        agregarCarta(oro1);
        agregarCarta(oro2);
        agregarCarta(oro3);
        agregarCarta(oro4);
        agregarCarta(oro5);
        agregarCarta(oro6);
        agregarCarta(oro7);
        agregarCarta(oro10);
        */
        agregarCarta(oro11);
        agregarCarta(oro12);
        agregarCarta(basto1);
        agregarCarta(basto2);
        agregarCarta(basto3);
        agregarCarta(basto4);

        agregarCarta(basto5);
        agregarCarta(basto6);
        agregarCarta(basto7);
        agregarCarta(basto10);
        agregarCarta(basto11);
        agregarCarta(basto12);
        agregarCarta(espada1);
        agregarCarta(espada2);
        agregarCarta(espada3);
        agregarCarta(espada4);
        agregarCarta(espada5);
        agregarCarta(espada6);
        agregarCarta(espada7);
        agregarCarta(espada10);
        agregarCarta(espada11);
        agregarCarta(espada12);
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "cantidad=" + cantidad +
                ", cartas=" + cartas +
                '}';
    }
}
