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

	private static void mostrarMenu() {
		System.out.println("||============================================================||");
		System.out.println("||         Opciones para crear, colocar y mover torre         ||");
		System.out.println("||============================================================||");
		System.out.println("||                                                            ||");
		System.out.println("|| 1. Crear torre genérica (por defecto).                     ||");
		System.out.println("|| 2. Crear torre a partir de un color.                       ||");
		System.out.println("|| 3. Crear torre a partir de un color y una columna inicial. ||");
		System.out.println("|| 4. Mover torre.                                            ||");
		System.out.println("|| 5. Salir.                                                  ||");
		System.out.println("||                                                            ||");
		System.out.println("||============================================================||");
	}

	public static void main(String[] args) {
		System.out.println("kk");
	}

}
