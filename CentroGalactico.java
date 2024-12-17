import java.util.Scanner;

public class CentroGalactico extends Planeta {

    /*
    ***
    Ninguno
    ***
    CentroGalactico
    ***
    Este constructor inicializa un objeto de tipo CentroGaláctico, llamando al
    constructor de la clase padre con valores cero. Imprime un mensaje indicando que
    el centro galáctico ha sido localizado.
    */
    public CentroGalactico(){
        super(0,0,0,0);
        System.out.println(">> LPaDOS: CENTRO GALACTIGO LOCALIZADO");
    }

    /*
    ***
    jugador : Jugador
    ***
    boolean
    ***
    Esta función permite al jugador decidir si quiere entrar al Centro Galáctico.
    Verifica si el jugador tiene al menos un propulsor MK5 con 50% de eficiencia.
    Si elige entrar y cumple con el requisito, se imprime un mensaje de victoria y se
    devuelven las estadísticas finales; de lo contrario, se indica que no cumple
    los requisitos o se cancela la acción.
    '''
     */
    @Override
    public boolean visitar(Jugador jugador) {
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: Estamos en la orbita del Centro Galactico, la meta de la " +
                "STEEL SPACE RUN.\n>> LPaDOS: Debes tenemos minimo un Propulsor MK5 (50% de Efici" +
                "encia)\n>> LPaDOS: ¿Quieres entrar al Centro Galactico?\n>>    (1) Si\n>>    (2) No" );
        int Eleccion = obj.nextInt();
        if (Eleccion == 1){
            if (jugador.getNaveJugador().getEficienciaPropulsor() >= 0.5f){
                System.out.println(">> FELICIDADES HAS GANADO LA STEEL SPACE RUN" +
                        "\n Desplegando Estadisticas Finales");
                jugador.printeador();
                return true;
            } else {
                System.out.println(">> LPaDOS: No cuentas con el propulsor MK5 minimo (50% de Eficiencia)");
                return false;
            }
        } else {
            System.out.println(">> LPaDOS: Cancelando el protocolo de aterrizaje, nos mantenemos en la orbita");
            return false;
        }
    }
}
