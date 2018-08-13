package objetos_primitivos;

import java.util.ArrayList;
import java.util.Collections;

import Comparator.CompararTipo2;
import productos.Carne;

public class Reporte {
	
	public static void mostrarIngresosBrutos(Factura facturas[]) {
		float ingresos = 0;
		for(Factura f:facturas) {
			if(f == null)
				break;
			else
				ingresos += f.getTotal3();
		}
		System.out.println("Total de ingresos brutos: "+ingresos);
	}
	
	public static void mostrarEgresos(Producto productos[]) {
		float egresos = 0;
		for(Producto p:productos) {
			if(p == null) {
				break;
			}
			else {
				egresos+= (float)(p.getCostoCompra() * p.getExistencia());
			}
		}
		System.out.println("Total de egresos de la empresa: "+egresos);
	}
	
	public static void reporteMejoresExentos(Factura f[]) {
		ArrayList<ProductoTipo2> pExentos = new ArrayList<>();
		int i = 0;
		for(Factura fact:f) {
			if(fact==null)
				break;
			else {
				for(Producto p:fact.getListaProductos()) {
					if(p == null) 
						break;
					else {
						if(p instanceof ProductoTipo2) {
							pExentos.add(new Carne((ProductoTipo2) p));
							i++;	
						}
					}
				}
			}
		}
		Collections.sort(pExentos,new CompararTipo2());
		for(i = 0;i<pExentos.size() && i<10;i++) {
			pExentos.get(i).mostrarDatos();
		}
	}
	
	public static void reporteExistenciaBaja(Producto productos[]) {
		System.out.println("Mostrando datos de productos cuya existencia actual es menor a diez(10): ");
		for(Producto p:productos) {
			if(p == null)
				break;
			else {
				if(p.getExistencia()<10) {
					if(p instanceof ProductoTipo1) {
						((ProductoTipo1)p).mostrarDatos();
					}
					else {
						((ProductoTipo2)p).mostrarDatos();
					}
				}
			}
		}
	}

}
