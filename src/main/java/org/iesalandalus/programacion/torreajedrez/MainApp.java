package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

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

	private static int elegirOpcion() {
		int opcion;
		do {
			System.out.print(" Elija una opción: ");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 5);
		return opcion;
	}

	private static Color elegirColor() {
		int opcion;
		System.out.println("||==========================================================||");
		System.out.println("||                      Elija un color                      ||");
		System.out.println("||==========================================================||");
		System.out.println("||                                                          ||");
		System.out.println("|| 1. Blanco                                                ||");
		System.out.println("|| 2. Negro                                                 ||");
		System.out.println("||                                                          ||");
		System.out.println("||==========================================================||");
		do {
			opcion = Entrada.entero();
		} while (opcion != 1 && opcion != 2);

		if (opcion == 1) {
			return Color.BLANCO;
		} else {
			return Color.NEGRO;
		}
	}

	private static char elegirColumnaInicial() {
		char columna;
		System.out.println("||===============================================||");
		System.out.println("||           Elija la columna inicial            ||");
		System.out.println("||===============================================||");
		System.out.println("||                                               ||");
		System.out.println("|| c. Columna 'C'                                ||");
		System.out.println("|| f. Columna 'F'                                ||");
		System.out.println("||                                               ||");
		System.out.println("||===============================================||");

		do {
			columna = Entrada.caracter();
		} while (columna != 'c' && columna != 'f');
		return columna;
	}

	private static void mostrarMenuDirecciones() {
		System.out.println("||=============================================||");
		System.out.println("||             Menú de direcciones             ||");
		System.out.println("||=============================================||");
		System.out.println("||                                             ||");
		System.out.println("|| 1. ↑                                        ||");
		System.out.println("|| 2. ↓                                        ||");
		System.out.println("|| 3. ←                                        ||");
		System.out.println("|| 4. →                                        ||");
		System.out.println("|| 5. Enroque corto                            ||");
		System.out.println("|| 6. Enroque largo                            ||");
		System.out.println("||                                             ||");
		System.out.println("||=============================================||");
	}

	public static void main(String[] args) {
		System.out.println("kk");
	}

}
