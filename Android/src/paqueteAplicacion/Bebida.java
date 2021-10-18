package paqueteAplicacion;

import java.util.Scanner;

public class Bebida extends Perecedero {

	private String graduacion;
	private double VALOR_IVA = 0.16;
	
	public Bebida(int codigo, String nombre, double precio, int cantidad, double peso, String fecha, String graduacion) {
		super(codigo, nombre, precio, cantidad, peso, fecha);
		this.graduacion = graduacion;
	}
	
	public Bebida(Scanner in) {
		super(in);
		System.out.println("Graduación del producto:");
		this.graduacion = in.nextLine();
	}

	public Bebida(){

	}

	public String volcar() {
		return super.volcar() + " " + graduacion;
	}
	
	public void imprimir() {
		super.imprimir();
		System.out.print(" " + " Bebida de graduación:" + graduacion + "\n");

	}

	public double calcularPrecioEnvio() {
		return super.getPrecio() + (super.getPrecio() * VALOR_IVA);
	}
	
	@Override
	public boolean envioFragil() {
		return true;
	}

	@Override
	public double tarifaEnvio() {
		return 1.6;
	}
	
	/*public String getGraduacion() {
		return graduacion;
	}*/

	@Override
	public String getLote() {
		return null;
	}

	@Override
	public String getCategoria() {
		return null;
	}

	@Override
	public String getFechaCaducidad() {
		return super.getFechaCaducidad();
	}

	@Override
	public String getOrigen() {
		return null;
	}

	@Override
	public String getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(String graduacion) {
		this.graduacion = graduacion;
	}
}
