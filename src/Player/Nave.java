package Player;

import Planetas.MapaGalactico;

public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    public Nave(){
        this.unidadesCombustible = 100f;
        this.eficienciaPropulsor = 0.0f;
    }
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        float unidadesConsumidas = 0.75f * (float)Math.pow(tamanoSalto,2) * (1 - eficienciaPropulsor);
        System.out.println(">> LPaDOS: Se usaran " + unidadesConsumidas + " unidades de combustible.");
        // ELECCION DE SALTAR O NO
        System.out.println(">> LPaDOS: SALTANDO AL HIPER-ESPACIO");
        if (unidadesConsumidas > this.unidadesCombustible) {
            System.out.println(">> La nave se detiene de golpe mientras viajabas por el hiper-espacio");
            System.out.println(">> LPaDOS: ERROR DE CALCULO DE COMBUSTIBLE");
            System.out.println(">> LPaDOS: Nos hemos quedado sin combustible en pleno salto");
            System.out.println(">> LPaDOS: Nuestra aventura a terminado aqui, volveremos al planeta inicial");
            System.out.println(">> LPaDOS: ACTIVANDO CAPSULA DE ESCAPE DE EMERGENCIA");
            System.out.println(">> Ves por la ventanilla de la capsula como te alejas rapidamente de tu nave");
            System.out.println(">> Te sumes en un estado de letargo hasta que llegues a un lugar seguro....");
            // sistema de game over aqui
            return false;
        } else if (unidadesConsumidas == this.unidadesCombustible) {
            unidadesCombustible -= unidadesConsumidas;
            System.out.println(">> ");
            // ingenioso mensaje de que casi se acaba el combustible
            return true;
        } else {
            unidadesCombustible -= unidadesConsumidas;
            // mensaje de llegada y sustema de cambio de ubicacion
            return true;
        }
    }
    public void recargarPropulsores(int hidrogeno) {
        float unidadesRecargadas = 0.6f * hidrogeno * (1 + eficienciaPropulsor);
        System.out.println("Se han recargado " + unidadesRecargadas + " unidades de combustible");
    }
}
