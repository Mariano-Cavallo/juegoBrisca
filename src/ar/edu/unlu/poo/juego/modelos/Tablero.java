package ar.edu.unlu.poo.juego.modelos;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;



import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Tablero extends ObservableRemoto implements ITablero,Serializable {
    private Baza baza;
    private Carta cartaDeTriunfo;
    private Mazo mazo;
    private ArrayList<Jugador> jugadores;
    private int turnoActual = 0;
    private int cartasJugadas = 0;
    private int ultimoGanador = -1;
    private int idSiguiente = -1;
    private Baza bazaGanadoraAnterior;




    public Tablero() throws RemoteException{
        this.mazo = new Mazo();
        this.baza = new Baza();
        this.bazaGanadoraAnterior = new Baza();
        jugadores = new ArrayList<>();
    }

    @Override
    public void nuevoMazo() throws RemoteException{
        this.mazo = new Mazo();
    }

    @Override
    public int getCantidadBaza()throws RemoteException{
        return baza.cantidad;
    }


    @Override
    public List<Jugador> getJugadores()throws RemoteException{
        return jugadores;
    }

    @Override
    public void agregarJugador(Jugador jugador) throws RemoteException {
        jugadores.add(jugador);
        notificarObservadores(Eventos.AGREGAR_JUGADOR);
    }

    @Override
    public int cantidadJugadores()throws RemoteException{
        return jugadores.size();
    }


    @Override
    public void setCartaDeTriunfo(Carta carta)throws RemoteException{
        cartaDeTriunfo = carta;
    }

    @Override
    public Carta getCartaDeTriunfo()throws RemoteException {
        return cartaDeTriunfo;
    }


    @Override
    public int getCantidadMazo()throws RemoteException{
        return mazo.getCantidad();
    }

    @Override
    public Jugador getJugador(int i)throws RemoteException{
        return jugadores.get(i);
    }

    @Override
    public Carta robarCartaMazo()throws RemoteException{
        return mazo.robar();
    }

    @Override
    public int siguienteTurno() throws RemoteException {
        turnoActual = (turnoActual + 1)% jugadores.size();
        notificarObservadores(Eventos.SIGUIENTE_TURNO);
        return turnoActual;
    }

    @Override
    public int getTurnoActual()throws RemoteException{
        return turnoActual;
    }

    @Override
    public void setTurnoActual(int turno)throws RemoteException{
        this.turnoActual = turno;
    }

    // ver cuando no se pueda robar
    @Override
    public void repartir(int idJugador, int cantidad)throws RemoteException{
        for(int i = 0;i < cantidad;i++) {
            getJugador(idJugador).agregarCarta(robarCartaMazo());
        }
    }


    @Override
    public int ganadorDeRonda()throws RemoteException{
        this.ultimoGanador = baza.getDueño(baza.cartaGanadoraRonda(cartaDeTriunfo),getTurnoActual(),cantidadJugadores());
        return ultimoGanador;
    }


    @Override
    public Carta getUltimaCartaJugada()throws RemoteException{
        return baza.getUltimaAgregada();
    }

    @Override
    public void jugadorJuegaCarta(int idJugador, int posCarta) throws RemoteException {
        cartasJugadas++;
        baza.agregarCarta(jugadores.get(idJugador).jugarCarta(posCarta));
        notificarObservadores(Eventos.CARTA_JUGADA);

    }

    @Override
    public Carta getCartaBaza(int numeroDeCarta)throws RemoteException {
        return baza.getCarta(numeroDeCarta);
    }

    @Override
    public int getCartasJugadas() throws RemoteException{
        return cartasJugadas;
    }

    @Override
    public void setCartasJugadas(int i) throws RemoteException{
        cartasJugadas = i;
    }

    @Override
    public void darBazaAlGanador() throws RemoteException {
        //dudoso
        getJugador(ganadorDeRonda()).agregarCartasGanadas(this.baza);
        bazaGanadoraAnterior.agregarCartas(baza);
        this.baza.borrar();
        notificarObservadores(Eventos.RONDA_TERMINADA);
    }


    @Override
    public int getUltimoGanador() throws RemoteException{
        return ultimoGanador;
    }

    @Override
    public void darTurnoAlGanador() throws RemoteException {
        setTurnoActual(ultimoGanador);
        notificarObservadores(Eventos.SIGUIENTE_TURNO);
    }

    @Override
    public boolean sePuedeRobarCarta() throws RemoteException{
        return cantidadJugadores() <= getCantidadMazo();
    }

    //se fija si el primer jugador tiene almenos una carta
    @Override
    public boolean jugadoresTienenCartas()throws RemoteException {
        return getJugador(0).cantidadCartas() > 0;
    }

    @Override
    public void contarTodosLosPuntos() throws RemoteException {
        for(Jugador j : jugadores){
            j.contarPuntuacion();
        }
        notificarObservadores(Eventos.TERMINAR_PARTIDA);
    }

    @Override
    public int ganadorHasta3Jugadores()throws RemoteException{
        int ganador = 0;
        int puntuacionGanadora = 0 ;
        int flag = 0 ;
        for (Jugador j : jugadores){
            if(flag == 0){
                puntuacionGanadora = j.getPuntuacion();
                ganador = j.getId();
                flag ++;
            }
            if(j.getPuntuacion() > puntuacionGanadora){
                ganador = j.getId();
                puntuacionGanadora = j.getPuntuacion();
            }
        }
        return ganador;
    }

    @Override
    public int ganador4Jugadores()throws RemoteException{
        int puntosEquipo1;
        int puntosEquipo2;
        puntosEquipo1 = getJugador(0).getPuntuacion() + getJugador(2).getPuntuacion();
        puntosEquipo2 = getJugador(1).getPuntuacion() + getJugador(3).getPuntuacion();

        if(puntosEquipo1 > puntosEquipo2){
            return 0;
        }
        else{
            return 1;
        }

    }


    @Override
    public void empezarPartida() throws RemoteException {
        notificarObservadores(Eventos.COMENZAR_PARTIDA);
    }

    @Override
    public void borrarJugador(int idJugador) throws RemoteException{
        jugadores.remove(idJugador);
        idSiguiente--;
    }

    @Override
    public void borrarJugadores() throws RemoteException {
        jugadores.clear();
        idSiguiente = -1;
        //podia mejorar al no cambiar a todos al menu principal
        notificarObservadores(Eventos.REINICIO_PARTIDA);
    }

    @Override
    public int siguienteIdJugador() throws RemoteException {
        return ++idSiguiente;
    }

    @Override
    public String bazaGanadora() {
        String Cartas = "";
        for(int i = 1; i<=bazaGanadoraAnterior.getCantidad();i++){
            Cartas += (bazaGanadoraAnterior.getCarta(i).toString())+"\n";
        }
        return Cartas;
    }

    @Override
    public void borrarBazaAnt() {
        try {
            bazaGanadoraAnterior.borrar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
