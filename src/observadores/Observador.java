package observadores;

import ar.edu.unlu.poo.juego.modelos.Eventos;

public interface Observador {
    void notificar(Eventos evento);

}
