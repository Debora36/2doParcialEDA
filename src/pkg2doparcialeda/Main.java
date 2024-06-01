package pkg2doparcialeda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArbolBinario sendero = new ArbolBinario(15);//4 niveles
        Scanner leer = new Scanner(System.in);

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
                        System.out.println("Ingresa el número que identifique la nuez:");
                        int num = leer.nextInt();
                        System.out.println("Ingresa el nombre");
                        String nuez = leer.next();
                        Nuez n = new Nuez(num, nuez);
                        sendero.crearSendero(n);
                        System.out.println("¿Desea ingresar otra nuez? s/n");
                        seguir = leer.next();
                        System.out.println("elegiste: " + seguir);
                    }
                }
                case 2 -> {
                    if (sendero.colocarNuezAleatoria()) {
                        System.out.println("Nuez dorada colocada en uno de los extremos.");
                    } else {
                        System.out.println("Sendero vacio,debe crearlo primero");
                    }

                }
                case 3 -> {
                    if (sendero.buscarNuez()) {
                        System.out.println("Felicidades encontraste la nuez dorada");
                    } else {
                        System.out.println("No se encontró la nuez.");
                    }
                }
                case 4 -> {
                    System.out.println("Solucion");
                    sendero.mostrar();
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
