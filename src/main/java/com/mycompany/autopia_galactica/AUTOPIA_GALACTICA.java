/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.autopia_galactica;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author miguelbedmards
 */
public class AUTOPIA_GALACTICA {

    static final int cass = 42;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { // dentro del main el usuario tendra la opcion de abandonar el juego antes de entrar.
        try {
            String sal = "456";
            System.out.println("Eres un cobarde? si es así escribe 456 para salir si no pulse enter para continuar");
            sal = sc.nextLine();
            if (sal.equalsIgnoreCase("456")) {
                System.out.println("Siempre seras la decepcion de la humanidad.... abandonaste el viaje");
            } else {
                System.out.println("\n===Pulse  cualquier tecla para comenzar el viaje====\n");
                sc.nextLine();
                System.out.println("Bienvenido viajero a la autopia galactia.." + " tira los dados.");
                tablero();

            }
        } catch (Exception e) {
            System.out.println("\nLLAMANDO A LA POLICIA ESPACIAL POR  INTENTAR ENTRAR DE MANERA ILEGAL\n");
        }
    }

    public static void tablero() { //La función tablero se encargara de imprimir el tablero 
        int table = 0;
        int tab[][] = new int[6][7];
        for (int[] fila : tab) {
            for (int j = 0; j < fila.length; j++) {
                fila[j] = table;
                System.out.printf("%4d", table);
                table++;
            }
            System.out.println();
        }
        casillas(1, 0, 0, cass);
    }

    public static void casillas(int cassA, int dirreca, int dirrecan, int cass) {
        int s = 0;
        Random dado = new Random();
        int L1 = dado.nextInt(9) + 1;
        Random dado1 = new Random();
        int L2 = dado1.nextInt(9) + 1;
        Random dado2 = new Random();
        int L3 = dado2.nextInt(9) + 1;
        System.out.println("\nResultado del primer dado\n:" + L1);
        System.out.println("\nResultado del segundo dado\n:" + L2);
        System.out.println("\nResultado del tercer dado\n:" + L3);

        s = L1 + L2 + L3;
        System.err.println("\nSuma de los dados\n" + s);

        dirreca = restaCa(s);
        System.out.println("\nEstas en la dirreccion\n" + dirreca + "\nSuma de\n" + s);

        int dif = Math.abs(dirreca - dirrecan);

        if (cassA == 31) {
            System.out.println("Huh?!,Que es eso ...!EXTRATERRESTES");
            cassA = 13;
            System.out.println("\nPor motivos de reguridad tuvimos que retirarte hasta la casilla\n: " + cass);
            con(cassA, dirreca);
            return;
        }
        if (dif <= 4) {
               cassA += dif;
            System.out.println("Viajero   has avanzado " + dif);
         

        } else {
            System.out.println("Viajero has intentado realizar un viaje demasiado largo no" + "Tecnología no disponible");
        }
        if (cassA == 33) {
            System.out.println("AGUEJERO NEGRO CUIDADO");
            System.out.println("\nTu viaje termino antes de tiempo siempre te recordaremos<==FIN DEL JUEGO==>\n");
            return;

        }
        if (cassA > cass) {
            System.out.println("Estuviste cerca viajero pero  te pasaste tienes que volver a hacer el viaje desde cero");
            cassA = 1;
            return;
        }
        if (cassA == 42) {
            System.out.println("\nFelicidades Viajero completaste el viaje\n" + "\nAhora la humanidad podra seguir viviendo\n");            
            return;
        }
        con(cassA, dirreca);
    }

    public static void con(int cassA, int dirreca) { // funcion  se encargara de manejar el siguiente turno
        System.out.println("Viajero usted se encuentra en " + cassA);
        System.out.println("Debes de continuar el viaje");
        sc.next();
        casillas(cassA, dirreca, dirreca, cass);
    }

    public static int restaCa(int mca) { // La funcion se encargara de reducir la dirreccion
        while (mca >= 10) {
            int suma = 0;
            while (mca > 0) {
                suma += mca % 10;
                mca /= 10;
            }
            mca = suma;
        }

        return mca;
    }

}
