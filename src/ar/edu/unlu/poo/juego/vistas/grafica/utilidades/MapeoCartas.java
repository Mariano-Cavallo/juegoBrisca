package ar.edu.unlu.poo.juego.vistas.grafica.utilidades;

import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MapeoCartas  implements Serializable {
    private Map<String,String> mapaImagenes;




    public MapeoCartas() {
        mapaImagenes = new HashMap<>();
        this.mapearImagenes();
    }

    public ImageIcon getImagen(String nombreCarta){
        String key = nombreCarta;
        String nombreImagen = mapaImagenes.get(key);
        if(nombreImagen != null){
            return new ImageIcon(("src/ImagenesCartas/" + nombreImagen));
        }else{
            return null;
        }
    }


    private void mapearImagenes(){
        mapaImagenes.put("1 BASTO","01-bastos.png");
        mapaImagenes.put("2 BASTO","02-bastos.png");
        mapaImagenes.put("3 BASTO","03-bastos.png");
        mapaImagenes.put("4 BASTO","04-bastos.png");
        mapaImagenes.put("5 BASTO","05-bastos.png");
        mapaImagenes.put("6 BASTO","06-bastos.png");
        mapaImagenes.put("7 BASTO","07-bastos.png");
        mapaImagenes.put("10 BASTO","10-bastos.png");
        mapaImagenes.put("11 BASTO","11-bastos.png");
        mapaImagenes.put("12 BASTO","12-bastos.png");
        mapaImagenes.put("1 ORO","01-oros.png");
        mapaImagenes.put("2 ORO","02-oros.png");
        mapaImagenes.put("3 ORO","03-oros.png");
        mapaImagenes.put("4 ORO","04-oros.png");
        mapaImagenes.put("5 ORO","05-oros.png");
        mapaImagenes.put("6 ORO","06-oros.png");
        mapaImagenes.put("7 ORO","07-oros.png");
        mapaImagenes.put("10 ORO","10-oros.png");
        mapaImagenes.put("11 ORO","11-oros.png");
        mapaImagenes.put("12 ORO","12-oros.png");
        mapaImagenes.put("1 ESPADA","01-espadas.png");
        mapaImagenes.put("2 ESPADA","02-espadas.png");
        mapaImagenes.put("3 ESPADA","03-espadas.png");
        mapaImagenes.put("4 ESPADA","04-espadas.png");
        mapaImagenes.put("5 ESPADA","05-espadas.png");
        mapaImagenes.put("6 ESPADA","06-espadas.png");
        mapaImagenes.put("7 ESPADA","07-espadas.png");
        mapaImagenes.put("10 ESPADA","10-espadas.png");
        mapaImagenes.put("11 ESPADA","11-espadas.png");
        mapaImagenes.put("12 ESPADA","12-espadas.png");
        mapaImagenes.put("1 COPA","01-copas.png");
        mapaImagenes.put("2 COPA","02-copas.png");
        mapaImagenes.put("3 COPA","03-copas.png");
        mapaImagenes.put("4 COPA","04-copas.png");
        mapaImagenes.put("5 COPA","05-copas.png");
        mapaImagenes.put("6 COPA","06-copas.png");
        mapaImagenes.put("7 COPA","07-copas.png");
        mapaImagenes.put("10 COPA","10-copas.png");
        mapaImagenes.put("11 COPA","11-copas.png");
        mapaImagenes.put("12 COPA","12-copas.png");

    }





}
