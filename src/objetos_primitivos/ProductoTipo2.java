package objetos_primitivos;


public class ProductoTipo2 extends Producto{
	protected float ganancia;
	public ProductoTipo2(int existencia, String codigo, String dscp, float costoCompra, 
			float precioNoIVA) {
		super(existencia, codigo, dscp, costoCompra, precioNoIVA);
		this.ganancia = 0;
	}
	
	
	public void mostrarDatos() {
		System.out.println("Codigo: "+super.getCodigo());
		System.out.println("Existencia: "+super.getExistencia());
		System.out.println("Descripcion: "+super.getDscp());
		System.out.println("Costo de compra: "+super.getCostoCompra());
		System.out.println("Precio sin IVA: "+super.getPrecioNoIVA());
	}
	
	public float getGanancia() {
		return this.ganancia;
	}
	
	public void setGanancia(float g) {
		this.ganancia = g;
	}
	

}
