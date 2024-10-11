public class Helados extends Planeta{
    private int temperatura;
    public Helados() {
        this.temperatura = (int) Math.floor(-(Math.random() * 91 + 30));
        setRadio(3,6);
        setCristalesHidrogeno(0.65f);
        setFloresDeSodio(0.35f);
    }
    @Override
    public void printeador() {
        super.printeador();
        System.out.println(this.temperatura);
    }
}