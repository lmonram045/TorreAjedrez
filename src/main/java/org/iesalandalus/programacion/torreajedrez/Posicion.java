package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
    private int fila;
    private char columna;

    //constructor
    public Posicion (int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    /** setter fila */
    private void setFila(int fila) {
        if (fila < 1 || fila > 8) {
			/*Hubiera creado una constante para el texto del error, pero dejo un literal
			  para ajustarme a la definicion de la clase */
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        } else {
            this.fila = fila;
        }
    }

    /** getter fila */
    public int getFila() {
        return fila;
    }

    /** setter columna */
    private void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
			/*Hubiera creado una constante para el texto del error, pero dejo un literal
			  para ajustarme a la definicion de la clase */
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        } else {
            this.columna = columna;
        }
    }

    /** getter columna  */
    public char getColumna() {
        return columna;
    }
}
