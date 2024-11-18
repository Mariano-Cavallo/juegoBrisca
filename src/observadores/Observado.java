package observadores;

import ar.edu.unlu.poo.juego.modelos.Eventos;

public interface Observado {
    void agregarObservador(Observador observador);
    void notificarObservador(Eventos evento);

}
