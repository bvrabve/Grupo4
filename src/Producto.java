import java.util.ArrayList;
import java.util.List;

public abstract class Producto {

    protected int codigo;
    protected String nombre;
    protected double precio;
    protected static List<Producto> productos;

    static {
        productos = new ArrayList<>();
    }

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Método abstracto
    public abstract void mostrarInformacion();

    // Validaciones
    public static void validarPrecio(double precio) throws PrecioInvalidoException {
        if (precio <= 0) throw new PrecioInvalidoException("Precio inválido");
    }

    public static void validarProductoDuplicado(Producto nuevo) throws ProductoDuplicadoException {
        for (Producto p : productos) {
            if (p.getCodigo() == nuevo.getCodigo() || p.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                throw new ProductoDuplicadoException("Producto duplicado");
            }
        }
    }

    // Operaciones con la lista
    public static void agregarProducto(Producto nuevo) throws ProductoDuplicadoException, PrecioInvalidoException {
        validarProductoDuplicado(nuevo);
        validarPrecio(nuevo.getPrecio());
        productos.add(nuevo);
        System.out.println("Producto agregado correctamente.");
    }

    public static void mostrarTodos() {
        if (!productos.isEmpty()) {
            for (Producto producto : productos) {
                producto.mostrarInformacion();
            }
        } else {
            System.out.println("No existen productos agregados");
        }
    }

    public static double calcularValorTotalStock() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
