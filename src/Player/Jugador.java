package Player;

public class Jugador {
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private int almacenadoHidrogeno;
    private int almacenadoSodio;
    public Jugador(){
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.almacenadoSodio = 0;
        this.almacenadoHidrogeno = 0;
    }
    public void recargarEnergiaProteccion(int sodio){
        this.unidadesEnergiaProteccion += 0.65f * sodio * (1 + eficienciaEnergiaProteccion);
    }
}
