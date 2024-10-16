import Planetas.*;
import Player.Jugador;
public class Main {
    public static void main(String[] args) {
        Jugador player1 = new Jugador();
        MapaGalactico mapa = new MapaGalactico();
        mapa.setPlanetas(mapa.generadorPlaneta());
        Planeta planeta1 = new Helado();
        Planeta planeta2 = new Oceanico();
        Planeta planeta3 = new Radiactivo();
        planeta1.visitar(player1);
        planeta2.visitar(player1);
        planeta3.visitar(player1);
    }
}