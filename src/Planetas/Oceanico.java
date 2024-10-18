package Planetas;

import Player.Jugador;

import java.util.Scanner;

public class Oceanico extends Planeta implements tieneAsentamientos{
    private int profundidad;
    public  Oceanico(){
        super(4,6,0.65f,0.2f);
        this.profundidad = (int)Math.floor(Math.random() * ((Math.pow(10,3) - 30) + 1) + 30);
        setConsumoEnergia(0.002f * (float)Math.pow(this.profundidad,2));
    }

    @Override
    public void printeador() {
        System.out.println(">> LPaDOS: Preparando el protocolo de aterrizaje para Planeta Oceanico");
        super.printeador();
        System.out.println("║>>    Profundidad: " + this.profundidad);
    }
    public int getProfundidad(){
        return this.profundidad;
    }

    @Override
    public void visitarAsentamientos(Jugador jugador) {
        int nivelActual = ((int)jugador.getNaveJugador().getEficienciaPropulsor()*10);
        int costoMejora = (int)(2500 * Math.pow(2,nivelActual));
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: He encontrado una ciudad de Pythonianos, vamos al mercado local para comer" +
                "ciar con los nativos.\n>> LPaDOS: Segun mis fuentes de Javapedia los Pythonianos se especializan" +
                " en la venta y mejora de motores de propulsion, quizas podamos mejorar nuestra nave ahi.\n>>" +
                " Pythoniano: (a|b)aab(c^*)b?\n>> LPaDOS: Activando protocolo de traduccion.... REGEX--> Espanol\n" +
                "Pythoniano: Wena forastero, vo' que querer mejorah' nae tuya???\n>> Pythoniano: Yo vender mejorah'\n" +
                " de nae'\n>>    Mejora de propulsor MK"+ nivelActual + " ---> MK" + (nivelActual+1) + ".\n>>    " +
                "Costo: " + costoMejora + " unidades de Uranio\n>>    ¿Quieres comprarlo?\n>>    (1) Si\n>>    (2) No");
        int Eleccion = obj.nextInt();
        if (Eleccion == 1){
            if (jugador.getAlmacenadoUranio() < costoMejora) {
                System.out.println(">> LPaDOS: No contamos con suficiente Uranio");
            } else {
                System.out.println(">> Pythoniano: Un guto' hace' negocio con ute'.\n>> LPaDOS: Hemos mejorado nuest" +
                        "ro propusor a nivel MK" + (nivelActual + 1) + ".");
                jugador.getNaveJugador().setEficienciaPropulsor(0.1f);
            }
            System.out.println(">> LPaDOS: Regresemos a la Nave.");
        } else {
            System.out.println(">> Pythoniano: Vuelva prompt-to.\n>> LPaDOS: Volvamos a la Nave y continuar nuestra" +
                    " exploracion");
        }
    }
}
