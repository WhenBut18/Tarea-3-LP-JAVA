package Planetas;
import Player.Jugador;

import javax.swing.*;
import java.util.Scanner;

public class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private float consumoEnergia;
    public boolean visitar(Jugador jugador) {
        printeador();
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: ¿Quieres aterrizar en este Planeta? (Si/No)" );
        String Eleccion = obj.nextLine();
        if (Eleccion.equals("Si")){
            System.out.println(">> LPaDOS: Entrando al planeta, finalizando el protocolo de aterrizaje." + "\n>> LPaDOS: " +
                    "Aterrizaje completado.");
            return true;
        } else {
            System.out.println((">> LPaDOS: Cancelando el protocolo de aterrizaje, nos mantenemos en la orbita"));
            return false;
        }
    }

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
                System.out.println(">> LPaDOS: Se han extraido " + Eleccion + " unidades de Hidrogeno.");
                this.cristalesHidrogeno -= Eleccion;
                return Eleccion;
            }
        } else if (tipo == 2) {
            if (Eleccion > this.floresDeSodio) {
                System.out.println(">> LPaDOS: No puedes extraer más recursos de los que tiene el planeta, cancelando" +
                        " protocolo de extraccion");
                return -1;
            } else {
                System.out.println(">> LPaDOS: Se han extraido " + Eleccion + " unidades de Flores de Sodio.");
                this.cristalesHidrogeno -= Eleccion;
                return Eleccion;
            }
        } else {
            return Eleccion;
        }
    }
    public boolean salir() {
        System.out.println(">> LPaDOS: Preparando protocolo de vuelo orbital.\n>> LPaDOS: Despegando....\n>> " +
                "LPaDOS: Finalizando protocolo de vuelo orbital.\n>> LPaDOS: Hemos vuelto a la orbita del Planeta.");
        return true;
    }
    public Planeta(int supRadio, int infRadio, float ratioFloresDeSodio, float ratioHidrogeno) {
        this.radio = (int)Math.floor(Math.random() * ((Math.pow(10,supRadio) - Math.pow(10,infRadio)) + 1) + Math.pow(10,infRadio));
        this.floresDeSodio = (int)Math.floor(ratioFloresDeSodio * (4 * Math.PI * Math.pow(this.radio,2)));
        this.cristalesHidrogeno = (int)Math.floor(ratioHidrogeno * (4 * Math.PI * Math.pow(this.radio,2)));
    }
    public void printeador() {
        System.out.println(">> LPaDOS: Desplegando datos del Planeta...\n>>    Radio: " + this.radio + "\n>>    Cristales de " +
                "Hidrogeno: " + this.cristalesHidrogeno + "\n>>    Flores de Sodio: " + this.floresDeSodio);
    }
    public int getRadio(){
        return this.radio;
    }

    public int getCristalesHidrogeno() {
        return this.cristalesHidrogeno;
    }
    public int getFloresDeSodio(){
        return  this.floresDeSodio;
    }

    public void setConsumoEnergia(float consumoEnergia){
        this.consumoEnergia = consumoEnergia;
    }
    public void setCristalesHidrogeno(int cristalesHidrogeno){
        this.cristalesHidrogeno -= cristalesHidrogeno;
    }
    public void setFloresDeSodio(int floresDeSodio){
        this.floresDeSodio = floresDeSodio;
    }
}
