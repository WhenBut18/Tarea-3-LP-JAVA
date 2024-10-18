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
    }
    public void setPosicion(int salto) {
        this.posicion += salto;
    }
    public int getPosicion(){
        return posicion;
    }
    public List<Planeta> getPlanetas(){
        return  this.planetas;
    }
    public void printeador(){
        System.out.print("PLANETA " + getPosicion() +" || Tipo: ");
        if (planetas.get(posicion) instanceof Helado) {
            System.out.println("HELADO");
        } else if (planetas.get(posicion) instanceof Oceanico) {
            System.out.println("OCEANICO");
        } else if (planetas.get(posicion) instanceof Radiactivo) {
            System.out.println("RADIACTIVO");
        } else if (planetas.get(posicion) instanceof Volcanico) {
            System.out.println("VOLCANICO");
        } else {
            System.out.println("CENTRO GALACTICO");
        }
    }
    public void printeadorMapa(){
        System.out.print("╔═════════════════════════════════════════╕\n║>> LPaDOS: Desplegando Mapa Galactico...");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.print("\n║>>    ("+ i + ") PLANETA ");
            if (planetas.get(i) instanceof Helado) {
                System.out.print("HELADO");
            } else if (planetas.get(i) instanceof Oceanico) {
                System.out.print("OCEANICO");
            } else if (planetas.get(i) instanceof Radiactivo) {
                System.out.print("RADIACTIVO");
            } else if (planetas.get(i) instanceof Volcanico) {
                System.out.print("VOLCANICO");
            } else {
                System.out.print("CENTRO GALACTICO");
            }
            if (i == this.posicion) {
                System.out.print(" <---- ESTAMOS ACA");
            }
        }
        System.out.println("\n╚═════════════════════════════════════════╛");
    }
}
