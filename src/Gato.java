public class Gato extends Animal {

    public Gato(String nombre, String id, boolean sano) {
        super(nombre, id, sano);
    }

    @Override
    public String tipo() {
        return "Gato";
    }
}
