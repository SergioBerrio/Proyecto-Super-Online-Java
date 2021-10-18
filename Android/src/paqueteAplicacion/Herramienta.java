package paqueteAplicacion;

import java.util.Scanner;

public class Herramienta extends NoPerecedero implements Enviable {

	private double VALOR_IVA = 0.4;
	
	public Herramienta(int codigo, String nombre, double precio, int cantidad, double peso) {
		super(codigo, nombre, precio, cantidad, peso);

	}
	
	public Herramienta(Scanner in) {
		super(in);
	}

	public Herramienta(){

	}
	
	public String volcar() {
		return super.volcar()  + " Herramienta";
	}
	
	public void imprimir() {
		super.imprimir();
		System.out.print(" " + "Herramienta" + "\n");
	}

	public double calcularPrecioEnvio() {
		return super.getPrecio() + (super.getPrecio() * VALOR_IVA);
	}

	@Override
	public boolean envioFragil() {
		return false;
	}

	@Override
	public double tarifaEnvio() {
		return 0;
	}

	public double getTarifaEnvio() {
		return 3.2;
	}

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

}
