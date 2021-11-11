package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Torre {
    // Como no aparecen estos atributos en el diagrama, presupongo que son privados.
    private Color color;
    private Posicion posicion;

    /** Constructor por defecto */
    public Torre() {
        color = Color.NEGRO;
        posicion = new Posicion(8, 'h');
    }

    /** Constructor con parámetro color */
    public Torre(Color color) {
        if (color == Color.BLANCO) {
            posicion = new Posicion(1, 'h');
        } else if (color == Color.NEGRO) {
            posicion = new Posicion(8, 'h');
        }
        if (color == null) {
            throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
        }
        this.color = color;
    }

    /** Constructor con parámetro color y columna */
    public Torre(Color color, char columna) {
        if (color == null) {
            throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
        }

        if (columna != 'a' && columna != 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }

        if (color == Color.BLANCO) {
            posicion = new Posicion(1, columna);
        }
        if (color == Color.NEGRO) {
            posicion = new Posicion(8, columna);
        }
        this.color = color;
    }
    /** Método mover */
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if (pasos < 1) {
            throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
        }

        Posicion posicionDestino;
        // Ya que la torre solo cambia de columna o de fila, creo las siguientes variables
        int filaDestino;
        int fila;
        char columna;
        char columnaDestino;
        Color color = getColor();
        try {
            switch (direccion) {
                case ARRIBA:
                    filaDestino = this.posicion.getFila();
                    columna = this.posicion.getColumna();
                    // Controlo la fila hacia arriba para controlar que no se sale, segun el color sea blanco o negro
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (filaDestino < 8) {
                                filaDestino++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    } else {
                        for (int i = 1; i <= pasos; i++) {
                            if (filaDestino > 1) {
                                filaDestino--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }
                    posicionDestino = new Posicion(filaDestino, columna);
                    break;
                case ABAJO:
                    filaDestino = this.posicion.getFila();
                    columna = this.posicion.getColumna();
                    // Controlo la fila hacia abajo para controlar que no se sale
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (filaDestino > 1) {
                                filaDestino--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    } else {
                        for (int i = 1; i <= pasos; i++) {
                            if (filaDestino < 8) {
                                filaDestino++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }
                    posicionDestino = new Posicion(filaDestino, columna);
                    break;
                case DERECHA:
                    fila = this.posicion.getFila();
                    columnaDestino = this.posicion.getColumna();
                    // Controlo la columna hacia la derecha para controlar que no se sale comprobando el color
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (columnaDestino < 'h') {
                                columnaDestino++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    } else {
                        for (int i = 1; i <= pasos; i++) {
                            if (columnaDestino > 'a') {
                                columnaDestino--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }

                    posicionDestino = new Posicion(fila, columnaDestino);
                    break;
                case IZQUIERDA:
                    fila = this.posicion.getFila();
                    columnaDestino = this.posicion.getColumna();
                    // Controlo la columna hacia la izquierda para controlar que no se salga comprobando el color
                    if (color == Color.BLANCO) {
                        for (int i = 1; i <= pasos; i++) {
                            if (columnaDestino > 'a') {
                                columnaDestino--;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    } else {
                        for (int i = 1; i <= pasos; i++) {
                            if (columnaDestino < 'h') {
                                columnaDestino++;
                            } else {
                                throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                            }
                        }
                    }

                    posicionDestino = new Posicion(fila, columnaDestino);
                    break;
                default:
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
            }
        } catch (OperationNotSupportedException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        }
        this.setPosicion(posicionDestino);
    }

    /** Método enrocar */
    public void enrocar(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }

        Posicion posicionDestino;
        int fila;
        char columna;

        try {
            switch (direccion) {
                case ENROQUE_CORTO:
                    fila = this.posicion.getFila();
                    columna = this.posicion.getColumna();
                    // Controlo que esté en la fila y columnas correctas, el enroque corto solo se puede hacer en la columna 'h'
                    if ((fila == 1 || fila == 8) && columna == 'h') {
                        columna = 'f';
                    } else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    posicionDestino = new Posicion(fila, columna);
                    break;
                case ENROQUE_LARGO:
                    fila = this.posicion.getFila();
                    columna = this.posicion.getColumna();
                    if ((fila == 1 || fila == 8) && columna == 'a') {
                        columna = 'd';
                    } else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    posicionDestino = new Posicion(fila, columna);
                    break;
                default:
                    throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
            }
        } catch (OperationNotSupportedException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
        }

        this.setPosicion(posicionDestino);
    }
    // ------------------------ Getters y Setters -----------------------------------------------------------------
    private void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    private void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
        }
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    // ------------------------- Fin de Getters y Setters ----------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torre torre = (Torre) o;
        return color == torre.color && posicion.equals(torre.posicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, posicion);
    }

    @Override
    public String toString() {
        return posicion + ", " + "color=" + color;
    }
}
