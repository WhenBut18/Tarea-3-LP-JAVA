

import java.util.Scanner;

public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private int almacenadoHidrogeno;
    private int almacenadoSodio;
    private int almacenadoUranio;
    private int almacenadoPlatino;
    private Nave naveJugador;

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : None
    ***
    Constructor de la clase Jugador que inicializa las propiedades del jugador. Establece 'unidadesEnergiaProteccion'
    en 100.0f, 'eficienciaEnergiaProteccion' en 0.0f y inicializa las cantidades de materiales almacenados
    (sodio, hidrógeno, platino y uranio) en 0. También crea una nueva instancia de la clase Nave para el jugador.
    */
    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.almacenadoSodio = 0;
        this.almacenadoHidrogeno = 0;
        this.almacenadoPlatino = 0;
        this.almacenadoUranio = 0;
        naveJugador = new Nave();
    }

    /*
    ***
    Parametro 1 : int sodio
    ***
    Tipo de Retorno : None
    ***
    Método que recarga la energía de protección del jugador utilizando la cantidad de sodio suministrada.
    Calcula el aumento de energía multiplicando el sodio por 0.65f y ajustando según la eficiencia de energía
    de protección actual.
    */
    public void recargarEnergiaProteccion(int sodio) {
        this.unidadesEnergiaProteccion += 0.65f * sodio * (1 + eficienciaEnergiaProteccion);
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : float
    ***
    Método que retorna el valor actual de la eficiencia de energía de protección del jugador.
    */
    public float getEficienciaEnergiaProteccion() {
        return this.eficienciaEnergiaProteccion;
    }

    /*
    ***
    Parametro 1 : int Hidrogeno
    ***
    Tipo de Retorno : None
    ***
    Método que actualiza la cantidad de hidrógeno almacenado del jugador, sumando la cantidad proporcionada al
    almacenamiento actual de hidrógeno.
    */
    public void setAlmacenadoHidrogeno(int Hidrogeno) {
        this.almacenadoHidrogeno += Hidrogeno;
    }

    /*
    ***
    Parametro 1 : int Sodio
    ***
    Tipo de Retorno : None
    ***
    Método que actualiza la cantidad de sodio almacenado del jugador, sumando la cantidad proporcionada al
    almacenamiento actual de sodio.
    */
    public void setAlmacenadoSodio(int Sodio) {
        this.almacenadoSodio += Sodio;
    }

    /*
    ***
    Parametro 1 : int Platino
    ***
    Tipo de Retorno : None
    ***
    Método que actualiza la cantidad de platino almacenado del jugador, sumando la cantidad proporcionada al
    almacenamiento actual de platino.
    */
    public void setAlmacenadoPlatino(int Platino) {
        this.almacenadoPlatino += Platino;
    }

    /*
    ***
    Parametro 1 : int Uranio
    ***
    Tipo de Retorno : None
    ***
    Método que actualiza la cantidad de uranio almacenado del jugador, sumando la cantidad proporcionada al
    almacenamiento actual de uranio.
    */
    public void setAlmacenadoUranio(int Uranio) {
        this.almacenadoUranio += Uranio;
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : int
    ***
    Método que retorna la cantidad actual de hidrógeno almacenado por el jugador.
    */
    public int getAlmacenadoHidrogeno() {
        return this.almacenadoHidrogeno;
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : int
    ***
    Método que retorna la cantidad actual de sodio almacenado por el jugador.
    */
    public int getAlmacenadoSodio() {
        return this.almacenadoSodio;
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : int
    ***
    Método que retorna la cantidad actual de platino almacenado por el jugador.
    */
    public int getAlmacenadoPlatino() {
        return this.almacenadoPlatino;
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : Nave
    ***
    Método que retorna la instancia de la nave del jugador.
    */
    public int getAlmacenadoUranio() {
        return this.almacenadoUranio;
    }

    /*

    */
    public Nave getNaveJugador() {
        return this.naveJugador;
    }

    /*
    ***
    Parametro 1 : float unidadesEnergiaProteccion
    ***
    Tipo de Retorno : None
    ***
    Método que actualiza la cantidad de unidades de energía de protección del jugador, sumando el valor proporcionado
    a la cantidad actual de energía de protección.
    */
    public void setUnidadesEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion += unidadesEnergiaProteccion;
    }

    /*
    ***
    Parametro 1 : float eficienciaEnergiaProteccion
    ***
    Tipo de Retorno : None
    ***
    Método que ajusta la eficiencia de energía de protección del jugador, sumando el valor proporcionado a la
    eficiencia actual. Emite un mensaje indicando el porcentaje de mejora en la eficiencia de energía de protección.
    */
    public void setEficienciaEnergiaProteccion(float eficienciaEnergiaProteccion){
        this.eficienciaEnergiaProteccion += eficienciaEnergiaProteccion;
        System.out.println(">> LPaDOS: Se ha mejorado la eficiencia del propulsor en un " +
                (int)this.eficienciaEnergiaProteccion*100 + "%.");
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : float
    ***
    Método que retorna la cantidad actual de unidades de energía de protección del jugador.
    */
    public float getUnidadesEnergiaProteccion (){
        return this.unidadesEnergiaProteccion;
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : None
    ***
    Método que imprime en consola un resumen de los datos actuales del jugador, incluyendo la energía de protección,
    la eficiencia de protección, la cantidad de combustible, la eficiencia del propulsor y los recursos almacenados
    (hidrógeno, sodio, uranio y platino). Los datos se presentan en un formato visualmente estructurado.
    */
    public void printeador(){
        System.out.println("╔═════════════════════════════════════════╕" +
                         "\n║>> LPaDOS: Desplegando datos actuales:   " +
                         "\n║>>    Energia de Proteccion: " + this.unidadesEnergiaProteccion + "." +
                         "\n║>>    Eficiencia de Proteccion: " + (int)this.eficienciaEnergiaProteccion*100 + "%." +
                         "\n║>>    Combustible: " + naveJugador.getUnidadesCombustible() + "." +
                         "\n║>>    Eficiencia del Propulsor: " + (int)naveJugador.getEficienciaPropulsor()*100 + "%." +
                         "\n║>>    Hidrogeno: " + this.almacenadoHidrogeno +
                         "\n║>>    Sodio: " + this.almacenadoSodio + "." +
                         "\n║>>    Uranio: " + this.almacenadoUranio + "." +
                         "\n║>>    Platino: " + this.almacenadoPlatino + "." +
                         "\n╚═════════════════════════════════════════╛");
    }

    /*
    ***
    Parametro 1 : MapaGalactico mapaGalactico
    ***
    Tipo de Retorno : None
    ***
    Método que gestiona el estado de "game over" del jugador. Invierte la posición en el mapa galáctico, restablece
    los recursos almacenados (hidrógeno, sodio, platino y uranio) a cero, recupera la energía de protección
    a su máximo (100.0f) y restablece el combustible de la nave del jugador.
    */
    public void gameover(MapaGalactico mapaGalactico){
        mapaGalactico.setPosicion(-mapaGalactico.getPosicion());
        setAlmacenadoHidrogeno(-getAlmacenadoHidrogeno());
        setAlmacenadoSodio(-getAlmacenadoSodio());
        setAlmacenadoPlatino(-getAlmacenadoPlatino());
        setAlmacenadoUranio(-getAlmacenadoUranio());
        setUnidadesEnergiaProteccion(-getUnidadesEnergiaProteccion() + 100.0f);
        getNaveJugador().resetCombustible();
    }

    /*
    ***
    Parametro 1 : int recursos
    Parametro 2 : Planeta planeta
    ***
    Tipo de Retorno : boolean
    ***
    Método que calcula el consumo de energía de protección al extraer recursos de un planeta. Solicita al usuario
    confirmar la extracción y muestra el consumo estimado de energía. Si el usuario acepta, se deduce el consumo
    de energía y se verifica si la energía se ha agotado, activando un protocolo de rescate si es necesario.
    Retorna true si se procede con la extracción y false si se cancela.
    */
    public boolean consumirEnergiaProteccion(int recursos, Planeta planeta){
        Scanner obj = new Scanner(System.in);
        float consumoActual = 0.5f * recursos * (planeta.getConsumoEnergia()/100) * (1 - this.eficienciaEnergiaProteccion);
        System.out.println(">> LPaDOS: Extraer los recursos consumira " + consumoActual + " unidades de Energia de P" +
                "roteccion. ¿Quieres extraerlo" +
                "s?\n>>    (1) Si\n>>    (2) No");
        int Eleccion = obj.nextInt();
        if (Eleccion == 1){
            unidadesEnergiaProteccion += -consumoActual;
            if (unidadesEnergiaProteccion <= 0) {
                System.out.println(">> LPaDOS: ALERTA, ENERGIA AGOTADA EN EL EXOTRAJE, ACTIVANDO PROTOCOLO DE RESCATE");
            }
            return true;
        } else {
            System.out.println(">> LPaDOS: Cancelando protocolo de extraccion");
            return false;
        }
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : None
    ***
    Método que permite al jugador recargar su energía de protección utilizando sodio almacenado. Solicita al usuario la
    cantidad de sodio que desea usar y verifica si tiene suficiente. Si la cantidad es válida, se recarga la energía
    de protección y se deduce la cantidad utilizada del almacenamiento de sodio del jugador.
    */
    public void recargarEnergia (){
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: ¿Cuanto Sodio quieres usar? (Digite el numero)");
        int Eleccion2 = obj.nextInt();
        if (Eleccion2 > almacenadoSodio){
            System.out.println(">> LPaDOS: Cantidad invalida, no cuentas con tanto Sodio");
        } else {
            recargarEnergiaProteccion(Eleccion2);
            almacenadoSodio -= Eleccion2;
        }
    }

    /*
    ***
    Parametro 1 : Ninguno
    ***
    Tipo de Retorno : None
    ***
    Método que permite al jugador recargar combustible utilizando hidrógeno almacenado. Solicita al usuario la cantidad
    de hidrógeno que desea usar y verifica si tiene suficiente. Si la cantidad es válida, se recarga el combustible
    de la nave y se deduce la cantidad utilizada del almacenamiento de hidrógeno del jugador.
    */
    public void recargarCombustible () {
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: ¿Cuanto Hidrogeno quieres usar? (Digite el numero)");
        int Eleccion2 = obj.nextInt();
        if (Eleccion2 > almacenadoHidrogeno){
            System.out.println(">> LPaDOS: Cantidad invalida, no cuentas con tanto Hidrogeno");
        } else {
            getNaveJugador().setUnidadesCombustible(Eleccion2);
            almacenadoHidrogeno -= Eleccion2;
        }
    }
}
