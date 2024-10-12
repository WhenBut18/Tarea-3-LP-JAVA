package Planetas;

public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;
    public Volcanico() {
        super(3,5,0f,0.3f);
        System.out.println("Planeta Volcanico");
        this.temperatura = (int) Math.floor(Math.random() * 137 + 120);
        this.platino = (int)Math.floor(0.25 * (4 * Math.PI * Math.pow(getRadio(),2)));
    }
    @Override
    public void printeador() {
        super.printeador();
        System.out.print("Temperatura: ");
        System.out.println(this.temperatura);
        System.out.print("Platino: ");
        System.out.println(this.platino);
        System.out.println("<========================================>");
    }
}

