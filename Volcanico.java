public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;

    /*
    ***
    Ninguno
    ***
    Volcanico
    ***
    Este constructor inicializa un objeto de tipo Volcánico, llamando al constructor de
    la clase padre con parámetros específicos. Asigna un valor aleatorio a la temperatura
    dentro del rango de 120 a 256 grados y calcula la cantidad de platino como un porcentaje
    del área de la esfera del planeta. También establece el consumo de energía basado en la
    temperatura calculada.
    */
     public Volcanico() {
        super(3,5,0f,0.3f);
        this.temperatura = (int) Math.floor(Math.random() * 137 + 120);
        this.platino = (int)Math.floor(0.25 * (4 * Math.PI * Math.pow(getRadio(),2)));
        setConsumoEnergia(0.08f * this.temperatura);
    }

    /*
    ***
    Ninguno
    ***
    void
    ***
    Esta función sobrescribe el metodo printeador en específico para el Planeta Volcánico.
    Imprime un mensaje de preparación, llama al metodo printeador de la clase padre y
    muestra la cantidad de platino y la temperatura del planeta.
    */
    @Override
    public void printeador() {
        System.out.println(">> LPaDOS: Preparando el protocolo de aterrizaje para Planeta Volcanico");
        super.printeador();
        System.out.println("║>>    Platino: " + this.platino + "\n║>>    Temperatura: " + this.temperatura);
    }

    /*
    ***
    tipo : int
    ***
    int
    ***
    Esta función sobrescribe el metodo eextraerRecursose para gestionar la extracción de recursos
    específicos. Si el tipo es 1 o 2, llama al metodo de la clase padre y devuelve la elección.
    Para el tipo 3, verifica si la cantidad a extraer de platino es mayor que la disponible; si
    es así, cancela la extracción y devuelve -1. En caso contrario, devuelve la cantidad extraída.
    Si el tipo no es válido, devuelve -1.
    */
    @Override
    public int extraerRecursos(int tipo) {
        int Eleccion = super.extraerRecursos(tipo);
        if (tipo == 1 || tipo == 2){
            return Eleccion;
        }
        if (tipo == 3) {
            if (Eleccion > this.platino) {
                System.out.println(">> LPaDOS: No puedes extraer más recursos de los que tiene el planeta, cancelando" +
                        " protocolo de extraccion");
                return -1;
            } else {
                return Eleccion;
            }
        } else {
            return -1;
        }
    }

    /*
    ***
    platino : int
    ***
    void
    ***
    Esta función añade una cantidad específica de platino al total actual.
    Permite modificar la propiedad platino incrementando su valor.
    */
    public void setPlatino(int platino) {
        this.platino += platino;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual de la temperatura del planeta.
    Permite acceder a la propiedad temperatura desde fuera de la clase.
    */
    public int getTemperatura(){
        return this.temperatura;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual del platino disponible.
    Permite acceder a la propiedad platino desde fuera de la clase.
    */
    public int getPlatino(){
        return this.platino;
    }
}

