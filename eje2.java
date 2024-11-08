package ejercicios;
	
	import java.util.*;

	public class eje2 {

	    private static final int Num_de_empleados = 5;  
	    private static final Random RANDOM = new Random();

	    public static void main(String[] args) {

	        int[] identificaciones = generarIdentificaciones(Num_de_empleados);
	        String[] nombres = generarNombres(Num_de_empleados);
	        double[][] sueldos = generarSueldos(Num_de_empleados);

	        System.out.println("Lista de Empleados:");
	        mostrarLista(identificaciones, nombres, sueldos);

	        ordenarPorNombre(identificaciones, nombres, sueldos);

	        System.out.println("\nLista de Empleados ordenada por nombre:");
	        mostrarLista(identificaciones, nombres, sueldos);

	        buscarEmpleado(identificaciones, nombres, sueldos);
	    }

	    private static int[] generarIdentificaciones(int cantidad) {
	        return RANDOM.ints(cantidad, 1000, 2001).toArray();
	    }

	    private static String[] generarNombres(int cantidad) {
	        String[] nombres = new String[cantidad];
	        for (int i = 0; i < cantidad; i++) {
	            nombres[i] = "Empleado" + (i + 1);
	        }
	        return nombres;
	    }

	    private static double[][] generarSueldos(int cantidad) {
	        double[][] sueldos = new double[cantidad][3];  
	        for (int i = 0; i < cantidad; i++) {
	            sueldos[i][0] = 1000 + RANDOM.nextDouble() * 4000; 
	            sueldos[i][1] = sueldos[i][0] * 0.1;               
	            sueldos[i][2] = calcularNeto(sueldos[i][0], sueldos[i][1]);
	        }
	        return sueldos;
	    }

	    private static double calcularNeto(double sueldoBasico, double deducciones) {
	        return Math.round((sueldoBasico - deducciones) * 100.0) / 100.0;
	    }

	    private static void mostrarLista(int[] identificaciones, String[] nombres, double[][] sueldos) {
	        for (int i = 0; i < Num_de_empleados; i++) {
	            System.out.printf("ID: %d, Nombre: %s, Sueldo Básico: %.2f, Deducciones: %.2f, Neto a Pagar: %.2f%n",
	                    identificaciones[i], nombres[i], sueldos[i][0], sueldos[i][1], sueldos[i][2]);
	        }
	    }

	    private static void ordenarPorNombre(int[] identificaciones, String[] nombres, double[][] sueldos) {
	        for (int i = 0; i < Num_de_empleados - 1; i++) {
	            for (int j = 0; j < Num_de_empleados - i - 1; j++) {
	                if (nombres[j].compareTo(nombres[j + 1]) > 0) {
	                	
	                    int tempId = identificaciones[j];
	                    identificaciones[j] = identificaciones[j + 1];
	                    identificaciones[j + 1] = tempId;

	                    String tempNombre = nombres[j];
	                    nombres[j] = nombres[j + 1];
	                    nombres[j + 1] = tempNombre;

	                    double[] tempSueldos = sueldos[j];
	                    sueldos[j] = sueldos[j + 1];
	                    sueldos[j + 1] = tempSueldos;
	                }
	            }
	        }
	    }

	    private static void buscarEmpleado(int[] identificaciones, String[] nombres, double[][] sueldos) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("\nIngrese el número de identificación del empleado que quiere buscar: ");
	        int idBuscado = scanner.nextInt();

	        for (int i = 0; i < Num_de_empleados; i++) {
	            if (identificaciones[i] == idBuscado) {
	                System.out.printf("Empleado encontrado - ID: %d, Nombre: %s, Sueldo Básico: %.2f, Deducciones: %.2f, Neto a Pagar: %.2f%n",
	                        identificaciones[i], nombres[i], sueldos[i][0], sueldos[i][1], sueldos[i][2]);
	                return;
	            }
	        }
	        System.out.println("Empleado no encontrado.");
	    }
	}



