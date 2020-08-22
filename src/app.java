
public class app {

	public static void main(String[] args) {
		var c = new Cliente();
		var a = new Asesor();
//		Cliente c;
//		Asesor a;
//		Factura f;
		var f = new Factura(a, c);
		f.AgregarItem(0001, 1);
		f.imprimirFactura();
		
		System.out.println("Hello Workd");
	}

}
