import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n MENÚ");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Calcular valor total del stock");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo del producto (1= Comestible, 2=Limpieza)");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Ingrese el codigo del producto: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el precio del producto: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    try {
                        if (tipo == 1) {
                            //Aca se construye un producto COMESTIBLE
                            System.out.println("Fecha de vencimiento (dd/MM/yyyy): ");
                            String fechaStr = sc.nextLine();
                            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                            ProductoComestible pc = new ProductoComestible(codigo, nombre, precio, fecha);
                            Producto.agregarProducto (pc); //Agrego el producto a la lista
                        }
                        else if (tipo == 2) {
                            //Aca construyo producto Limpieza
                            System.out.println("Tipo de uso: ");
                            String uso = sc.nextLine();
                            ProductoLimpieza pl = new ProductoLimpieza(codigo, nombre, precio, uso);
                            Producto.agregarProducto(pl); //Se agrega a la lista
                        }
                        else {
                            System.out.println("Tipo no valido");
                        }
                    } catch (ProductoDuplicadoException e) {
                        System.out.println(e.getMessage());
                    } catch (PrecioInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e)  {
                        System.out.println("Error al ingresar el producto.");
                    }
                    break;

                case 2:
                    Producto.mostrarTodos();
                    break;

                case 3:
                    double total = Producto.calcularValorTotalStock();
                    System.out.println("El total del stock es: " + total);
                    break;

                default:
                    System.out.println("Opcion no valida");

            }


        } while (opcion !=4);
        sc.close();
    }
}
