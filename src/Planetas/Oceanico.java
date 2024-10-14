package Planetas;

public class Oceanico extends Planeta {
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
        System.out.println(">> Profundidad: " + this.profundidad);
    }
    public int getProfundidad(){
        return this.profundidad;
    }
}
