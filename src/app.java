import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class app {
	
	static Map<Integer, Producto> productos = new  HashMap<Integer, Producto>() ;
	
	public static void main(String[] args) {
		
		AgregarInventario(3001, "lampara", 1000);
		AgregarInventario(3002, "escritorio", 35000);
		AgregarInventario(3003, "silla", 20000);
		AgregarInventario(3004, "Silla Ejecutiva", 25000);
		
		var c = new Cliente();
		var a = new Asesor();

		var f = new Factura(a, c);
		f.AgregarItem(3001, 1);
		f.AgregarItem(3002, 2);
		f.AgregarItem(3003, 1);
		f.AgregarItem(3004, 1);
		f.imprimirFactura();
		
		System.out.println("Hello Workd");
	}
	
	static void AgregarInventario(int id, String nombre, int precio) {
		Producto p = new Producto(nombre, precio);
		productos.put(id, p);
	}

}
