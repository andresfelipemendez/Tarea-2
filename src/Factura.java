import java.util.ArrayList;

public class Factura extends Precio {
	Asesor asesor;
	Cliente cliente;
	ArrayList<Item> items = new ArrayList<Item>();
	
	Factura(Asesor asesor, Cliente client) {
		
	}
	
	public void imprimirFactura() {
		String result = new String();
		int total = 0;
		for(Item item : items) {
			Producto p = app.productos.get(item.idProcuto);
			result += p.name + "\t\t" + p.precio + "\t" + item.cantidad * p.precio +"\n";
			total += item.cantidad * p.precio;
		}
		
		result += "Sub Total: " + total  + "\n";
		result += "IVA %:"      + 0      + "\n";
		
		System.out.println(result);
	}

	public void AgregarItem(int id, int cantidad) {
		var item = new Item();
		item.cantidad = cantidad;
		item.idProcuto = id;
				
		items.add(item);
	}
}
