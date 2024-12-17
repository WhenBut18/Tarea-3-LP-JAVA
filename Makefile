# Variables
SRC = NoJavaSky.java CentroGalactico.java Helado.java MapaGalactico.java Oceanico.java Planeta.java Radiactivo.java tieneAsentamientos.java Volcanico.java Jugador.java Nave.java
BIN = $(SRC:.java=.class)
MAIN_CLASS = NoJavaSky

# Regla por defecto
all: $(BIN)

# Compilar las clases
%.class: %.java
	@touch $<                # Actualiza la fecha de modificación del archivo fuente
	javac $<

# Ejecutar el programa
run: all
	java $(MAIN_CLASS)

# Limpiar los archivos compilados
clean:
	rm -f *.class

.PHONY: all run clean