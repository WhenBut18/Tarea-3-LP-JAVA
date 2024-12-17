import java.util.Scanner;

public class NoJavaSky {

    /*
    ***
    Funcion Main encargada de ejecutar el juego correctamente administrando las diferentes acciones y cuadro de dialogos
    y metodos de la clases.
    */
    public static void main(String[] args) {
        Jugador jugadorActual = new Jugador();
        MapaGalactico mapaActual = new MapaGalactico();
        boolean inOrbita = true;
        Scanner obj = new Scanner(System.in);
        int Eleccion;
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗" +
                         "\n║>> LPaDOS: Me presento, soy LPaDOS una IA integrada a tu Nave.                   ║"+
                         "\n║>> LPaDOS: Te prestare ayuda durante la STEEL SPACE RUN.                         ║"+
                         "\n║>> LPaDOS: Una competencia por llegar al centro de la galaxia mientras atraviesas║"+
                         "\n║           el cosmos saltando de Planeta en Planeta extrayendo sus recursos,     ║"+
                         "\n║           mejorando tu Nave y tu Exotraje.                                      ║"+
                         "\n║>> LPaDOS: Bueno, ya va siendo hora de partir, empezaremos en el Planeta 0, en   ║" +
                         "\n║           donde se encuentra nuestra base, a la que volveras en caso de quedarte║" +
                         "\n║           sin combustible en tu Nave o en energia en tu Exotraje.               ║" +
                         "\n║>> LPaDOS: COMENZANDO PROTOCOLO DE EXPLORACION ESPACIAL.                         ║"+
                         "\n╚═════════════════════════════════════════════════════════════════════════════════╝" +
                         "\n>>    (1) Continuar");
        Eleccion = obj.nextInt();
        while (true){
            if (jugadorActual.getNaveJugador().getUnidadesCombustible() < 0 || jugadorActual.getUnidadesEnergiaProteccion() < 0){
                System.out.println("╔═════════╗" +
                                 "\n║GAME OVER║" +
                                 "\n╚═════════╝" +
                                 "\n>>    (1) Reintentar" +
                                 "\n>>    (2) Salir del juego");
                Eleccion = obj.nextInt();
                if (Eleccion == 1) {
                    jugadorActual.gameover(mapaActual);
                    System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗" +
                            "\n║>> LPaDOS: Debido a nuestro descuido hemos vuelto al planeta inicial.            ║" +
                            "\n║>> LPaDOS: Lamentablemente hemos perdido todo nuestro inventario.                ║" +
                            "\n║>> LPaDOS: Afortunadamente el equipo de remolque galactico recupero nuestra nave.║" +
                            "\n║>> LPaDOS: Mantenemos las mejoras de propulsores y exotrajes                     ║" +
                            "\n╚═════════════════════════════════════════════════════════════════════════════════╝");
                    inOrbita = true;
                } else {
                    break;
                }
            }
            jugadorActual.printeador();
            mapaActual.printeador();
            if (inOrbita){
                System.out.println((char)187 + ">> LPaDOS: Estamos en orbita, ¿Que accion tomamos? (Digite el numero" +
                        ")\n>>    (1) Visitar Planeta.\n>>    (2) Saltar a otro Planeta.\n>>    " +
                        "(3) Recargar Combustible.\n>>    (4) Recargar Energia de Proteccion.\n>>    (5) Mostrar " +
                        "Mapa Galactico");
                Eleccion = obj.nextInt();
                if (Eleccion == 1) {
                    if (mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof CentroGalactico){
                        if (mapaActual.getPlanetas().get(mapaActual.getPosicion()).visitar(jugadorActual)){
                            break;
                        }
                    } else {
                        inOrbita = mapaActual.getPlanetas().get(mapaActual.getPosicion()).visitar(jugadorActual);
                    }
                } else if (Eleccion == 2) {
                    System.out.println(">> LPaDOS: ¿Hacia que direccion vamos? (Digite el numero)\n>>    (1) " +
                            "Avanzar.\n>>    (2) Retroceder.");
                    int Eleccion2 = obj.nextInt();
                    System.out.println(">> LPaDOS: ¿Tamano del Salto? (Digite el numero)");
                    int Eleccion3 = obj.nextInt();
                    if (Eleccion2 == 2 && mapaActual.getPosicion()-Eleccion3 < 0) {
                        System.out.println(">> LPaDOS: Direccion invalida, no se puede ir más atras de Planeta inic" +
                                "ial.");
                    } else {
                        jugadorActual.getNaveJugador().viajarPlaneta(mapaActual, Eleccion2, Eleccion3);
                    }
                } else if (Eleccion == 3) {
                    jugadorActual.recargarCombustible();
                } else if (Eleccion == 4) {
                    jugadorActual.recargarEnergia();
                } else if (Eleccion == 5){
                    mapaActual.printeadorMapa();
                } else {
                    System.out.println(">> LPaDOS: Eleccion invalida.");
                }
            } else {
                System.out.println(">> LPaDOS: Estamos en el Planeta, ¿Que accion tomamos? (Digite el numero" +
                        ")\n>>    (1) Extraer Recursos.\n>>    (2) Salir del Planeta.\n>>    " +
                        "(3) Recargar Combustible.\n>>    (4) Recargar Energia de Proteccion.");
                if (mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof Helado ||
                        mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof Oceanico){
                    System.out.println(">>    (5) Visitar Asentamiento");
                }
                Eleccion = obj.nextInt();
                switch (Eleccion){
                    case 1:
                        System.out.println(">> LPaDOS: ¿Que recurso quieres extraer?\n>>    (1) Cristales de Hidro" +
                                "geno\n>>    (2) Flores de Sodio");
                        if (mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof Radiactivo){
                            System.out.println(">>    (3) Uranio");
                        }
                        if (mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof Volcanico){
                            System.out.println(">>    (3) Platino");
                        }
                        int Eleccion2 = obj.nextInt();
                        int Eleccion3 = mapaActual.getPlanetas().get(mapaActual.getPosicion()).extraerRecursos(Eleccion2);
                        System.out.println("DEBUG: " + Eleccion3);
                        if (Eleccion3 == -1) {
                            continue;
                        } else {
                            if (jugadorActual.consumirEnergiaProteccion(Eleccion3, mapaActual.getPlanetas().get(mapaActual.getPosicion()))){
                                switch (Eleccion2) {
                                    case 1:
                                        mapaActual.getPlanetas().get(mapaActual.getPosicion()).setCristalesHidrogeno(-Eleccion3);
                                        jugadorActual.setAlmacenadoHidrogeno(Eleccion3);
                                        break;
                                    case 2:
                                        mapaActual.getPlanetas().get(mapaActual.getPosicion()).setFloresDeSodio(-Eleccion3);
                                        jugadorActual.setAlmacenadoSodio(Eleccion3);
                                        break;
                                    case 3:
                                        if (mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof Radiactivo){
                                            ((Radiactivo) mapaActual.getPlanetas().get(mapaActual.getPosicion())).setUranio(-Eleccion3);
                                            jugadorActual.setAlmacenadoUranio(Eleccion3);
                                            break;
                                        } else {
                                            ((Volcanico) mapaActual.getPlanetas().get(mapaActual.getPosicion())).setPlatino(-Eleccion3);
                                            jugadorActual.setAlmacenadoPlatino(Eleccion3);
                                            break;
                                        }
                                    default:
                                        System.out.println(">> LPaDOS: Eleccion invalida.");
                                        break;
                                }
                            }
                        }
                        break;
                    case 2:
                        inOrbita = mapaActual.getPlanetas().get(mapaActual.getPosicion()).salir();
                        break;
                    case 3:
                        jugadorActual.recargarCombustible();
                        break;
                    case 4:
                        jugadorActual.recargarEnergia();
                        break;
                    case 5:
                        if (mapaActual.getPlanetas().get(mapaActual.getPosicion()) instanceof Oceanico){
                            ((Oceanico) mapaActual.getPlanetas().get(mapaActual.getPosicion())).visitarAsentamientos(jugadorActual);
                            break;
                        } else {
                            ((Helado) mapaActual.getPlanetas().get(mapaActual.getPosicion())).visitarAsentamientos(jugadorActual);
                            break;
                        }
                    default:
                        System.out.println(">> LPaDOS: Eleccion invalida.");
                        break;
                }
            }
        }
    }
}