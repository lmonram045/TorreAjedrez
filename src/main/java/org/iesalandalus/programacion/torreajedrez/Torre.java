package org.iesalandalus.programacion.torreajedrez;

public class Torre {
    // Como no aparecen estos atributos en el diagrama, presupongo que son privados.
    private Color color;
    private Posicion posicion;

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
