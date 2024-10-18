package Player;

import Planetas.MapaGalactico;
import Planetas.Planeta;

import java.util.Scanner;

public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private int almacenadoHidrogeno;
    private int almacenadoSodio;
    private int almacenadoUranio;
    private int almacenadoPlatino;
    private Nave naveJugador;
    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.almacenadoSodio = 0;
        this.almacenadoHidrogeno = 0;
        this.almacenadoPlatino = 0;
        this.almacenadoUranio = 0;
        naveJugador = new Nave();
    }
    public void recargarEnergiaProteccion(int sodio) {
        this.unidadesEnergiaProteccion += 0.65f * sodio * (1 + eficienciaEnergiaProteccion);
    }
    public float getEficienciaEnergiaProteccion() {
        return this.eficienciaEnergiaProteccion;
    }
    public void setAlmacenadoHidrogeno(int Hidrogeno) {
        this.almacenadoHidrogeno += Hidrogeno;
    }
    public void setAlmacenadoSodio(int Sodio) {
        this.almacenadoSodio += Sodio;
    }
    public void setAlmacenadoPlatino(int Platino) {
        this.almacenadoPlatino += Platino;
    }
    public void setAlmacenadoUranio(int Uranio) {
        this.almacenadoUranio += Uranio;
    }
    public int getAlmacenadoHidrogeno() {
        return this.almacenadoHidrogeno;
    }
    public int getAlmacenadoSodio() {
        return this.almacenadoSodio;
    }
    public int getAlmacenadoPlatino() {
        return this.almacenadoPlatino;
    }
    public int getAlmacenadoUranio() {
        return this.almacenadoUranio;
    }
    public Nave getNaveJugador() {
        return this.naveJugador;
    }
    public void setUnidadesEnergiaProteccion(float unidadesEnergiaProteccion){
        this.unidadesEnergiaProteccion += unidadesEnergiaProteccion;
    }
    public void setEficienciaEnergiaProteccion(float eficienciaEnergiaProteccion){
        this.eficienciaEnergiaProteccion += eficienciaEnergiaProteccion;
        System.out.println(">> LPaDOS: Se ha mejorado la eficiencia del propulsor en un " +
                (int)this.eficienciaEnergiaProteccion*100 + "%.");
    }
    public float getUnidadesEnergiaProteccion (){
        return this.unidadesEnergiaProteccion;
    }
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
    public void gameover(MapaGalactico mapaGalactico){
        mapaGalactico.setPosicion(-mapaGalactico.getPosicion());
        setAlmacenadoHidrogeno(-getAlmacenadoHidrogeno());
        setAlmacenadoSodio(-getAlmacenadoSodio());
        setAlmacenadoPlatino(-getAlmacenadoPlatino());
        setAlmacenadoUranio(-getAlmacenadoUranio());
        setUnidadesEnergiaProteccion(-getUnidadesEnergiaProteccion() + 100.0f);
        getNaveJugador().setUnidadesCombustible(-getNaveJugador().getUnidadesCombustible() + 100.0f);
    }
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
