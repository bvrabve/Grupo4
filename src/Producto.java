import java.util.List;

public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected double precio;
    protected List<Producto> productos;

public Producto(String codigo, String nombre, double precio) {
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
        if(producto.getCodigo().equals(this.codigo) || (producto.getNombre().equals(this.nombre))) throw new ProductoDuplicadoException("Producto duplicado");

    }


}
