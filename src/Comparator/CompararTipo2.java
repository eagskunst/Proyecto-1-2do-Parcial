package Comparator;

import java.util.Comparator;

import objetos_primitivos.ProductoTipo2;

public class CompararTipo2 implements Comparator<ProductoTipo2>{
	
	@Override
	public int compare(ProductoTipo2 o1, ProductoTipo2 o2) {
		if(o1.getGanancia()<o2.getGanancia()) return -1;
		if(o1.getGanancia()>o2.getGanancia()) return 1;
		return 0;
	}

}
