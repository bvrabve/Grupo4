import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Calcular valor total del stock");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar salto de línea

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Ingrese el tipo del producto (1 = Comestible, 2 = Limpieza): ");
                        int tipo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.nextLine();

                        System.out.print("Ingrese el código del producto: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Ingrese el precio del producto: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        if (tipo == 1) {
                            System.out.print("Ingrese la fecha de vencimiento (dd/MM/yyyy): ");
                            String fechaStr = sc.nextLine();
                            Date fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);

                            ProductoComestible pc = new ProductoComestible(codigo, nombre, precio, fechaVencimiento);
                            Producto.agregarProducto(pc);
                        } else if (tipo == 2) {
                            System.out.print("Ingrese el tipo de uso: ");
                            String tipoUso = sc.nextLine();

                            ProductoLimpieza pl = new ProductoLimpieza(codigo, nombre, precio, tipoUso);
                            Producto.agregarProducto(pl);
                        } else {
                            System.out.println("Tipo de producto no válido.");
                        }

                    } catch (ProductoDuplicadoException e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    } catch (PrecioInvalidoException e) {
                        System.out.println("⚠️ Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("⚠️ Error al ingresar el producto. Asegúrese de ingresar los datos correctamente.");
                    }
                    break;

                case 2:
                    Producto.mostrarTodos();
                    break;

                case 3:
                    double total = Producto.calcularValorTotalStock();
                    System.out.printf("El valor total del stock es: %.2f\n", total);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}
