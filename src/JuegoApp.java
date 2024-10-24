import ar.edu.unlu.poo.juego.modelos.Carta;
import ar.edu.unlu.poo.juego.modelos.Mazo;
import ar.edu.unlu.poo.juego.modelos.Palo;

public class JuegoApp {
    public static void main(String[] args) {

        Carta copa2 = new Carta(Palo.COPA,2,0);
        Carta copa3 = new Carta(Palo.COPA,3,0);
        Carta copa4 = new Carta(Palo.COPA,4,0);
        Carta copa5 = new Carta(Palo.COPA,5,0);
        Carta copa6 = new Carta(Palo.COPA,6,0);
        Carta copa7 = new Carta(Palo.COPA,7,10);

        Mazo mazoPrincipal = new Mazo();

        mazoPrincipal.agregar(copa2);
        mazoPrincipal.agregar(copa3);
        mazoPrincipal.agregar(copa4);
        mazoPrincipal.agregar(copa5);
        mazoPrincipal.agregar(copa6);
        mazoPrincipal.agregar(copa7);

        System.out.print(mazoPrincipal.robar());

        System.out.print(mazoPrincipal);



    }
}
