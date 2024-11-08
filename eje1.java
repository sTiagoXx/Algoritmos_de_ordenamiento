package ejercicios;

import java.util.*;

public class eje1 {

    private static final int Num_de_estudiantes = 10;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int[] codigos = generarCodigos(Num_de_estudiantes);
        String[] nombres = generarNombres(Num_de_estudiantes);
        double[][] notas = generarNotas(Num_de_estudiantes);

        System.out.println("Lista de Estudiantes:");
        mostrarLista(codigos, nombres, notas);

        ordenarPorNotaFinal(codigos, nombres, notas);

        System.out.println("\nLista de Estudiantes ordenada por nota final:");
        mostrarLista(codigos, nombres, notas);

        buscarEstudiante(codigos, nombres, notas);
    }

    private static int[] generarCodigos(int cantidad) {
        return RANDOM.ints(cantidad, 1000, 2001).toArray();
    }

    private static String[] generarNombres(int cantidad) {
        String[] nombres = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            nombres[i] = "Estudiante" + (i + 1);
        }
        return nombres;
    }

    private static double[][] generarNotas(int cantidad) {
        double[][] notas = new double[cantidad][4];
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < 3; j++) {
                notas[i][j] = 1.0 + RANDOM.nextDouble() * 4.0;
            }
            notas[i][3] = calcularFinal(notas[i][0], notas[i][1], notas[i][2]);
        }
        return notas;
    }

    private static double calcularFinal(double nota1, double nota2, double nota3) {
        return Math.round((nota1 * 0.3 + nota2 * 0.3 + nota3 * 0.4) * 100.0) / 100.0;
    }

    private static void mostrarLista(int[] codigos, String[] nombres, double[][] notas) {
        for (int i = 0; i < Num_de_estudiantes; i++) {
            System.out.printf("Código: %d, Nombre: %s, Nota1: %.2f, Nota2: %.2f, Nota3: %.2f, Final: %.2f%n",
                    codigos[i], nombres[i], notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
        }
    }

    private static void ordenarPorNotaFinal(int[] codigos, String[] nombres, double[][] notas) {
        for (int i = 0; i < Num_de_estudiantes - 1; i++) {
            for (int j = 0; j < Num_de_estudiantes - i - 1; j++) {
                if (notas[j][3] < notas[j + 1][3]) {
                    int tempCodigo = codigos[j];
                    codigos[j] = codigos[j + 1];
                    codigos[j + 1] = tempCodigo;

                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;

                    double[] tempNotas = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = tempNotas;
                }
            }
        }
    }

    private static void buscarEstudiante(int[] codigos, String[] nombres, double[][] notas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el código del estudiante que quiere buscar: ");
        int codigoBuscado = scanner.nextInt();

        for (int i = 0; i < Num_de_estudiantes; i++) {
            if (codigos[i] == codigoBuscado) {
                System.out.printf("Estudiante encontrado - Código: %d, Nombre: %s, Nota1: %.2f, Nota2: %.2f, Nota3: %.2f, Final: %.2f%n",
                        codigos[i], nombres[i], notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
}


