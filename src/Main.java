import Planetas.Helados;
import Planetas.Oceanico;
import Planetas.Radiactivo;
import Planetas.Volcanico;

public class Main {
    public static void main(String[] args) {
        Helados Planeta1 = new Helados();
        Planeta1.printeador();
        Volcanico Planeta2 = new Volcanico();
        Planeta2.printeador();
        Oceanico Planeta3 = new Oceanico();
        Planeta3.printeador();
        Radiactivo Planeta4 = new Radiactivo();
        Planeta4.printeador();
    }
}