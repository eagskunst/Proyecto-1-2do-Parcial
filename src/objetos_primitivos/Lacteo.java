package objetos_primitivos;

public abstract class Lacteo extends ProductoTipo2 {
	public Lacteo(int existencia, String codigo, String dscp, float costoCompra, float precioNoIVA) {
		super(existencia, codigo, dscp, costoCompra, precioNoIVA);
		// TODO Auto-generated constructor stub
	}

	abstract public void tipoLacteo();
}
