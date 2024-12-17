public class Radiactivo extends Planeta {
    private int uranio;
    private int radiacion;

    /*
    ***
    Ninguno
    ***
    Radiactivo
    ***
    Este constructor inicializa un objeto de tipo Radiactivo, llamando al constructor de
    la clase padre con parámetros específicos. Asigna un valor aleatorio a la radiación
    dentro del rango de 10 a 50 y calcula la cantidad de uranio como un porcentaje del área
    de la esfera del planeta. También establece el consumo de energía basado en la radiación
    calculada.
    */
    public Radiactivo(){
        super(4,5,0.2f,0.2f);
        this.radiacion = (int)Math.floor(Math.random() * ((50 - 10) + 1) + 10);
        this.uranio = (int)Math.floor(0.25 * (4 * Math.PI * Math.pow(getRadio(),2)));
        setConsumoEnergia(0.3f * this.radiacion);
    }

    /*
    ***
    Ninguno
    ***
    void
    ***
    Esta función sobrescribe el metodo printeador para el Planeta Radiactivo. Imprime un
    mensaje de preparación, llama al metodo printeador de la clase padre y muestra la
    cantidad de uranio y radiación del planeta.
    */
    @Override
    public void printeador() {
        System.out.println(">> LPaDOS: Preparando el protocolo de aterrizaje para Planeta Radiactivo");
        super.printeador();
        System.out.println("║>>    Uranio: " + this.uranio + "\n║>>    Radiacion: " + this.radiacion);
    }

    /*
    ***
    tipo : int
    ***
    int
    ***
    Esta función sobrescribe el metodo extraerRecursos para permitir la extracción de recursos
    específicos. Si el tipo es 1 o 2, llama al metodo de la clase padre y devuelve la elección.
    Para el tipo 3, verifica si la cantidad a extraer de uranio es mayor que la disponible;
    si es así, cancela la extracción y devuelve -1. En caso contrario, devuelve la cantidad extraída.
    Si el tipo no es válido, devuelve -1.
    */
    @Override
    public int extraerRecursos(int tipo) {
        int Eleccion = super.extraerRecursos(tipo);
        if (tipo == 1 || tipo == 2){
            return Eleccion;
        }
        if (tipo == 3) {
            if (Eleccion > this.uranio) {
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
    uranio : int
    ***
    void
    ***
    Esta función añade una cantidad específica de uranio al total actual del planeta.
    Permite modificar la propiedad uranio incrementando su valor.
    */
    public void setUranio(int uranio){
        this.uranio += uranio;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual del uranio disponible en el planeta.
    Permite acceder a la propiedad uranio desde fuera de la clase.
    */
    public int getUranio(){
        return this.uranio;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual de la radiación del planeta.
    Permite acceder a la propiedad radiacion desde fuera de la clase.
    */
    public  int getRadiacion(){
        return  this.radiacion;
    }
}
