package Planetas;

import java.util.ArrayList;
import java.util.List;

public class MapaGalactico {
    private List<Planeta> planetas;
    private int posicion;
    private boolean CG;
    public MapaGalactico(){
        this.posicion = 0;
        planetas = new ArrayList<>();
        planetas.add(generadorPlaneta());
        this.CG = false;
    }
    public Planeta generadorPlaneta(){
        int numeroAleatorio = (int)Math.floor(Math.random() * ((100 - 1) + 1) + 1);
        if (numeroAleatorio <= 30){
            return new Helado();
        } else if (numeroAleatorio <= 60) {
            return new Oceanico();
        } else if (numeroAleatorio <= 80) {
            return  new Radiactivo();
        } else if (numeroAleatorio <= 99) {
            return new Volcanico();
        } else if (numeroAleatorio == 100) {
            if (this.CG){
                return generadorPlaneta();
            }
            CG = true;
            return new CentroGalactico();
        } else {
            System.out.println("ERROR AL GENERAR PLANETA");
            return new Helado();
        }
    }
    public void setPlanetas(Planeta planeta){
        this.planetas.add(planeta);
        this.planetas.add(5,planeta);
    }
    public void
}
