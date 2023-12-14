package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombreProblem = scanner.nextInt();
        for (int i = 1; i < nombreProblem; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                int nombreSur = scanner.nextInt();
                System.out.print(nombreSur);
            }
        }
    }
}