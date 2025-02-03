package ar.edu.unlu.poo.juego.modelos;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.List;

public interface ITablero extends IObservableRemoto {
    void nuevoMazo()throws RemoteException;

    int getCantidadBaza()throws RemoteException;

    int getCantidadJugadores()throws RemoteException;

    List<Jugador> getJugadores()throws RemoteException;

    void agregarJugador(Jugador jugador) throws RemoteException;

    int cantidadJugadores()throws RemoteException;

    void agregarCartaBaza(Carta carta)throws RemoteException;

    void setCartaDeTriunfo(Carta carta)throws RemoteException;

    Carta getCartaDeTriunfo()throws RemoteException;

    ConjuntoDeCartas darBaza()throws RemoteException;

    int getCantidadMazo()throws RemoteException;

    Jugador getJugador(int i)throws RemoteException;

    Carta robarCartaMazo()throws RemoteException;

    int siguienteTurno() throws RemoteException;

    int getTurnoActual()throws RemoteException;

    void setTurnoActual(int turno)throws RemoteException;

    // ver cuando no se pueda robar
    void repartir(int idJugador, int cantidad)throws RemoteException;

    void jugadorRoba(int idJugador)throws RemoteException;

    int ganadorDeRonda()throws RemoteException;

    Carta getUltimaCartaJugada()throws RemoteException;

    void jugadorJuegaCarta(int idJugador, int posCarta) throws RemoteException;

    Carta getCartaBaza(int numeroDeCarta)throws RemoteException;

    int getCartasJugadas()throws RemoteException;

    void setCartasJugadas(int i)throws RemoteException;


    void darBazaAlGanador() throws RemoteException;

    int getUltimoGanador()throws RemoteException;

    void darTurnoAlGanador() throws RemoteException;

    int jugadorPuedeCambiarLaCartaDeTriunfo()throws RemoteException;

    boolean sePuedeRobarCarta()throws RemoteException;

    //se fija si el primer jugador tiene almenos una carta
    boolean jugadoresTienenCartas()throws RemoteException;

    void contarTodosLosPuntos() throws RemoteException;

    int ganadorHasta3Jugadores()throws RemoteException;

    int ganador4Jugadores()throws RemoteException;

    void empezarPartida() throws RemoteException;

    void borrarJugador(int idJugador)throws RemoteException;

    void borrarJugadores() throws RemoteException;

    int siguienteIdJugador()throws RemoteException;

    String bazaGanadora()throws RemoteException;

    void borrarBazaAnt()throws RemoteException;
}
