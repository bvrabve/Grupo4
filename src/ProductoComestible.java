import java.util.Date;

public class ProductoComestible extends Producto {
    protected Date fecha;

public ProductoComestible() {
    fecha = new Date();
    super(codigo, nombre, precio);
}

    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

    @Override
    public void mostrarInformacion() {

    }
}
