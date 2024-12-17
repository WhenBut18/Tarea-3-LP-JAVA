import java.util.ArrayList;
import java.util.List;

public class MapaGalactico {
    private List<Planeta> planetas;
    private int posicion;
    private boolean CG;

    /*
    ***
    Ninguno
    ***
    MapaGalactico
    ***
    Este constructor inicializa un objeto de tipo MapaGaláctico. Establece la posición inicial
    en 0, inicializa la lista de planetas como un nuevo ArrayList y añade un planeta generado
    aleatoriamente a la lista. También inicializa el indicador CG como falso.
    */
        public MapaGalactico(){
        this.posicion = 0;
        planetas = new ArrayList<>();
        planetas.add(generadorPlaneta());
        this.CG = false;
    }

    /*
    ***
    Ninguno
    ***
    Planeta
    ***
    Esta función genera un planeta de forma aleatoria basándose en un número aleatorio.
    El número determina el tipo de planeta (Helado, Oceánico, Radiactivo, Volcánico o Centro Galáctico)
    que se devolverá. Si se genera un Centro Galáctico y ya ha sido creado, la función se llama a sí misma
    para intentar generar otro planeta. En caso de error, devuelve un planeta Helado por defecto.
    */
    public Planeta generadorPlaneta(){
        int numeroAleatorio = (int)Math.floor(Math.random() * ((100 - 1) + 1) + 1);
        if (numeroAleatorio <= 30){
            return new Helado();
        } else if (numeroAleatorio <= 60) {
            return new Oceanico();
        } else if (numeroAleatorio <= 80) {
            return  new Radiactivo();
        } else if (numeroAleatorio <= 99) {
            return new Volcanico();
        } else if (numeroAleatorio == 100) {
            if (this.CG){
                return generadorPlaneta();
            }
            CG = true;
            return new CentroGalactico();
        } else {
            System.out.println("ERROR AL GENERAR PLANETA");
            return new Helado();
        }
    }
    /*
    ***
    planeta : Planeta
    ***
    void
    ***
    Esta función añade un objeto de tipo Planeta a la lista de planetas del objeto actual.
    Permite modificar la colección de planetas disponibles al agregar uno nuevo.
    */
    public void setPlanetas(Planeta planeta){
        this.planetas.add(planeta);
    }

    /*
    ***
    salto : int
    ***
    void
    ***
    Esta función actualiza la posición del objeto actual sumando un valor entero salto.
    Permite modificar la posición al avanzar una cantidad determinada.
    */
    public void setPosicion(int salto) {
        this.posicion += salto;
    }

    /*
    ***
    Ninguno
    ***
    int
    ***
    Esta función devuelve el valor actual de la posición del objeto.
    Permite acceder a la propiedad posicion desde fuera de la clase.
    */
    public int getPosicion(){
        return posicion;
    }

    /*
    ***
    Ninguno
    ***
    List<Planeta>
    ***
    Esta función devuelve la lista de planetas del objeto actual.
    Permite acceder a la colección de planetas desde fuera de la clase.
    */
    public List<Planeta> getPlanetas(){
        return this.planetas;
    }

    /*
    ***
    Ninguno
    ***
    void
    ***
    Esta función imprime en consola la información del planeta en la posición actual.
    Muestra el tipo de planeta basado en su clase (Helado, Oceánico, Radiactivo, Volcanico
    o Centro Galáctico) utilizando instanceof para determinar el tipo.
    */
    public void printeador(){
        System.out.print("PLANETA " + getPosicion() +" || Tipo: ");
        if (planetas.get(posicion) instanceof Helado) {
            System.out.println("HELADO");
        } else if (planetas.get(posicion) instanceof Oceanico) {
            System.out.println("OCEANICO");
        } else if (planetas.get(posicion) instanceof Radiactivo) {
            System.out.println("RADIACTIVO");
        } else if (planetas.get(posicion) instanceof Volcanico) {
            System.out.println("VOLCANICO");
        } else {
            System.out.println("CENTRO GALACTICO");
        }
    }

    /*
    ***
    Ninguno
    ***
    void
    ***
    Esta función imprime en consola un mapa galáctico que muestra la lista de planetas.
    Cada planeta se identifica por su tipo (Helado, Oceánico, Radiactivo, Volcanico o
    Centro Galáctico). Indica la posición actual del objeto en el mapa marcando
    el planeta correspondiente.
    */
    public void printeadorMapa(){
        System.out.print("╔═════════════════════════════════════════╕\n║>> LPaDOS: Desplegando Mapa Galactico...");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.print("\n║>>    ("+ i + ") PLANETA ");
            if (planetas.get(i) instanceof Helado) {
                System.out.print("HELADO");
            } else if (planetas.get(i) instanceof Oceanico) {
                System.out.print("OCEANICO");
            } else if (planetas.get(i) instanceof Radiactivo) {
                System.out.print("RADIACTIVO");
            } else if (planetas.get(i) instanceof Volcanico) {
                System.out.print("VOLCANICO");
            } else {
                System.out.print("CENTRO GALACTICO");
            }
            if (i == this.posicion) {
                System.out.print(" <---- ESTAMOS ACA");
            }
        }
        System.out.println("\n╚═════════════════════════════════════════╛");
    }
}
