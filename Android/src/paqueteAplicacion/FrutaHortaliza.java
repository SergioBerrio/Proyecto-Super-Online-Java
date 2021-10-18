package paqueteAplicacion;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class FrutaHortaliza extends Perecedero {

	private String origen;
	private double VALOR_IVA = 0.16;
	
	public FrutaHortaliza(int codigo, String nombre, double precio, int cantidad, double peso, String fecha, String origen) {
		super(codigo, nombre, precio, cantidad, peso, fecha);
		this.origen = origen;
	}
	
	public FrutaHortaliza(Scanner in) {
		super(in);
		System.out.println("Origen del producto:");
		this.origen = in.nextLine();
	}

	public FrutaHortaliza(){

	}
	
	public String volcar() {
		return super.volcar() + " " + origen;
	}
	
	public void imprimir() {
		super.imprimir();
		System.out.print(" " +  "Fruta de origen:" + origen + "\n");
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
	
	/*public String getOrigen() {
		return origen;
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
		return origen;
	}

	@Override
	public String getGraduacion() {
		return null;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
}
