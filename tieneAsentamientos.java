public interface tieneAsentamientos {

    /*
    ***
    jugador : Jugador
    ***
    void
    ***
    Este metodo proporciona una implementación por defecto para visitar asentamientos.
    No realiza ninguna acción en su forma actual y puede ser sobrescrito por las clases
    que implementan esta interfaz según sus necesidades específicas.
    */
    default void visitarAsentamientos(Jugador jugador){
    }
}
