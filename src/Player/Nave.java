package Player;

import Planetas.MapaGalactico;

import java.util.Scanner;

public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;

    public Nave() {
        this.unidadesCombustible = 100f;
        this.eficienciaPropulsor = 0.0f;
    }

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto) {
        float unidadesConsumidas = 0.75f * (float) Math.pow(tamanoSalto, 2) * (1 - eficienciaPropulsor);
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: Iniciando protocolo de salto.\n>> LPaDOS: Se usaran " + unidadesConsumidas +
                " unidades de combustible.\n>> LPaDOS: ¿Quieres proceder con el protocolo?\n>>    Si (1)\n>>    " +
                "No (2)");
        int Eleccion = obj.nextInt();
        if (Eleccion == 1) {
            System.out.println(">> LPaDOS: SALTANDO AL HIPER-ESPACIO.");
            if (unidadesConsumidas > this.unidadesCombustible) {
                System.out.println(">> La nave se detiene de golpe mientras viajabas por el hiper-espacio.\n>> " +
                        "LPaDOS: ERROR DE CALCULO DE COMBUSTIBLE.\n>> LPaDOS: Nos hemos quedado sin combustible en " +
                        "pleno salto.\n>> LPaDOS: Nuestra aventura a terminado aqui, volveremos al planeta inicial." +
                        "\n>> LPaDOS: ACTIVANDO CAPSULA DE ESCAPE DE EMERGENCIA.\n>> Ves por la ventanilla de la " +
                        "capsula como te alejas rapidamente de tu nave.\n>> Te sumes en un estado de letargo hasta " +
                        "que llegues a un lugar seguro....");
                // sistema de game over aqui
                return false;
            } else if (unidadesConsumidas == this.unidadesCombustible) {
                unidadesCombustible -= unidadesConsumidas;
                System.out.println(">> LPaDOS: Finalizando protocolo de salto, hemos llegado a la orbita del Planeta." +
                        "\n>> LPaDOS: AVISO IMPORTANTE.\n>> LPaDOS: Este ultimo salto nos dejo con 0 unidades de " +
                        "combustible, si no recargas combustible en este Planeta es posible que en siguiente salto al" +
                        " hiper-espacio nos quedemos sin combustible y a la derivaba.");
                return true;
            } else {
                unidadesCombustible -= unidadesConsumidas;
                System.out.println(">> LPaDOS: Finalizando protocolo de salto, hemos llegado a la orbita del Planeta.");
                if (direccion == 1) {
                    MG.setPosicion(tamanoSalto);
                } else {
                    MG.setPosicion(-tamanoSalto);
                }
                return true;
            }
        } else if (Eleccion == 2) {
            System.out.println(">> LPaDOS: Cancelando protocolo de salto, no abandonaremos este Planeta.");
            return true;
        } else {
            System.out.println(">> LPaDOS: Eleccion invalida, cancelando protocolo de salto.");
            return true;
        }

    }
    public void recargarPropulsores(int hidrogeno) {
        float unidadesRecargadas = 0.6f * hidrogeno * (1 + eficienciaPropulsor);
        System.out.println("Se han recargado " + unidadesRecargadas + " unidades de combustible");
        this.unidadesCombustible = +unidadesCombustible;
    }

    public void setEficienciaPropulsor(float eficiencia) {
        this.eficienciaPropulsor += eficiencia;
        System.out.println(">> LPaDOS: Se ha mejorado la eficiencia del propulsor en un " + (int)eficiencia*100 + "%.");
    }
    public float getEficienciaPropulsor () {
        return this.eficienciaPropulsor;
    }
}