package ar.edu.unlu.poo.juego.modelos;

import java.io.Serializable;

public class Baza extends ConjuntoDeCartas implements Serializable {


    public Baza(){
        super();
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

    public Carta cartaGanadoraRonda(Carta Triunfo){
        ConjuntoDeCartas posiblesGanadoras = new ConjuntoDeCartas();
        Palo palo = Triunfo.getPalo();
        if(hayPalo(palo)){
            for(Carta c: cartas){
                if (c.mismoPalo(palo)){
                    posiblesGanadoras.agregarCarta(c);
                }
            }
            return posiblesGanadoras.mayorPuntuacion();
        }
        else{
            palo = cartas.getFirst().getPalo();
            if(hayPalo(palo)){
                for(Carta c: cartas){
                    if (c.mismoPalo(palo)){
                        posiblesGanadoras.agregarCarta(c);
                    }
                }
                return posiblesGanadoras.mayorPuntuacion();
            }
            else{
                return cartas.getFirst();
            }
        }
    }
    public int getDueño(Carta c,int turnoActual,int cantidadJugadores){
        int i = -1;
        for(Carta carta: cartas){
            i++;
            if(carta == c){
                return (i+turnoActual) % cantidadJugadores  ;
            }
        }
        return (i+turnoActual) % cantidadJugadores;
    }


}
