import java.util.ArrayList;

public class Factura extends Precio {
	Asesor asesor;
	Cliente cliente;
	ArrayList<Item> items = new ArrayList<Item>();
	
	Factura(Asesor asesor, Cliente client) {
		
	}
	
	public void imprimirFactura() {
		String result = new String();
		
		for(Item item : items) {
			//app.productos.
			result += "item \n";
		}
		
		System.out.println(result);
	}

	public void AgregarItem(int id, int cantidad) {
		var item = new Item();
		items.add(item);
	}
}
