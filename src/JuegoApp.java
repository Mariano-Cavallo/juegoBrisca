import ar.edu.unlu.poo.juego.controladores.Controlador;
import ar.edu.unlu.poo.juego.modelos.*;
import ar.edu.unlu.poo.juego.vistas.Consola.VistaConsolaGrafica;
import ar.edu.unlu.poo.juego.vistas.grafica.VistaGrafica;

public class JuegoApp {
    public static void main(String[] args) {

        var tablero = new Tablero();

        var controlador = new Controlador(tablero);
        var controlador2 = new Controlador(tablero);
        //var controlador3 = new Controlador(tablero);
        //var controlador4 = new Controlador(tablero);




        var vistaConsola = new VistaConsolaGrafica(controlador);
        var vistaGrafica = new VistaGrafica(controlador2);
        //var vistaGrafica2 = new VistaGrafica(controlador3);
        //var vistaGrafica3 = new VistaGrafica(controlador4);




        tablero.agregarObservador(controlador);
        tablero.agregarObservador(controlador2);
        //tablero.agregarObservador(controlador3);
        //tablero.agregarObservador(controlador4);






        controlador.setVista(vistaConsola);
        controlador2.setVista(vistaGrafica);
        //controlador3.setVista(vistaGrafica2);
        //controlador4.setVista(vistaGrafica3);





        vistaConsola.iniciar();
        vistaGrafica.iniciar();
        //vistaGrafica2.iniciar();
        //vistaGrafica3.iniciar();





    }
}
