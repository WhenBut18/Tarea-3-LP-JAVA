import java.util.Scanner;

public class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private float consumoEnergia;

    /*
    ***
    supRadio : int
    infRadio : int
    ratioFloresDeSodio : float
    ratioHidrogeno : float
    ***
    Planeta
    ***
    Este constructor inicializa un objeto de tipo Planeta con un radio aleatorio
    dentro de un rango definido por supRadio e infRadio. Calcula la cantidad
    de flores de sodio y cristales de hidrógeno basándose en los ratios proporcionados,
    utilizando la fórmula para el área de una esfera. El consumo de energía se inicializa en 0.
    */
    public Planeta(int supRadio, int infRadio, float ratioFloresDeSodio, float ratioHidrogeno) {
        this.radio = (int)Math.floor(Math.random() * ((Math.pow(10,supRadio) - Math.pow(10,infRadio)) + 1) + Math.pow(10,infRadio));
        this.floresDeSodio = (int)Math.floor(ratioFloresDeSodio * (4 * Math.PI * Math.pow(this.radio,2)));
        this.cristalesHidrogeno = (int)Math.floor(ratioHidrogeno * (4 * Math.PI * Math.pow(this.radio,2)));
        this.consumoEnergia = 0;
    }

    /*
    ***
    jugador : Jugador
    ***
    boolean
    ***
    Esta función permite al jugador decidir si quiere aterrizar en el planeta actual.
    Imprime información sobre el planeta y presenta una opción al jugador para aterrizar
    o permanecer en órbita. Devuelve false si el jugador decide aterrizar y true si
    decide no hacerlo.
    */
    public boolean visitar(Jugador jugador) {
        printeador();
        System.out.println("╚═════════════════════════════════════════╛");
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: ¿Quieres aterrizar en este Planeta?\n>>    (1) Si\n>>    (2) No" );
        int Eleccion = obj.nextInt();
        if (Eleccion == 1){
            System.out.println(">> LPaDOS: Entrando al planeta, finalizando el protocolo de aterrizaje." + "\n>> LPaDOS: " +
                    "Aterrizaje completado.");
            return false;
        } else {
            System.out.println((">> LPaDOS: Cancelando el protocolo de aterrizaje, nos mantenemos en la orbita"));
            return true;
        }
    }

    /*
    ***
    tipo : int
    ***
    int
    ***
    Esta función permite al jugador extraer recursos del planeta. Pide al jugador que
    especifique cuántas unidades desea extraer. Verifica si la cantidad solicitada es
    menor o igual a la cantidad disponible para el tipo de recurso especificado (hidrógeno
    o flores de sodio). Si la cantidad es excesiva, se cancela la extracción y se devuelve
    -1. De lo contrario, devuelve la cantidad extraída.
    */
    public int extraerRecursos(int tipo) {
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: ¿Cuantas unidades quieres extraer?");
        int Eleccion = obj.nextInt();
        if (tipo == 1) {
            if (Eleccion > this.cristalesHidrogeno) {
                System.out.println(">> LPaDOS: No puedes extraer más recursos de los que tiene el planeta, cancelando" +
                        " protocolo de extraccion");
                return -1;
            } else {
                return Eleccion;
            }
        } else if (tipo == 2) {
            if (Eleccion > this.floresDeSodio) {
                System.out.println(">> LPaDOS: No puedes extraer más recursos de los que tiene el planeta, cancelando" +
                        " protocolo de extraccion");
                return -1;
            } else {
                return Eleccion;
            }
        } else {
            return Eleccion;
        }
    }

    /*
    ***
    Ninguno
    ***
    boolean
    ***
    Esta función es el protocolo de salida del planeta y el regreso a la órbita.
    Imprime mensajes informativos sobre el despegue y la finalización del vuelo orbital.
    Devuelve true para indicar que el proceso se completó exitosamente.
    */
    public boolean salir() {
        System.out.println(">> LPaDOS: Preparando protocolo de vuelo orbital.\n>> LPaDOS: Despegando....\n>> " +
                "LPaDOS: Finalizando protocolo de vuelo orbital.\n>> LPaDOS: Hemos vuelto a la orbita del Planeta.");
        return true;
    }

    /*
    ***
    Ninguno
    ***
    void
    ***
    Esta función imprime en consola los datos del planeta, incluyendo el radio,
    la cantidad de cristales de hidrógeno y flores de sodio.
    */
    public void printeador() {
        System.out.println("╔═════════════════════════════════════════╕" +
                "\n║>> LPaDOS: Desplegando datos del Planeta...\n║>>    Radio: " + this.radio + "\n║>>    Cristales de " +
                "Hidrogeno: " + this.cristalesHidrogeno + "\n║>>    Flores de Sodio: " + this.floresDeSodio);
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual del radio del planeta.
    Permite acceder a la propiedad radio desde fuera de la clase.
    */
    public int getRadio(){
        return this.radio;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual de los cristales de hidrógeno del planeta.
    Permite acceder a la propiedad cristalesHidrogeno desde fuera de la clase.
    */
    public int getCristalesHidrogeno() {
        return this.cristalesHidrogeno;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual de las flores de sodio del planeta.
    Permite acceder a la propiedad floresDeSodio desde fuera de la clase.
    */
    public int getFloresDeSodio(){
        return  this.floresDeSodio;
    }

    /*
    ***
    consumoEnergia : float
    ***
    void
    ***
    Esta función establece el valor del consumo de energía del planeta.
    Permite modificar la propiedad consumoEnergia desde fuera de la clase.
    */
    public void setConsumoEnergia(float consumoEnergia){
        this.consumoEnergia = consumoEnergia;
    }

    /*
    ***
    cristalesHidrogeno : int
    ***
    void
    ***
    Esta función añade una cantidad específica de cristales de hidrógeno al total actual
    del planeta. Permite modificar la propiedad cristalesHidrogeno incrementando su valor.
    */
    public void setCristalesHidrogeno(int cristalesHidrogeno){
        this.cristalesHidrogeno += cristalesHidrogeno;
    }

    /*
    ***
    floresDeSodio : int
    ***
    void
    ***
    Esta función añade una cantidad específica de flores de sodio al total actual
    del planeta. Permite modificar la propiedad floresDeSodio incrementando su valor.
    */
    public void setFloresDeSodio(int floresDeSodio){
        this.floresDeSodio += floresDeSodio;
    }

    /*
    ***
    Ninguno
    ***
    float
    ***
    Esta función devuelve el valor actual del consumo de energía del planeta.
    Permite acceder a la propiedad consumoEnergia desde fuera de la clase.
    */
    public float getConsumoEnergia(){
        return this.consumoEnergia;
    }
}
