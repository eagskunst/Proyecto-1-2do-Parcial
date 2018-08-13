package objetos_primitivos;


public class Producto{
	private int existencia;
	private String codigo;
	private String dscp;
	private float costoCompra;
	private float precioNoIVA;
	
	public Producto(int existencia, String codigo, String dscp, 
			float costoCompra,float precioNoIVA) {
		this.existencia = existencia;
		this.codigo = codigo;
		this.dscp = dscp;
		this.costoCompra = costoCompra;
		this.precioNoIVA = precioNoIVA;
	}
	


	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDscp() {
		return dscp;
	}

	public void setDscp(String dscp) {
		this.dscp = dscp;
	}

	public float getCostoCompra() {
		return costoCompra;
	}

	public void setCostoCompra(float costoCompra) {
		this.costoCompra = costoCompra;
	}

	public float getPrecioNoIVA() {
		return precioNoIVA;
	}

	public void setPrecioNoIVA(float precioNoIVA) {
		this.precioNoIVA = precioNoIVA;
	}
	
	


}
