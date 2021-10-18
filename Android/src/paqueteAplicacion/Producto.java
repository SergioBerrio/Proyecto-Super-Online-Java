package paqueteAplicacion;

import java.util.Scanner;

public abstract class Producto implements java.io.Serializable {

	private double iva = 0.16;
	private int codigo;
	private String nombre;
	private double precio;
	private int cantidad;
	private double peso;
	
	public Producto(int codigo, String nombre, double precio, int cantidad, double peso) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.peso = peso;
	}
	
	public Producto(Scanner in) {
		this.codigo = Inventario.getUltimoCodigo()+1;
		
		System.out.println("Introduce la descripci�n del producto (string)");
		this.nombre = in.nextLine();
		
		System.out.println("Introduce el precio del producto por unidad en �");
		this.precio = in.nextDouble();
		
		System.out.println("Introduce la cantidad (n�mero de unidades)");
		this.cantidad = in.nextInt();
		
		System.out.println("Introduce el peso del producto por unidad (en kg)");
		this.peso = in.nextDouble();

		in.nextLine();
	}
	
	public Producto() {
		this.codigo = 0;
		this.nombre = "";
		this.precio = 0;
		this.cantidad = 0;
		this.peso = 0;
	}
	
	
	//getters de Producto
	public double getPeso() {
		return peso;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	
	
	public double getPrecio() {
		return precio;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public double getIVA() {
		return iva;
	}


	public abstract String getFechaCaducidad();
	public abstract String getOrigen();
	public abstract String getGraduacion();
	public abstract String getLote();
	public abstract String getCategoria();


	//setters de Producto
	public void setIva(double iva) {
		this.iva = iva;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	public double calcularPrecioIVA() {
		return this.precio + (this.precio * this.precio);
	}
	
	public void imprimir() {
		/*System.out.println("IVA: " + iva);
		System.out.println("C�digo: " + codigo);
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
		System.out.println("Cantidad: " + cantidad);
		System.out.println("Peso: " + peso);*/

		System.out.print("ID:" + this.getCodigo() + " " + " Nombre:" + this.getNombre() + " " + " Precio:" + this.getPrecio() + " " + " Cantidad:" + this.getCantidad() + " " + " Precio:" + this.getPeso());
	}

	//Funci�n sin utilizar
	public void imprimirEnvio() {
		
	}
	
	public String volcar() {
		return this.getCodigo() + " " + this.getNombre() + " " + this.getPrecio() + " " + this.getCantidad() + " " + this.getPeso();
	}
}
