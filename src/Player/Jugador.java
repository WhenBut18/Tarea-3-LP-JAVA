package Player;

public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private int almacenadoHidrogeno;
    private int almacenadoSodio;
    private Nave naveJugador;
    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.almacenadoSodio = 0;
        this.almacenadoHidrogeno = 0;
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
    public int getAlmacenadoHidrogeno() {
        return this.almacenadoHidrogeno;
    }
    public int getAlmacenadoSodio() {
        return this.almacenadoSodio;
    }
    public Nave getNaveJugador() {
        return this.naveJugador;
    }
}
