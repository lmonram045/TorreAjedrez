package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

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
        int filaDestino;
        char columnaDestino;
        try {
            switch (direccion) {
                case ARRIBA:
                    filaDestino = this.posicion.getFila();
                    columnaDestino = this.posicion.getColumna();

                    for (int i = 1; i <= pasos; i++) {
                        columnaDestino++;
                    }
                    posicionDestino = new Posicion(filaDestino, columnaDestino);
                    break;
                case ABAJO:
                    filaDestino = this.posicion.getFila();
                    columnaDestino = this.posicion.getColumna();

                    for (int i = 1; i <= pasos; i++) {
                        columnaDestino--;
                    }
                    posicionDestino = new Posicion(filaDestino, columnaDestino);
                    break;
                case DERECHA:
                    filaDestino = this.posicion.getFila();
                    columnaDestino = this.posicion.getColumna();

                    for (int i = 1; i <= pasos; i++) {
                        filaDestino++;
                    }
                    posicionDestino = new Posicion(filaDestino, columnaDestino);
                    break;
                case IZQUIERDA:
                    filaDestino = this.posicion.getFila();
                    columnaDestino = this.posicion.getColumna();

                    for (int i = 1; i <= pasos; i++) {
                        filaDestino--;
                    }
                    posicionDestino = new Posicion(filaDestino, columnaDestino);
                    break;
                /*case ENROQUE_CORTO:
                    filaDestino = this.posicion.getFila();
                    columnaDestino = 'f';
                    if (filaDestino == 1 || filaDestino == 8) {
                        posicionDestino = new Posicion(filaDestino, columnaDestino);
                    } else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    break;
                case ENROQUE_LARGO:
                    filaDestino = this.posicion.getFila();
                    columnaDestino = 'd';
                    if (filaDestino == 1 || filaDestino == 8) {
                        posicionDestino = new Posicion(filaDestino, columnaDestino);
                    } else {
                        throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
                    }
                    break;*/
                default:
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
            }
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
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



}
