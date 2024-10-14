import Planetas.*;
import Player.Jugador;
public class Main {
    public static void main(String[] args) {
        MapaGalactico mapa = new MapaGalactico();
        mapa.setPlanetas(mapa.generadorPlaneta());


    }
}