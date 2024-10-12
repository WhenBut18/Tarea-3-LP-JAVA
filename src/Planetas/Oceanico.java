package Planetas;

public class Oceanico extends Planeta {
    private int profundidad;
    public  Oceanico(){
        super(4,6,0.65f,0.2f);
        System.out.println("Planeta Oceanico");
        this.profundidad = (int)Math.floor(Math.random() * ((Math.pow(10,3) - 30) + 1) + 30);
    }

    @Override
    public void printeador() {
        super.printeador();
        System.out.print("Profundidad: ");
        System.out.println(this.profundidad);
        System.out.println("<========================================>");
    }
}
