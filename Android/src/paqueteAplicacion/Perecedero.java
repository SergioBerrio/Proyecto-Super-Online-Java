package paqueteAplicacion;

import java.util.Scanner;

public abstract class Perecedero extends Producto implements Enviable {
	
	private String fechacad;

	public Perecedero(int codigo, String nombre, double precio, int cantidad, double peso, String fecha) {
		super(codigo, nombre, precio, cantidad, peso);
		this.fechacad = fecha;
	}

	public Perecedero(){

	}

	public String getFechacad() {
		return fechacad;
	}

	public void setFechacad(String fechacad) {
		this.fechacad = fechacad;
	}

	public Perecedero(Scanner in) {
		super(in);
		System.out.println("Fecha de caducidad del producto:");
		this.fechacad = in.nextLine();
	}
	
	public void imprimir() {
		super.imprimir();
		System.out.print(" " +  " (Producto perecedero:" + fechacad + ")");
	}
	
	public String volcar() {
		return super.volcar() + " " + fechacad;
	}
	
	public void imprimirEnvio() {
		
	}
	
	/*public String getFechaCad() {
		return fechacad;
	}*/

	@Override
	public String getFechaCaducidad() {
		return fechacad;
	}
}
