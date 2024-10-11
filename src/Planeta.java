public class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    /*public boolean visitar(Jugador jugador) {
        return true;
    };*/
    public int extraerRecursos(int tipo) {
        return 0;
    };
    public boolean salir() {
        return true;
    }
    public Planeta() {
        System.out.println("Generando Planeta...");
    }
    public void setRadio(int supRadio, int infRadio) {
        this.radio = (int)Math.floor(Math.random() * ((Math.pow(10,supRadio) - Math.pow(10,infRadio)) + 1) + Math.pow(10,infRadio));
    }
    public  void setCristalesHidrogeno(float ratioHidrogeno){
        this.cristalesHidrogeno = (int)Math.pow(this.radio,2);
    }
    public  void setFloresDeSodio(float ratioFloresDeSodio) {
        this.floresDeSodio = (int)Math.floor(ratioFloresDeSodio * (4 * Math.PI * Math.pow(this.radio,2)));
    }
    public void printeador() {
        System.out.print("Radio: ");
        System.out.println(this.radio);
        System.out.print("Cantidad Cristales: ");
        System.out.println(this.cristalesHidrogeno);
        System.out.print("Cantidad Sodio: ");
        System.out.println(this.floresDeSodio);
    }
}
