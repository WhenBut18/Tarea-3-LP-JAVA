package Planetas;

public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;
    public Volcanico() {
        super(3,5,0f,0.3f);
        this.temperatura = (int) Math.floor(Math.random() * 137 + 120);
        this.platino = (int)Math.floor(0.25 * (4 * Math.PI * Math.pow(getRadio(),2)));
        setConsumoEnergia(0.08f * this.temperatura);
    }
    @Override
    public void printeador() {
        System.out.println(">> LPaDOS: Preparando el protocolo de aterrizaje para Planeta Volcanico");
        super.printeador();
        System.out.println("║>>    Platino: " + this.platino + "\n║>>    Temperatura: " + this.temperatura);
    }
    @Override
    public int extraerRecursos(int tipo) {
        int Eleccion = super.extraerRecursos(tipo);
        if (tipo == 1 || tipo == 2){
            return Eleccion;
        }
        if (tipo == 3) {
            if (Eleccion > this.platino) {
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

    public void setPlatino(int platino) {
        this.platino += platino;
    }

    public int getTemperatura(){
        return this.temperatura;
    }
    public int getPlatino(){
        return this.platino;
    }
}

