package Planetas;
import Player.Jugador;

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
        int recurso;
        Scanner obj = new Scanner(System.in);
        System.out.println(">> LPaDOS: ¿Cuantas unidades quieres extraer?");
        String Eleccion = obj.nextLine();
        return  0;
    }
    public boolean salir() {
        return true;
    }
    public Planeta(int supRadio, int infRadio, float ratioFloresDeSodio, float ratioHidrogeno) {
        this.radio = (int)Math.floor(Math.random() * ((Math.pow(10,supRadio) - Math.pow(10,infRadio)) + 1) + Math.pow(10,infRadio));
        this.floresDeSodio = (int)Math.floor(ratioFloresDeSodio * (4 * Math.PI * Math.pow(this.radio,2)));
        this.cristalesHidrogeno = (int)Math.floor(ratioHidrogeno * (4 * Math.PI * Math.pow(this.radio,2)));
    }
    public void printeador() {
        System.out.println(">> LPaDOS: Desplegando datos del Planeta...\n>> Radio: " + this.radio + "\n>> Cristales de " +
                "Hidrogeno: " + this.cristalesHidrogeno + "\n>> Flores de Sodio: " + this.floresDeSodio);
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
    public void  setFloresDeSodio(int floresDeSodio){
        this.floresDeSodio = floresDeSodio;
    }
}
