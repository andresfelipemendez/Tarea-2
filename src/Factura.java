import java.util.ArrayList;

public class Factura extends Precio {
	Asesor asesor;
	Cliente cliente;
	ArrayList<Item> items;
	
	
	Factura(Asesor asesor, Cliente client) {
		
	}
	
	public void imprimirFactura() {
		
	}

	public void AgregarItem(int id, int cantidad) {
		var item = new Item();
		items.add(item);
	}
}
