package objetos_primitivos;

public class Factura {
	private Producto listaProductos[];
	private int cant_venta[];
	private String cedula;
	private float total1;
	private float total2;
	private float total3;
	private float IVA;
	
	public Factura(Producto[] p, int cant_venta[], String cedula) {
		this.listaProductos = p;
		this.cant_venta = cant_venta;
		this.cedula = cedula;
		total1 = 0;
		total2 = 0;
		total3 = 0;
		IVA = 0;
		calcular();
	}
	
	public void calcular() {
		for(int i = 0;i<listaProductos.length && listaProductos[i] != null;i++) {
			if(listaProductos[i] instanceof ProductoTipo1) {
				float iva = (float) (listaProductos[i].getPrecioNoIVA() * 0.12) * cant_venta[i];
				IVA += iva;
				total2 += (listaProductos[i].getPrecioNoIVA() * cant_venta[i]) + iva;
			}
			else{
				((ProductoTipo2)listaProductos[i]).setGanancia(listaProductos[i].getPrecioNoIVA() * cant_venta[i]);
				total1 += listaProductos[i].getPrecioNoIVA() * cant_venta[i];
			}
		}
		total3 = total1+total2;
	}
	
	public void mostrarCalculo() {
		System.out.println("Total de productos exentos de IVA: "+total1);
		System.out.println("Total de productos con IVA: "+total2);
		System.out.println("Total a pagar por concepto de IVA: "+IVA);
		System.out.println("Total general a pagar: "+total3);
	}
	
	public Producto[] getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Producto[] listaProductos) {
		this.listaProductos = listaProductos;
	}

	public int[] getCant_venta() {
		return cant_venta;
	}
	public void setCant_venta(int cant_venta[]) {
		this.cant_venta = cant_venta;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public float getTotal1() {
		return total1;
	}

	public float getTotal2() {
		return total2;
	}

	public float getTotal3() {
		return total3;
	}
	
	
	
}
