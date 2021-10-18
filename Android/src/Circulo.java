import java.util.Scanner;

public class Circulo extends FigurasGeometricas implements FiguraBidimensional {
		
	private double radio;
	
	//Scanner scanner = new Scanner(System.in);
	
	@Override
	public double area(){
		return Math.PI*Math.pow(radio, 2);
	}
	
	@Override
	public double perimetro(){
		return 2*Math.PI*radio;
	}
	
	//Constructora que recibe parámetro
	
	public Circulo (double radio, int posicion){
		super(posicion);
		
	    this.radio = radio;
	}
	
	//Constructora que no recibe parámetro / parámetro por teclado
	
	public Circulo (Scanner scanner){
		super(7);
	    //pedir por Scanner
		System.out.println("Introduce un radio:");
		
		this.radio = scanner.nextDouble();
		
	}
	
	public void setRadio (double radio){
	    this.radio = radio;
	}

	@Override
	public String color() {
		return "Verde";
	}

	@Override
	public String textura() {
		return null;
	}
	
}
