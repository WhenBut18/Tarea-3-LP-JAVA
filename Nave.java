import java.util.Scanner;

public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : None
    ***
    Constructor de la clase Nave que inicializa las propiedades de la nave.
    Establece 'unidadesCombustible' en 100.0f y 'eficienciaPropulsor' en 0.0f.
    */
    public Nave() {
        this.unidadesCombustible = 100.0f;
        this.eficienciaPropulsor = 0.0f;
    }

    /*
    ***
    Parametro 1 : MapaGalactico MG
    Parametro 2 : int direccion
    Parametro 3 : int tamanoSalto
    ***
    Tipo de Retorno : boolean
    ***
    Método que gestiona el viaje de la nave a un nuevo planeta. Calcula las unidades de combustible consumidas
    en función del tamaño del salto y la eficiencia del propulsor. Solicita al usuario confirmar el salto y, si se
    procede, actualiza la cantidad de combustible. Si se quedan sin combustible durante el salto, activa la cápsula
    de emergencia. También crea nuevos planetas si es necesario y actualiza la posición en el mapa galáctico.
    */
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto) {
        float unidadesConsumidas = 0.75f * (float) Math.pow(tamanoSalto, 2) * (1 - eficienciaPropulsor);
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: Iniciando protocolo de salto.\n>> LPaDOS: Se usaran " + unidadesConsumidas +
                " unidades de combustible.\n>> LPaDOS: ¿Quieres proceder con el protocolo?\n>>   (1) Si\n>>   " +
                "(2) No ");
        int Eleccion = obj.nextInt();
        if (Eleccion == 1) {
            System.out.println(">> LPaDOS: SALTANDO AL HIPER-ESPACIO.");
            if (unidadesConsumidas >= this.unidadesCombustible) {
                this.unidadesCombustible -= unidadesConsumidas;
                System.out.println(">> La nave se detiene de golpe mientras viajabas por el hiper-espacio.\n>> " +
                        "LPaDOS: ERROR DE CALCULO DE COMBUSTIBLE.\n>> LPaDOS: Nos hemos quedado sin combustible en " +
                        "pleno salto.\n>> LPaDOS: Nuestra aventura a terminado aqui, volveremos al planeta inicial." +
                        "\n>> LPaDOS: ACTIVANDO CAPSULA DE ESCAPE DE EMERGENCIA.\n>> Ves por la ventanilla de la " +
                        "capsula como te alejas rapidamente de tu nave.\n>> Te sumes en un estado de letargo hasta " +
                        "que llegues a un lugar seguro....");
                return false;
            } else {
                unidadesCombustible -= unidadesConsumidas;
                int planetasCrear = (MG.getPosicion() + tamanoSalto + 1) - MG.getPlanetas().size();
                if (planetasCrear > 0 && direccion == 1){
                    for (int i = 0; i < planetasCrear; i++) {
                        MG.setPlanetas(MG.generadorPlaneta());
                    }
                    System.out.println(">> LPaDOS: Durante el salto hemos descubierto otros " + (planetasCrear-1) + " Planetas aparte.");
                }
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

    /*
    ***
    Parametro 1 : float hidrogeno
    ***
    Tipo de Retorno : None
    ***
    Método que establece la cantidad de combustible en la nave a partir de la cantidad de hidrógeno suministrada.
    Calcula las unidades recargadas teniendo en cuenta la eficiencia del propulsor. Si la cantidad de combustible
    supera el límite máximo de 100.0f, emite una advertencia y ajusta el valor a 100.0f.
    */
    public void setUnidadesCombustible(float hidrogeno) {
        float unidadesRecargadas = 0.6f * hidrogeno * (1 + eficienciaPropulsor);
        this.unidadesCombustible += unidadesRecargadas;
        if (this.unidadesCombustible > 100.0f){
            System.out.println(">> LPaDOS: Hemos procesado más hidrogeno en combustible del que podemos" +
                    "almacenar, tendremos que verter el exceso....");
            this.unidadesCombustible = 100.0f;
        }
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : None
    ***
    Método que restablece la cantidad de combustible de la nave a su máximo, estableciendo 'unidadesCombustible' en 100.0f.
    */
    public void resetCombustible(){
        this.unidadesCombustible = 100.0f;
    }

    /*
    ***
    Parametro 1 : float eficiencia
    ***
    Tipo de Retorno : None
    ***
    Método que ajusta la eficiencia del propulsor de la nave, sumando el valor proporcionado a la eficiencia actual.
    Emite un mensaje indicando el porcentaje de mejora en la eficiencia del propulsor.
    */
    public void setEficienciaPropulsor(float eficiencia) {
        this.eficienciaPropulsor += eficiencia;
        System.out.println(">> LPaDOS: Se ha mejorado la eficiencia del propulsor en un " + (int)eficiencia*100 + "%.");
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : float
    ***
    Método que retorna el valor actual de la eficiencia del propulsor de la nave.
    */
    public float getEficienciaPropulsor () {
        return this.eficienciaPropulsor;
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : float
    ***
    Método que retorna la cantidad actual de unidades de combustible disponibles en la nave.
    */
    public float getUnidadesCombustible () {
        return  this.unidadesCombustible;
    }
}