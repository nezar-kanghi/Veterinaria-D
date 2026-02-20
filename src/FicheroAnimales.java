import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FicheroAnimales {

    private String archivo;

    public FicheroAnimales(String archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Animal> animales) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Animal a : animales) {
                bw.write(a.toFileString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public List<Animal> cargar() {

        List<Animal> lista = new ArrayList<>();
        File file = new File(archivo);

        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String tipo = datos[0];
                String nombre = datos[1];
                String id = datos[2];
                boolean sano = Boolean.parseBoolean(datos[3]);

                if (tipo.equals("Perro")) {
                    lista.add(new Perro(nombre, id, sano));
                } else if (tipo.equals("Gato")) {
                    lista.add(new Gato(nombre, id, sano));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar el archivo.");
        }

        return lista;
    }
}