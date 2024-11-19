import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.*;
import ar.edu.unlu.poo.juego.vistas.VistaGrafica;

public class JuegoApp {
    public static void main(String[] args) {

        //Cartas Copa
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


        Mazo mazoPrincipal = new Mazo();

        mazoPrincipal.agregarCarta(copa1);
        mazoPrincipal.agregarCarta(copa2);
        mazoPrincipal.agregarCarta(copa3);
        mazoPrincipal.agregarCarta(copa4);
        mazoPrincipal.agregarCarta(copa5);
        mazoPrincipal.agregarCarta(copa6);
        mazoPrincipal.agregarCarta(copa7);
        mazoPrincipal.agregarCarta(copa10);
        mazoPrincipal.agregarCarta(copa11);
        mazoPrincipal.agregarCarta(copa12);

        mazoPrincipal.agregarCarta(oro1);
        mazoPrincipal.agregarCarta(oro2);
        mazoPrincipal.agregarCarta(oro3);
        mazoPrincipal.agregarCarta(oro4);
        mazoPrincipal.agregarCarta(oro5);
        mazoPrincipal.agregarCarta(oro6);
        mazoPrincipal.agregarCarta(oro7);
        mazoPrincipal.agregarCarta(oro10);
        mazoPrincipal.agregarCarta(oro11);
        mazoPrincipal.agregarCarta(oro12);

        mazoPrincipal.agregarCarta(espada1);
        mazoPrincipal.agregarCarta(espada2);
        mazoPrincipal.agregarCarta(espada3);
        mazoPrincipal.agregarCarta(espada4);
        mazoPrincipal.agregarCarta(espada5);
        mazoPrincipal.agregarCarta(espada6);
        mazoPrincipal.agregarCarta(espada7);
        mazoPrincipal.agregarCarta(espada10);
        mazoPrincipal.agregarCarta(espada11);
        mazoPrincipal.agregarCarta(espada12);

        mazoPrincipal.agregarCarta(basto1);
        mazoPrincipal.agregarCarta(basto2);
        mazoPrincipal.agregarCarta(basto3);
        mazoPrincipal.agregarCarta(basto4);
        mazoPrincipal.agregarCarta(basto5);
        mazoPrincipal.agregarCarta(basto6);
        mazoPrincipal.agregarCarta(basto7);
        mazoPrincipal.agregarCarta(basto10);
        mazoPrincipal.agregarCarta(basto11);
        mazoPrincipal.agregarCarta(basto12);
        mazoPrincipal.agregarValorCartas();
        mazoPrincipal.mezclar();
        ConjuntoDeCartas conjunto1 = new ConjuntoDeCartas();
        conjunto1.agregarCarta(basto1);
        conjunto1.agregarCarta(copa6);
        conjunto1.agregarCarta(basto12);
        conjunto1.agregarCarta(oro4);
        System.out.print(conjunto1.cartaGanadoraRonda(copa2));
        System.out.print(conjunto1.getDueño(conjunto1.cartaGanadoraRonda(copa2)));
        Jugador j1 = new Jugador("mari");
        Jugador j2 = new Jugador("feli");
        Jugador j3 = new Jugador("juan");
        Jugador j4 = new Jugador("luqui");
        System.out.print(j1);
        System.out.print(j2);
        System.out.print(j3);
        System.out.print(j4);



        var tablero = new Tablero(mazoPrincipal);
        tablero.agregarJugador(j1);
        tablero.agregarJugador(j2);
        tablero.agregarJugador(j3);
        tablero.agregarJugador(j4);
        var controlador = new Controlador(tablero);
        var vista = new VistaGrafica(controlador);
        controlador.setVista(vista);
        vista.setVisible(true);

    }
}
