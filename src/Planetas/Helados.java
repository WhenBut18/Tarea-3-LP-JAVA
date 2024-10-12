package Planetas;

public class Helados extends Planeta {
    private int temperatura;
    public Helados() {
        super(3,6,0.35f,0.65f);
        System.out.println("Planeta Helado");
        this.temperatura = (int) Math.floor(-(Math.random() * 91 + 30));
    }
    @Override
    public void printeador() {
        super.printeador();
        System.out.print("Temperatura: ");
        System.out.println(this.temperatura);
        System.out.println("<========================================>");
    }
}