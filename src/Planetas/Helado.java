package Planetas;

import Player.Jugador;

import java.util.Scanner;

public class Helado extends Planeta implements tieneAsentamientos{
    private int temperatura;
    public Helado() {
        super(3,6,0.35f,0.65f);
        this.temperatura = (int) Math.floor(-(Math.random() * 91 + 30));
        setConsumoEnergia(0.15f * Math.abs(this.temperatura));
    }

    @Override
    public void printeador() {
        System.out.println(">> LPaDOS: Preparando el protocolo de aterrizaje para Planeta Helado");
        super.printeador();
        System.out.println("║>>    Temperatura: " + this.temperatura);
    }
    public int getTemperatura(){
        return this.temperatura;
    }

    @Override
    public void visitarAsentamientos(Jugador jugador) {
        int nivelActual = ((int)jugador.getEficienciaEnergiaProteccion()*10);
        int costoMejora = (int)(3120 * Math.pow(2,nivelActual));
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: He encontrado una ciudad de Cnianos, vamos al mercado local para comer" +
                "ciar con los nativos.\n>> LPaDOS: Segun mis fuentes de Javapedia los Cnianos se especializan" +
                " en la venta y mejora de proteccion de exotrajes, quizas podamos mejorar el nuestro ahi.\n>>" +
                " Cniano: new Dialogo() Dialogo.hablar() \n>> LPaDOS: Activando protocolo de traduccion.... Segmen" +
                "tationFault --> Espanol\n>> Cniano: Que onda chavon, vos querés mejorar tu exotraje?\n>> " +
                "Cniano: Sho lo puedo hacer por vos\n>>    Mejora de exotraje MK"+ nivelActual + " ---> MK" + (nivelActual+1) + ".\n>>    " +
                "Costo: " + costoMejora + " unidades de Platino\n>>  ¿Quieres comprarlo? (Si/No)");
        int Eleccion = obj.nextInt();
        if (Eleccion == 1){
            if (jugador.getAlmacenadoPlatino() < costoMejora){
                System.out.println(">> LPaDOS: No contamos con suficiente Platino");
            } else {
                System.out.println(">> Cniano: Un gustazo hacer negocios con vos maestro.\n>> LPaDOS: Hemos mejorado nuest" +
                        "ro extraje a nivel MK" + (nivelActual + 1) + ".");
                jugador.setEficienciaEnergiaProteccion(0.1f);
            }
            System.out.println(">> LPaDOS: Regresemos a la Nave.");
        } else {
            System.out.println(">> Cniano: Volve prompt-to.\n>> LPaDOS: Volvamos a la Nave y continuar nuestra" +
                    " exploracion");
        }
    }
}