public abstract class Animal {
    private String nombre;
    private String id;
    private boolean sano;

    public Animal(String nombre, String id, boolean sano) {
        this.nombre = nombre;
        this.id = id;
        this.sano = sano;
    }

    // Getters (Encapsulación)
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public boolean isSano() {
        return sano;
    }

    // Método abstracto (Polimorfismo)
    public abstract String tipo();

    @Override
    public String toString() {
        return "Tipo: " + tipo() +
                " | Nombre: " + nombre +
                " | ID: " + id +
                " | Sano: " + (sano ? "Sí" : "No");
    }

    public String toFileString() {
        return tipo() + "," + nombre + "," + id + "," + sano;
    }
}
