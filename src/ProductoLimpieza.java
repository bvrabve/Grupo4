public class ProductoLimpieza extends Producto{
    private String tipoUso;

    public ProductoLimpieza(int codigo, String tipoUso, double nombre, String precio) {
        super(codigo, nombre, precio);
        this.tipoUso = tipoUso;
    }

    //getters

    public String getTipoUso() {
        return tipoUso;
    }

    // setters

    public void setTipoUso(String tipoUso) {
        this.tipoUso = tipoUso;
    }

    @Override

    public void mostrarInformacion(){
        System.out.println("LIMPIEZA - Nombre: " + nombre + ", Precio: " + precio + ", Tipo: " + tipoUso);
    }

    @Override
    public void mostrarInformacion() {

    }
}
