package Planetas;

public class Radiactivo extends Planeta {
    private int uranio;
    private int radiacion;
    public Radiactivo(){
        super(4,5,0.2f,0.2f);
        System.out.println("Planeta Radiactivo");
        this.radiacion = (int)Math.floor(Math.random() * ((50 - 10) + 1) + 10);
        this.uranio = (int)Math.floor(0.25 * (4 * Math.PI * Math.pow(getRadio(),2)));
    }

    @Override
    public void printeador() {
        super.printeador();
        System.out.print("Radiacion: ");
        System.out.println(this.radiacion);
        System.out.print("Uranio: ");
        System.out.println(this.uranio);
        System.out.println("<========================================>");
    }
}
