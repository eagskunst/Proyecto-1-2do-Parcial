import java.util.InputMismatchException;
import java.util.Scanner;

import objetos_primitivos.Factura;
import objetos_primitivos.Producto;
import objetos_primitivos.ProductoTipo1;
import objetos_primitivos.ProductoTipo2;
import objetos_primitivos.Reporte;
import productos.Carne;
import productos.Enlatado;
import productos.LacteoLiquido;
import productos.LacteoSolido;
import productos.Viveres;

public class Administrador {
	private Producto[] listaProductos;
	private Factura[] facturas;
	private static int i = 0;
	private static int f = 0;
	
	public Administrador() {
		this.listaProductos= new Producto[100];
		this.facturas = new Factura[100];
	}
	
	public void menu() {
		Scanner s = new Scanner(System.in);
		int op = 1;
		do {
			imprimir("Bienvenido de nuevo");
			imprimir("Elija una opción según el número: ");
			imprimir("Añadir un producto al almacén (1)");
			imprimir("Modificar existencia del producto (2)");
			imprimir("Facturar venta (3)");
			imprimir("Mostrar ingresos brutos (4)");
			imprimir("Mostrar egresos de la empresa (5)");
			imprimir("Reporte exentos mayores ventas​ (6)");
			imprimir("Reporte productos existencia baja (7)");
			imprimir("Salir (8)");
			imprimir("Ingrese: ");
			try {
				op = s.nextInt();
			}catch(InputMismatchException e) {
				imprimir("Debe introducir un numero entero");
				s.nextLine();
			}
			s.nextLine();
			switch(op) {
				case 1:{
					agregarProducto(s);
					break;
				}
				case 2:{
					modificarProducto(s);
					break;
				}
				case 3:{
					facturarVenta(s);
					break;
				}
				case 4:{
					Reporte.mostrarIngresosBrutos(facturas);
					break;
				}
				case 5:{
					Reporte.mostrarEgresos(listaProductos);
					break;
				}
				case 6:{
					Reporte.reporteMejoresExentos(facturas);
					break;
				}
				case 7:{
					Reporte.reporteExistenciaBaja(listaProductos);
					break;
				}
				case 8:
					imprimir("Hasta pronto!");
					break;
				default:
					imprimir("Escoja una opción válida.");
					break;
				}
			imprimir("Presione enter para regresar al menu.");
			s.nextLine();
		}while(op!= 8);
		s.close();
	}
	
	private void agregarProducto(Scanner s) {
		imprimir("Ingrese el tipo de producto: ");
		String tipo_p = s.nextLine();
		imprimir("Ingrese el codigo del producto: ");
		String codigo = s.nextLine();
		int j = 0;
		while(listaProductos[j] != null) {
			if(listaProductos[j].getCodigo().equals(codigo)) {
				imprimir("Error al agregar el producto. Ya existe un producto con el mismo codigo");
				return;
			}
			j++;
		}
		imprimir("Ingrese la descripción del producto: ");
		String dscp = s.nextLine();
		imprimir("Ingrese el costo de compra del producto (Ej: 40,5): ");
		float costo = (float) s.nextDouble();
		imprimir("Ingrese el precio sin IVA del producto (Ej: 40,5): ");
		float precio = (float) s.nextDouble();
		imprimir("Ingrese la existencia del producto: ");
		int existencia = s.nextInt();
		s.nextLine();

		if(i<100) {
			if(tipo_p.compareToIgnoreCase("enlatado") == 0 || tipo_p.compareToIgnoreCase("enlatados") == 0 ) {
				imprimir("Ingrese la marca del producto: ");
				String marca = s.nextLine();
				listaProductos[i] = new Enlatado(existencia,codigo,dscp,costo,precio,marca);
				i+=1;
				imprimir("Producto agregado.");

			}
			else if(tipo_p.compareToIgnoreCase("viveres") == 0) {
				imprimir("Ingrese la marca del producto: ");
				String marca = s.nextLine();
				listaProductos[i] = new Viveres(existencia,codigo,dscp,costo,precio,marca);
				i+=1;
				imprimir("Producto agregado.");

			}
			else if(tipo_p.compareToIgnoreCase("lacteo")== 0 || tipo_p.compareToIgnoreCase("lacteos") == 0) {
				imprimir("El lacteo es liquido o solido?: ");
				tipo_p = s.nextLine();
				if(tipo_p.compareToIgnoreCase("solido") == 0) {
					listaProductos[i] = new LacteoSolido(existencia,codigo,dscp,costo,precio);
					i+=1;
					imprimir("Producto agregado.");
				}
				else {
					listaProductos[i] = new LacteoLiquido(existencia,codigo,dscp,costo,precio);
					i+=1;
					imprimir("Producto agregado.");
				}
			}
			else if(tipo_p.compareToIgnoreCase("carne") == 0 || tipo_p.compareToIgnoreCase("carnes") == 0) {
				listaProductos[i] = new Carne(existencia,codigo,dscp,costo,precio);
				i+=1;
				imprimir("Producto agregado.");
			}
			else {
				imprimir("Error al agregar el producto. El tipo de producto ingresado no esta a la venta en el supermercado.");
			}
		}
		else {
			imprimir("Error al agregar el producto. No se pueden agregar mas produtos.");
		}
		
	}
	
