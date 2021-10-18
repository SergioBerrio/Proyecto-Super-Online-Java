package paqueteAplicacion;

import java.util.Scanner;

public class Otros extends NoPerecedero {

	private String categoria;
	private double VALOR_IVA = 0.16;
	
	public Otros(int codigo, String nombre, double precio, int cantidad, double peso, String categoria) {
		super(codigo, nombre, precio, cantidad, peso);
		this.categoria = categoria;

	}

	public Otros(){

	}
	
	public Otros(Scanner in) {
		super(in);
		
		System.out.println("Introduce la categoría:");
		this.categoria = in.nextLine();
		
		System.out.println("Introduce el valor del IVA:");
		this.VALOR_IVA = in.nextDouble();
		
	}
	
	public String volcar() {
		return super.volcar() + "   Producto de categoría:" + categoria;
	}
	
	public void imprimir() {
		super.imprimir();
		System.out.print(" " + categoria + "\n");
	}
	
	/*public String getCategoria() {
		return categoria;
	}*/

	@Override
	public String getLote() {
		return null;
	}

	@Override
	public String getCategoria() {
		return categoria;
	}

	@Override
	public String getFechaCaducidad() {
		return null;
	}

	@Override
	public String getOrigen() {
		return null;
	}

	@Override
	public String getGraduacion() {
		return null;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
