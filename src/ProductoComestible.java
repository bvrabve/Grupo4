import java.util.Date;

public class ProductoComestible extends Producto {
    protected Date fechaVencimiento;

public ProductoComestible() {
    this.fechaVencimiento = new Date();
    super(codigo, nombre, precio);

}

    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

    @Override
public void mostrarInformacion(){
        System.out.println("COMESTIBLE - Nombre: " + nombre + ", Precio: " + precio + ", Vence: " + fecha);
    }
}
