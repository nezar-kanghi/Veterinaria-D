import java.io.*;
import java.util.ArrayList;

public class Veterinaria {

    private ArrayList<Animal> animales;
    private final String archivo = "animales.txt";

    public Veterinaria() {
        animales = new ArrayList<>();
        cargarDesdeFichero();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal a : animales) {
                System.out.println(a);
            }
        }
    }

    public void guardarEnFichero() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Animal a : animales) {
                bw.write(a.toFileString()); //transforma en texto
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    private void cargarDesdeFichero() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String tipo = datos[0];
                String nombre = datos[1];
                String id = datos[2];
                boolean sano = Boolean.parseBoolean(datos[3]); //transforma el texto a boolean

                if (tipo.equals("Perro")) {
                    animales.add(new Perro(nombre, id, sano));
                } else if (tipo.equals("Gato")) {
                    animales.add(new Gato(nombre, id, sano));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo.");
        }
    }
}
