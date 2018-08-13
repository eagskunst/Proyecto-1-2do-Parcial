package objetos_primitivos;

public abstract class ProductoTipo1 extends Producto{
	private String marca;

	public ProductoTipo1(int existencia, String codigo, String dscp, float costoCompra, 
			float precioNoIVA, String marca) {
		super(existencia, codigo, dscp, costoCompra, precioNoIVA);
		
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void mostrarDatos() {
		System.out.println("Codigo: "+super.getCodigo());
		System.out.println("Existencia: "+super.getExistencia());
		System.out.println("Descripcion: "+super.getDscp());
		System.out.println("Costo de compra: "+super.getCostoCompra());
		System.out.println("Precio sin IVA: "+super.getPrecioNoIVA());
		System.out.println("Marca: "+this.marca);
	}

}
