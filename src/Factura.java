import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.text.NumberFormat;
import java.util.Locale;


public class Factura extends Precio {

	ArrayList<Item> items = new ArrayList<Item>();
	
	private int AnchoFactura = 40;
	
	Factura(Asesor asesor, Cliente cliente) {
		super(asesor, cliente);
	}
	
	private String BreakLine() {
		String res = new String();
		for (int i = 0; i < AnchoFactura; i++) {
			res += "-";
		}
		return res;
	}
	
	private String FormatoDinero(int value) {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		String toString = format.format(value);
		toString = toString.substring(0, toString.length() - 3);
		return toString;
	}
	
	private String CalcularPaddingColumna(String palabra) {
		String res = new String();
		int wordColumWidth = 15;
		int padding = wordColumWidth - palabra.length();
		for (int i = 0; i < padding; i++) {
			res += " ";
		}
		return res;
	}
	
	private String AlinearDerecha(int value) 
	{
		String res = new String();
		
		String toString = FormatoDinero(value);
		
		// se puede representar hasta el millon
		int maxNumberSize = 9;

		int padding = maxNumberSize - toString.length();
		for (int i = 0; i < padding; i++) {
			res += " ";
		}
		res += toString;
		return res;
	}
	
	private String AlinearDerecha(String pinLeft, int value) 
	{
		String res = new String();
		int padding = AnchoFactura - pinLeft.length();
		
		String toString = FormatoDinero(value);
		padding -= toString.length();
		res += pinLeft;
		for (int i = 1; i < padding; i++) {
			res += " ";
		}
		res += toString;
		return res;
	}
	
	public void imprimirFactura() {
		String result = new String();
		// necesito saber cual es el numero mas grande/ancho
		
		//nombre tienda
		result += "\n Muebles y Papeleria su Oficina \n";
		result += BreakLine() + "\n";
		
		// informacion asesor
		result += "Atentido por: " + asesor.nombre + "\n"; 
				
		// informacion cliente
		result += "Factura para: " + cliente.nombre + "\n";
		result += BreakLine() + "\n";
		
		// fecha
		result += "Fecha: ";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		result += dtf.format(now) + "\n";
		result += BreakLine() + "\n";
		
		float subtotal = 0;
		for(Item item : items) {
			Producto p = app.productos.get(item.idProcuto);
			result += " " +
					item.cantidad + " " + 
					p.name + CalcularPaddingColumna(p.name) + " " + 
					AlinearDerecha(p.precio) + " " + 
					AlinearDerecha(item.cantidad * p.precio) +"\n";
			
			subtotal += item.cantidad * p.precio;
		}
		result += BreakLine() + "\n";
		
		float iva = subtotal * 0.19f;
		result += AlinearDerecha("IVA 19% : ", Math.round( iva ) ) + "\n";
		result += BreakLine() + "\n";
		
		float total = subtotal + iva;
		result +=  AlinearDerecha("Total : ", Math.round( total ) ) + "\n";
		
		System.out.println(result);
	}

	public void AgregarItem(int id, int cantidad) {
		var item = new Item();
		item.cantidad = cantidad;
		item.idProcuto = id;
				
		items.add(item);
	}
}
