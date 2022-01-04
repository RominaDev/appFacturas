package org.romina.appFacturas;

import java.util.Scanner;

import org.romina.appFacturas.model.*;

public class EjemploFactura {
	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNif("555-5");
		cliente.setNombre("Andres");
		Scanner sc = new Scanner(System.in);
		System.out.println("ingrese la descripcion de la factura");
		Factura factura = new Factura(sc.nextLine(), cliente);

		Producto producto;

		System.out.println();

		for (int i = 0; i < 2; i++) {
			producto = new Producto();

			System.out.print("ingrese el producto n° : " + producto.getCodigo() + " : ");
			producto.setNombre(sc.nextLine());

			System.out.print("ingrese el precio  : ");
			producto.setPrecio(sc.nextFloat());

			System.out.print("ingrese la cantidad  : ");
			factura.addItemFactura(new ItemFactura(sc.nextInt(), producto));
			System.out.println();
			sc.nextLine();
		}

		System.out.print(factura);
	}
}
