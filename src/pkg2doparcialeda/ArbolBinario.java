package pkg2doparcialeda;

import java.util.Random;
import java.util.Scanner;

public class ArbolBinario {

    Nuez[] arbol;
    int tamaño;

    public ArbolBinario(int tamaño) {
        this.tamaño = tamaño;
        arbol = new Nuez[tamaño];
        Nuez n = new Nuez();
        for (int i = 0; i <= tamaño - 1; i++) {
            arbol[i] = n;
        }
    }

    public void crearSendero(Nuez n) {
        int i = 0;
        if (arbol[0].getNum() == -1) {
            arbol[0] = n;
        } else {
            while ((arbol[i].getNum() != -1) && (i <= tamaño)) {
                if (n.getNum() < arbol[i].getNum()) {
                    i = 2 * i + 1;
                } else {
                    i = 2 * i + 2;
                }
            }
            if (i <= tamaño) {
                arbol[i] = n;
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < tamaño - 1; i++) {
            System.out.println(arbol[i] + " - ");
        }
    }

    public boolean colocarNuezAleatoria() {
        Random random = new Random();
        int posicion = random.nextInt(2 * tamaño);
        Nuez nuezDorada = new Nuez(posicion, "NUEZ DORADA");
        if (arbol[0].getNum() == -1) {
            return false;
        } else {
            crearSendero(nuezDorada);
            return true;
        }
    }

    public boolean buscarNuez() {
        int i = 0;
        int contador = 0;
        Scanner leer = new Scanner(System.in);
        while ((arbol[i].getNum() != -1) && (i < tamaño)) {
            System.out.println("¿Desea ir hacia la derecha ó a la izquierda? I/D");
            String direccion = leer.next();
            direccion = direccion.toUpperCase();
            if ("I".equals(direccion)) {
                i = 2 * i + 1;
                contador++;
                if (arbol[i].getNuez().equals("NUEZ DORADA")) {
                    System.out.println("Realizaste " + contador + " pasos");
                    return true;
                }
            } else {
                if ("D".equals(direccion)) {
                    i = 2 * i + 2;
                    contador++;
                    if (arbol[i].getNuez().equals("NUEZ DORADA")) {
                        System.out.println("Realizaste " + contador + " pasos");
                        return true;
                    }
                } else {
                    System.out.println("Opcion invalida");
                }
            }
        }
        System.out.println("Realizaste " + contador + " pasos");
        return false;
    }

}
