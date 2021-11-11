package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

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
		System.out.println("|| a. Columna 'a'                                ||");
		System.out.println("|| h. Columna 'h'                                ||");
		System.out.println("||                                               ||");
		System.out.println("||===============================================||");

		do {
			columna = Entrada.caracter();
		} while (columna != 'a' && columna != 'h');
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

	private static int elegirDireccion() {
		int opcion;
		do {
			System.out.print(" Elija una opción: ");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 6);
		return opcion;
	}

	private static void crearTorreDefecto() {
		torre = new Torre();
		System.out.println("Se creó la torre por defecto en la posición 8h, de color negro.");
	}

	private static void crearTorreColor() {
		Color color = elegirColor();
		torre = new Torre(color);
		System.out.println("Se creó la torre por defecto a partir del color.");
	}

	private static void crearTorreColorColumna() {
		char columna = elegirColumnaInicial();
		Color color = elegirColor();
		torre = new Torre(color, columna);
		System.out.println("Se creó una torre a partir del color y columna seleccionados.");
	}

	private static void mover() throws OperationNotSupportedException {
		mostrarMenuDirecciones();
		int opcion = elegirDireccion();
		Direccion direccion = null;
		switch (opcion) {
			case 1:
				direccion = Direccion.ARRIBA;
				break;

			case 2:
				direccion = Direccion.ABAJO;
				break;

			case 3:
				direccion = Direccion.IZQUIERDA;
				break;
			case 4:
				direccion = Direccion.DERECHA;
				break;

			case 5:
				direccion = Direccion.ENROQUE_CORTO;
				break;

			case 6:
				direccion = Direccion.ENROQUE_LARGO;
			default:
				break;
		}

		System.out.print("Indique el número de pasos a dar");
		int pasos = Entrada.entero();
		torre.mover(direccion, pasos);
		System.out.println("Movimiento realizado correctamente");
	}

	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
		switch (opcion) {
			case 1:
				crearTorreDefecto();
				break;
			case 2:
				crearTorreColor();
				break;
			case 3:
				crearTorreColorColumna();
				break;
			case 4:
				if (torre != null) {
					mover();
				} else {
					System.out.println("No hay ninguna torre creada.");
				}
				break;
			default:
				break;
		}
	}

	public static void main(String[] args) throws OperationNotSupportedException {
		int opcion;
		do {
			mostrarMenu();
			opcion = elegirOpcion();
			ejecutarOpcion(opcion);
			if (opcion != 5) {
				mostrarTorre();
			}
		} while (opcion != 5);

		System.out.println("¡¡¡Hasta luego noruego!!!");
	}

}
