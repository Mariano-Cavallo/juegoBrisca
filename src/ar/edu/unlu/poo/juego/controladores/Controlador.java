package ar.edu.unlu.poo.juego.controladores;

import ar.edu.unlu.poo.juego.modelos.*;


import ar.edu.unlu.poo.juego.vistas.IVista;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements IControladorRemoto {
    private ITablero modeloTablero;
    //inteface
    private IVista vista;
    private int idJugador;



    public int getJugador()throws RemoteException{
        return idJugador;
    }

    public void setVista(IVista vista) {
        this.vista = vista;
    }

    // Cambiar nombre
    public void crearJugadorEnTablero(String nombre){
        try {
            var jugador = new Jugador(nombre);
            jugador.setId(modeloTablero.siguienteIdJugador());
            idJugador = jugador.getId();
            modeloTablero.agregarJugador(jugador);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public Jugador jugadorTurnoActual(){
        try {
            return modeloTablero.getJugador(modeloTablero.getTurnoActual());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int cantidadJugadores(){
        try {
            return modeloTablero.cantidadJugadores();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public List<Jugador> obtenerJugadores(){
        try {
            return new ArrayList<Jugador>(modeloTablero.getJugadores());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean esMiTurno()  {
        return idJugador == jugadorTurnoActual().getId();
    }

    //setea carta de triunfo
    public void setCartaTriunfo(){
        try {
            modeloTablero.setCartaDeTriunfo(modeloTablero.robarCartaMazo());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    //ver si no hay mas cartas en mazo no repartir
    public void repartirUnaCartaTodosLosJugadores(){
        try {
            for(int i = 0 ;i<= cantidadJugadores()-1;i++){
                modeloTablero.repartir(i,1);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Carta cartaBaza(int numeroDeCarta){
        try {
            return modeloTablero.getCartaBaza(numeroDeCarta);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int cantidadCartasBaza(){
        try {
            return modeloTablero.getCantidadBaza();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int cantidadCartasJugador(){
        try {
            return modeloTablero.getJugador(idJugador).cantidadCartas();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Carta cartaJugador(int numeroDeCarta){
        try {
            return modeloTablero.getJugador(idJugador).mostrarCarta(numeroDeCarta);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Carta getCartaTriunfo(){
        try {
            return modeloTablero.getCartaDeTriunfo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    // otro if para terminar la partida
    public void siguienteTurno(){
        try {
            modeloTablero.siguienteTurno();
            //Termina la ronda
            if (modeloTablero.getCartasJugadas() == cantidadJugadores()){
                modeloTablero.setCartasJugadas(0);
                modeloTablero.borrarBazaAnt();
                terminarRonda();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    //dar baza al ganador y darle el turno al ganador _/ done
    // robar carta_/ done
    //si no hay mas cartas para robar se termina en dos rondas mas
    //preguntar si estas funciones deverian estar en el controlador o en el modelo
    //en el modelo EJ darBazaAlGanador o el controlador repartirUnaCartaTodosLosJugadores
    public void terminarRonda() throws RemoteException{
        try {
            if(modeloTablero.sePuedeRobarCarta()){
                repartirUnaCartaTodosLosJugadores();
                modeloTablero.darBazaAlGanador();
                modeloTablero.darTurnoAlGanador();
            }else if(!modeloTablero.jugadoresTienenCartas()){
                modeloTablero.darBazaAlGanador();
                terminarPartida();
            }else{
                modeloTablero.darBazaAlGanador();
                modeloTablero.darTurnoAlGanador();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    //Contar puntos mostrartlos y cantidad de cartas ganadas
    private void terminarPartida() throws RemoteException{
        try {
            modeloTablero.contarTodosLosPuntos();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


    public void jugarCarta(int posCarta) {
        try {
            modeloTablero.jugadorJuegaCarta(idJugador,posCarta);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void repartir3Jugador(){
        try {
            modeloTablero.repartir(idJugador,3);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public String ganadorDePartida(){
        try {
            if(cantidadJugadores()<4){
                return modeloTablero.getJugador(modeloTablero.ganadorHasta3Jugadores()).getNombre();
            }else{
                int idjugador = modeloTablero.ganador4Jugadores();
                return modeloTablero.getJugador(idjugador).getNombre()+ " y "+ modeloTablero.getJugador(idjugador+2).getNombre() ;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int puntuacionGanadora(){
        try {
            if(cantidadJugadores()<4){
                return modeloTablero.getJugador(modeloTablero.ganadorHasta3Jugadores()).getPuntuacion();
            }else{

                return modeloTablero.getJugador(modeloTablero.ganador4Jugadores()).getPuntuacion();
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void reiniciarPartida() {
        try {
            modeloTablero.nuevoMazo();
            modeloTablero.setTurnoActual(0);
            modeloTablero.borrarJugadores();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void empezarPartida() {
        try {
            modeloTablero.empezarPartida();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void borrarJugador() throws RemoteException {
        modeloTablero.borrarJugador(idJugador);
    }

    //dudoso
    public void cerrarJugador(){
        try {
                modeloTablero.borrarJugador(idJugador);
                vista.cerrar();
                System.exit(0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }




    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T modeloRemoto) throws RemoteException {
        this.modeloTablero = (ITablero) modeloRemoto;
    }

    @Override
    public void actualizar(IObservableRemoto modelo, Object cambio) throws RemoteException {
        try{
            Eventos evento = (Eventos)cambio;
            switch (evento){
                case AGREGAR_JUGADOR:
                    vista.actualizarAgregadoJugador();
                    break;
                case CARTA_JUGADA:
                    vista.actualizarBaza(modeloTablero.getUltimaCartaJugada());
                    break;
                case SIGUIENTE_TURNO:
                    vista.actualizarEstadoJugador();
                    break;
                case RONDA_TERMINADA:
                    vista.actualizarvista();
                    vista.bazaGanadora();
                    vista.mostrarMensaje("ganador es "+ modeloTablero.getJugador((modeloTablero.getUltimoGanador())).getNombre());
                    vista.nuevaBaza();
                    break;
                case TERMINAR_PARTIDA:
                    vista.terminarPartida();
                    break;
                case REINICIO_PARTIDA:
                    //asi o directamente puedo poner en public la otra funcion
                    vista.volverMenuPincipal();
                    break;
                case COMENZAR_PARTIDA:
                    vista.mostraTablero();
                    vista.actualizarEstadoJugador();
                    break;
                case REINICIAR_BAZA:
                    vista.reiniciarBaza();
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public String bazaGanadora() {
        try {
            return modeloTablero.bazaGanadora();
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getNombre() {
        try {
            return modeloTablero.getJugador(idJugador).getNombre();
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public Object[][] getTablaJugadores()throws RemoteException{
        try {
            return this.modeloTablero.getTablaJugadores();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }

    public Object[][] getTablaRanking()throws RemoteException {
        try {
            return this.modeloTablero.getTablaRanking();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }





}
