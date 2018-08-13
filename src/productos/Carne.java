package productos;

import objetos_primitivos.ProductoTipo2;

public class Carne extends ProductoTipo2{

	public Carne(int existencia, String codigo, String dscp, float costoCompra, float precioNoIVA) {
		super(existencia, codigo, dscp, costoCompra, precioNoIVA);
		// TODO Auto-generated constructor stub
	}
	
	public Carne(ProductoTipo2 p) {
		super(p.getExistencia(),p.getCodigo(), p.getDscp(), p.getCostoCompra(), p.getPrecioNoIVA());
		this.ganancia = p.getGanancia();
	}

}
