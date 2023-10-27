import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElectroTechStore tienda = new ElectroTechStore("dispositivos.csv");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Desplegar la información de cada dispositivo");
            System.out.println("2. Validar elementos encendidos y apagados");
            System.out.println("3. Guardar dispositivos en un archivo CSV");
            System.out.println("4. Cargar dispositivos desde un archivo CSV");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    tienda.mostrarInformacion();
                    break;
                case 2:
                    tienda.validarEncendidos();
                    break;
                case 3:
                    tienda.guardarEnCSV();
                    System.out.println("Dispositivos guardados en CSV.");
                    break;
                case 4:
                    tienda.cargarDesdeCSV();
                    System.out.println("Dispositivos cargados desde CSV.");
                    break;
                case 5:
                    System.out.println("¡Adiós!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
    }
}