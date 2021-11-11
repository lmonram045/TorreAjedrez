package org.iesalandalus.programacion.torreajedrez;

public class MainApp {

	private static Torre torre = null;

	private static void mostrarTorre() {
		if (torre != null) {
			System.out.println("Torre: " + torre);
		} else {
			System.out.println("Aún no se ha creado ninguna torre.");
		}
	}

	public static void main(String[] args) {
		System.out.println("kk");
	}

}
