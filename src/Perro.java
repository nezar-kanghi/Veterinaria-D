public class Perro extends Animal {

    public Perro(String nombre, String id, boolean sano) {
        super(nombre, id, sano);
    }

    @Override
    public String tipo() {
        return "Perro";
    }
}
