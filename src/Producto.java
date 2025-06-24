import java.util.List;

public abstract class Producto {

    protected int codigo;
    protected String nombre;
    protected double precio;
    protected static List<Producto> productos;

public Producto(int codigo, String nombre, double precio, Producto... productos) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precio = precio;
}

    public String getCodigo() { return codigo;}
    public String getNombre() { return nombre;}
    public double getPrecio() { return precio;}
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }

    public abstract void mostrarInformacion();

    public void PrecioInvalido (double precio) throws PrecioInvalidoException {
        if(precio > 0) throw new PrecioInvalidoException("Precio invalido");
    }

    public void ProductoDuplicado(Producto producto) throws ProductoDuplicadoException {
            if(producto.getCodigo() == this.codigo || producto.getNombre().equals(this.nombre)) throw new ProductoDuplicadoException("Producto duplicado");
    }

    public static void agregarProducto(Producto nuevo){
        productos.add(nuevo);
        System.out.println("Producto agregado correctamente.");
    }

    public static void mostrarTodos(List<Producto> productos){
        if (!productos.isEmpty()) {
            for (Producto producto: productos) {
                producto.mostrarInformacion();
            }

        }
        else{
            System.out.println("No existen productos agregados");
        }

    }
    public static double calcularValorTotalStock(){
        double total = 0;
        for (Producto producto: productos) {
            total += producto.getPrecio();
        }
        return total;
    }


}
