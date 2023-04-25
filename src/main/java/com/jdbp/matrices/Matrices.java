package com.jdbp.matrices;

/**
 *
 * @author Juan David Beltran Piza
 * Tema: Operaciones con matrices
 */
import java.util.Scanner

public class Matrices {
    private int[][] matriz;
    private int filas;
    private int columnas;

    public static void main(String[] args) {
        Matrices m = new Matrices();
        m.menu();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Declarar matriz");
            System.out.println("2. Definir datos de la matriz");
            System.out.println("3. Leer y escribir los datos de la matriz")
            System.out.println("4. Recorrer la matriz por filas");
            System.out.println("5. Recorrer la matriz por columnas");
            System.out.println("6. Buscar un dato determinado");
            System.out.println("7. Buscar un dato en una posición determinada");
            System.out.println("8. Actualizar un dato");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    declararMatriz(sc);
                    break;
                case 2:
                    definirDatos(sc);
                    break;
                case 3:
                    leerEscribirDatos(sc);
                    break;
                case 4:
                    recorrerPorFilas();
                    break;
                case 5:
                    recorrerPorColumnas();
                    break;
                case 6:
                    buscarDato(sc);
                    break;
                case 7:
                    buscarEnPosicion(sc);
                    break;
                case 8:
                    actualizarDato(sc);
                    break;
                case 9:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        } while (opcion != 9);
    }

    public void declararMatriz(Scanner sc) {
        System.out.print("Ingrese el número de filas: ");
        filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        columnas = sc.nextInt();
        matriz = new int[filas][columna];
    }

    public void definirDatos(Scanner sc) {
        System.out.println("1. Asignar datos manualmente");
        System.out.println("2. Asignar datos aleatorios");
        System.out.print("Ingrese una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                asignarManual(sc);
                break;
            case 2:
                asignarAleatorio(sc);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void asignarManual(Scanner sc) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }
    
public void asignarAleatorio(Scanner sc) {
    System.out.print("Ingrese el valor máximo para los números aleatorios: ");
    int maximo = sc.nextInt();

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            matriz[i][j] = (int) (Math.random() * (maximo + 1));
        }
    }
}

public void leerEscribirDatos(Scanner sc) {
    // Pedimos al usuario que ingrese los datos de la matriz
    System.out.println("Ingrese los datos de la matriz:");

    // Recorremos la matriz para escribir los valores ingresados por el usuario
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print("Ingrese el elemento [" + i + "][" + j + "]: ");
            matriz[i][j] = sc.nextInt();
        }
    }

    // Mostramos los datos de la matriz
    System.out.println("Los datos ingresados son:");
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }
}

public void recorrerPorFilas() {
    // Recorremos la matriz por filas y mostramos los valores
    for (int i = 0; i < matriz.length; i++) {
        System.out.print("Fila " + i + ": ");
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }
}

public void recorrerPorColumnas() {
    // Recorremos la matriz por columnas y mostramos los valores
    for (int j = 0; j < matriz[0].length; j++) {
        System.out.print("Columna " + j + ": ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }
}

public void buscarDato(Scanner sc) {
    // Pedimos al usuario que ingrese el dato a buscar
    System.out.print("Ingrese el dato a buscar: ");
    int dato = sc.nextInt();

    // Recorremos la matriz buscando el dato
    boolean encontrado = false;
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] == dato) {
                System.out.println("El dato " + dato + " se encuentra en la posición [" + i + "][" + j + "]");
                encontrado = true;
            }
        }
    }

    // Si no se encontró el dato, mostramos un mensaje
    if (!encontrado) {
        System.out.println("El dato " + dato + " no se encuentra en la matriz");
    }
}

public void buscarEnPosicion(Scanner sc) {
    System.out.print("Ingrese la fila que desea buscar: ");
    int fila = sc.nextInt();
    System.out.print("Ingrese la columna que desea buscar: ");
    int columna = sc.nextInt();

    if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
        System.out.println("Posición inválida.");
    } else {
        System.out.println("El valor en la posición [" + fila + "][" + columna + "] es: " + matriz[fila][columna]);
    }
}

public void actualizarDato(Scanner sc) {
    System.out.print("Ingrese la fila del dato que desea actualizar: ");
    int fila = sc.nextInt();
    System.out.print("Ingrese la columna del dato que desea actualizar: ");
    int columna = sc.nextInt();

    if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
        System.out.println("Posición inválida.");
    } else {
        System.out.print("Ingrese el nuevo valor para la posición [" + fila + "][" + columna + "]: ");
        matriz[fila][columna] = sc.nextInt();
        System.out.println("Dato actualizado correctamente.");
    }
}

}
