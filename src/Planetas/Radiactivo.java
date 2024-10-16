package Planetas;

public class Radiactivo extends Planeta {
    private int uranio;
    private int radiacion;
    public Radiactivo(){
        super(4,5,0.2f,0.2f);
        this.radiacion = (int)Math.floor(Math.random() * ((50 - 10) + 1) + 10);
        this.uranio = (int)Math.floor(0.25 * (4 * Math.PI * Math.pow(getRadio(),2)));
        setConsumoEnergia(0.3f * this.radiacion);
    }

    @Override
    public void printeador() {
        System.out.println(">> LPaDOS: Preparando el protocolo de aterrizaje para Planeta Radiactivo");
        super.printeador();
        System.out.println(">> Uranio: " + this.uranio + "\n>> Radiacion: " + this.radiacion);
    }
    @Override
    public int extraerRecursos(int tipo) {
        int Eleccion = super.extraerRecursos(tipo);
        if (tipo == 3) {
            if (Eleccion > this.uranio) {
                System.out.println(">> LPaDOS: No puedes extraer más recursos de los que tiene el planeta, cancelando" +
                        " protocolo de extraccion");
                return -1;
            } else {
                System.out.println(">> LPaDOS: Se han extraido " + Eleccion + " unidades de Uranio.");
                this.uranio -= Eleccion;
                return Eleccion;
            }
        } else {
            return -1;
        }
    }
    public int getUranio(){
        return this.uranio;
    }
    public  int getRadiacion(){
        return  this.radiacion;
    }
}