	private void modificarProducto(Scanner s) {
		imprimir("Ingrese el codigo del producto a modificar: ");
		String codigo = s.nextLine();
		int j = 0;
		boolean salir = false;
		while(listaProductos[j] != null && !salir) {
			if(listaProductos[j].getCodigo().equals(codigo)) {
				salir = true;
				imprimir("Anterior existencia: "+listaProductos[j].getExistencia());
				imprimir("Cuantos desea agregar?: ");
				int mas = s.nextInt();
				s.nextLine();
				//mas += listaProductos[j].getExistencia();
				listaProductos[j].setExistencia(mas + listaProductos[j].getExistencia());
				if(listaProductos[j] instanceof ProductoTipo1) {
					((ProductoTipo1) listaProductos[j]).mostrarDatos();
				}
				else {
					((ProductoTipo2) listaProductos[j]).mostrarDatos();
				}
				imprimir("Exito en modificacion");
				salir = true;
			}
			j++;
		}
		if(!salir) {
			imprimir("Error. No se encontro ningún producto con el código "+codigo+".");
		}
	}
	
	private void facturarVenta(Scanner s) {
		imprimir("Ingrese la cedula del cliente: ");
		String ced = s.nextLine();
		boolean vender = true;
		Producto productosVender[] = new Producto[20];
		int cant_v[] = new int[20];
		int k = 0;
		do {
			imprimir("Desea ver los codigos de los productos en inventario? Si (1): ");
			int op = s.nextInt();
			s.nextLine();
			if(op == 1) {
				System.out.println("CODIGOS: ");
				int j = 0;
				while(listaProductos[j]!= null) {
					System.out.print(listaProductos[j].getCodigo()+" ");
					j++;
				}
				System.out.println();
			}
			imprimir("Ingrese el codigo del producto a vender: ");
			String cod = s.nextLine();
			imprimir("Ingrese la cantidad a vender: ");
			int cant = s.nextInt();
			s.nextLine();
			for(int j = 0;j<listaProductos.length && listaProductos[j] != null;j++) {
				if(listaProductos[j].getCodigo().equals(cod)) {
					if(listaProductos[j].getExistencia()>= cant) {
						listaProductos[j].setExistencia(listaProductos[j].getExistencia() - cant);
						productosVender[k] = listaProductos[j];
						cant_v[k] = cant;
					}
					else {
						imprimir("Error. El producto con el codigo '"+cod+"' posee una existencia menor a "+cant+".");
						break;
					}
				}
			}
			imprimir("Desea agregar otro producto a la factura? Si (1): ");
			if(s.nextInt() != 1) {
				vender = false;
			}
		}while(vender);
		if(productosVender[0] != null) {
			facturas[f] = new Factura(productosVender,cant_v,ced);
			facturas[f].mostrarCalculo();
			f+=1;
		}
		else {
			imprimir("Venta cancelada.");
		}
	}

	public void imprimir(Object o) {
		System.out.println(o);
	}
}
