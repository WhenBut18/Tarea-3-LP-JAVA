package Planetas;

public class Helado extends Planeta {
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
        System.out.println(">> Temperatura: " + this.temperatura);
    }
    public int getTemperatura(){
        return this.temperatura;
    }
}