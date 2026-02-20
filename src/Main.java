import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FicheroAnimales fichero = new FicheroAnimales("animales.txt");
        Veterinaria vet = new Veterinaria(fichero);

        int opcion;

        do {
            System.out.println("--- VETERINARIA ---");
            System.out.println("1. Añadir animal");
            System.out.println("2. Ver animales");
            System.out.println("3. Guardar animales");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Tipo (Perro/Gato): ");
                    String tipo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("¿Está sano? (true/false): ");
                    boolean sano = sc.nextBoolean();

                    if (tipo.equalsIgnoreCase("Perro")) {
                        vet.agregarAnimal(new Perro(nombre, id, sano));
                    } else if (tipo.equalsIgnoreCase("Gato")) {
                        vet.agregarAnimal(new Gato(nombre, id, sano));
                    } else {
                        System.out.println("Tipo no válido.");
                    }
                    break;

                case 2:
                    vet.mostrarAnimales();
                    break;

                case 3:
                    vet.guardar();
                    break;

                case 4:
                    vet.guardar();
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}