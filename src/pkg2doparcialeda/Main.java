package pkg2doparcialeda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArbolBinario jardin = new ArbolBinario(50);
        Scanner leer = new Scanner(System.in);
        String regex = "^\\d+$";
        boolean salir = false;

        while (!salir) {
            System.out.println("--- EL JARDIN DE LOS CAMINOS QUE BIFURCAN ---");
            System.out.println("1. Crear sendero");
            System.out.println("2. Colocar nuez dorada");
            System.out.println("3. Buscar nuez dorada");
            System.out.println("4. Mostrar sendero");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> {
                    String seguir = "s";
                    while (!seguir.equals("n")) {
//                        System.out.println("Dele un nombre del sendero");
                        String sendero = "nuez";//leer.next();
                        System.out.println("Dele el número a la nuez:");
                        String num = leer.next();
                        if(!num.matches(regex)){//por si ingresan una letra
                            System.out.println("Dato inválido");
                            continue;
                        }
                        Nodo n = new Nodo(Integer.parseInt(num), sendero);
                        jardin.crearSendero(n);
                        System.out.println("¿Desea agregar otro sendero? s/n");
                        seguir = leer.next();
                    }
                }
                case 2 -> {
                    if (jardin.colocarNuezAleatoria()) {
                        System.out.println("Nuez dorada colocada en uno de los extremos.");
                    } else {
                        System.out.println("Sendero vacio,debe crearlo primero");
                    }

                }
                case 3 -> {
                    if (jardin.buscarNuez()) {
                        System.out.println("Felicidades encontraste la nuez dorada");
                    } else {
                        System.out.println("Fin del sendero. No se encontró la nuez.");
                    }
                }
                case 4 -> {
                    System.out.println("Solucion");
                    jardin.mostrar();
                }
                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo");
                }
                default ->
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
