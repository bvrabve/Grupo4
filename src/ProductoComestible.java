import java.util.Date;

public class ProductoComestible extends Producto {
    private Date fechaVencimiento;

    public ProductoComestible(int codigo, String nombre, double precio, Date fechaVencimiento) {
        super(codigo, nombre, precio);
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFecha() {
        return fechaVencimiento;
    }

    public void setFecha(Date fecha) {
        this.fechaVencimiento = fecha;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("COMESTIBLE - Nombre: " + getNombre() +
                ", Precio: " + getPrecio() +
                ", Vence: " + fechaVencimiento);
    }
}