
public class Rectangulo extends FigurasGeometricas {
	
	private double base;
	private double altura;
	
	@Override
	public double area(){
		return base*altura;
	}
	
	@Override
	public double perimetro(){
		return 2*base+2*altura;
	}
	
	public Rectangulo (double base, double altura){
		super(6);
	    this.base = base;
	    this.altura = altura;
	}
	
}
