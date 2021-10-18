package paqueteAplicacion;

import java.util.Scanner;

public class Lacteo extends Perecedero {

	private String lote;
	private double VALOR_IVA = 0.04;
	
	public Lacteo(int codigo, String nombre, double precio, int cantidad, double peso, String fecha, String lote) {
		super(codigo, nombre, precio, cantidad, peso, fecha);
		this.lote = lote;
	}

	public Lacteo() {

	}

	public Lacteo(Scanner in) {
		super(in);
		System.out.println("Lote del producto:");
		this.lote = in.nextLine();
	}
	
	public String volcar() {
		return super.volcar() + " " + lote;
	}
	
	public void imprimir() {
		super.imprimir();
		System.out.print(" " + " Producto lácteo:" + lote + "\n");

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
	
	/*public String getLote() {
		return lote;
	}*/

	@Override
	public String getLote() {
		return lote;
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
		return null;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}
}
