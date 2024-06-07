package pkg2doparcialeda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArbolBinario jardin = new ArbolBinario(30);
        Scanner leer = new Scanner(System.in);
        String regex = "^\\d+$";//es para validar que sole ingresen numeros de parte del usuario
        boolean salir = false;

        while (!salir) {
            System.out.println("--- EL JARDIN DE LOS CAMINOS QUE BIFURCAN ---");
            System.out.println("1. Crear sendero");
            System.out.println("2. Colocar nuez dorada");
            System.out.println("3. Buscar nuez dorada");
            System.out.println("4. Mostrar Jardin");
            System.out.println("5. Busqueda Automatica");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> {
                    String seguir = "s";
                    while (!seguir.equals("n")) {
                        String sendero = "Sendero";//leer.next();
                        System.out.println("Dele un numero a la nuez:");
                        String num = leer.next();
                        if (!num.matches(regex)) {//por si ingresan una letra
                            System.out.println("Dato invalido");
                            continue;
                        }
                        Nodo n = new Nodo(Integer.parseInt(num), sendero);
                        jardin.crearSendero(n);
                        System.out.println("Desea agregar otra nuez? s/n");
                        seguir = leer.next();
                        while (!seguir.matches("[sSnN]")) {
                            System.out.println("Entrada no valida. Por favor, ingrese 's' para si o 'n' para no: ");
                            seguir = leer.next();
                        }
                    }
                }
                case 2 -> {
                    try{
                        jardin.colocarNuezAleatoria();
                        System.out.println("Nuez dorada colocada en uno de los extremos.");
                    }catch(Exception e){
                         System.out.println("Sendero vacio,debe crearlo primero");
                    }

                }
                case 3 -> {
                    if (jardin.buscarNuez()) {
                        System.out.println("Felicidades encontraste la nuez dorada");
                    } else {
                        System.out.println("Fin del sendero. No se encontro la nuez.");
                    }
                }
                case 4 -> {
                    System.out.println("Mapa del Jardin");
                    jardin.mostrar();
                }
                case 5 -> {
                    int pasos = jardin.buscarNuezDorada();
                    System.out.println("Pasos realizados al encontrar la Nuez Dorada: " + pasos);
                }
                case 6 -> {
                    salir = true;
                    System.out.println("Saliendo");
                }
                default ->
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
}
