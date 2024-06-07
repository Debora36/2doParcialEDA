package pkg2doparcialeda;

import java.util.Random;
import java.util.Scanner;

public class ArbolBinario {

    Nodo[] arbol;
    int tamaño;
    int max =0;
    Nodo nuezDorada;

    public ArbolBinario(int tamaño) {
        this.tamaño = tamaño;
        arbol = new Nodo[tamaño];
        Nodo n = new Nodo();
        nuezDorada = new Nodo();
        for (int i = 0; i <= tamaño - 1; i++) {
            arbol[i] = n;
        }
    }

    public void crearSendero(Nodo n) {
        int i = 0;
        if(n.getNum()>max){
            max=n.getNum();
        }
        
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
            if(arbol[i].getNum()== -1){
                System.out.print(" () ");
            }else{
                System.out.print(arbol[i]); 
            }
           
        }
        System.out.println("");
    }

    public boolean colocarNuezAleatoria() {
        Random random = new Random();
        int posicion = random.nextInt(2 * max);
        nuezDorada = new Nodo(posicion, "NUEZ DORADA");
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
            System.out.println("Desea ir hacia la derecha o a la izquierda? I/D");
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
    
    public int buscarNuezDorada() {
        int pasos = 0;
        int i = 0;

        while (arbol[i].getNum() != nuezDorada.getNum() && nuezDorada.getNum()!= -1) {
            pasos++;
            if (nuezDorada.getNum() < arbol[i].getNum()) {
                i = 2 * i + 1;
            } else {
                i = 2 * i + 2;
            }
        }

        return pasos;
    }

}
