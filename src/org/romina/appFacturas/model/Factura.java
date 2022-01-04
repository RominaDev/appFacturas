package org.romina.appFacturas.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

	private int folio;
	private String descripcion;
	private Date fecha;
	private Cliente cliente;
	private ItemFactura[] items;
	private int indiceItems;
	private static final int MAX_ITEMS = 12;

	private static int ultimoFolio;

	public Factura(String descripcion, Cliente cliente) {

		this.descripcion = descripcion;
		this.cliente = cliente;
		this.items = new ItemFactura[MAX_ITEMS];
		this.folio = ++ultimoFolio; // preincremento pra q comience en uno
		this.fecha = new Date(); // fecha actual
	}

	public int getFolio() {
		return folio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemFactura[] getItems() {
		return items;
	}

//agregar
	public void addItemFactura(ItemFactura item) {
		if (indiceItems < MAX_ITEMS) {
			this.items[indiceItems++] = item;
		}
	}

	public float calcularTotal() {
		float total = 0.0f;

		for (int i = 0; i < indiceItems; i++) {
			total += this.items[i].calcularImporte();
		}
		return total;

	}

	public String generarDetalle() {

		StringBuilder sb = new StringBuilder();
		SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM,yyyy");
		sb.append("Fecha de emision : ").append(df.format(this.fecha)).append("\n");

		sb.append("Factura n° : ").append(folio).append("\nCliente : ").append(this.cliente.getNombre())
				.append("\nNIF : ").append(this.cliente.getNif()).append("\ndescripcion : ").append(this.descripcion)
				.append("\n").append("\n#\tNombre\t$\tCant\tTotal\n");

		// va a iterar hasta la cantidad de prod q agreguemos
		for (int i = 0; i < indiceItems; i++) {
			// imprime el toString de la clase itemfactura
			sb.append(this.items[i].toString());
		}
		sb.append("\nTOTAL :").append(this.calcularTotal());
		return sb.toString();

	}

	@Override
	public String toString() {
		return "Detalle : " + generarDetalle();
	}

}
