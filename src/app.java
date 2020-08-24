import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class app {
	
	static Map<Integer, Producto> productos = new  HashMap<Integer, Producto>() ;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			Producto p = new Producto("item" + i);
			productos.put(i, p);
		}
		
		
		var c = new Cliente();
		var a = new Asesor();

		var f = new Factura(a, c);
		f.AgregarItem(0001, 1);
		f.imprimirFactura();
		
		System.out.println("Hello Workd");
	}

}
