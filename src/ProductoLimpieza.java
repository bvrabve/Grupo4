public class ProductoLimpieza extends Producto {
    private String tipoUso;

    public ProductoLimpieza(int codigo, String nombre, double precio, String tipoUso) {
        super(codigo, nombre, precio);
        this.tipoUso = tipoUso;
    }

    public String getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(String tipoUso) {
        this.tipoUso = tipoUso;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("LIMPIEZA - Nombre: " + getNombre() +
                ", Precio: " + getPrecio() +
                ", Tipo: " + tipoUso);
    }
}
