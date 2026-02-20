import java.util.ArrayList;
import java.util.List;

public class Veterinaria {

    private List<Animal> animales;
    private FicheroAnimales fichero;

    public Veterinaria(FicheroAnimales fichero) {
        this.fichero = fichero;
        this.animales = fichero.cargar();
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

    public void guardar() {
        fichero.guardar(animales);
        System.out.println("Datos guardados correctamente.");
    }
}
