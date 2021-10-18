
public class Triangulo extends FigurasGeometricas {

	private double l1;
	private double l2;
	private double l3;
	
	@Override
	public double area() {
		double s = (l1+l2+l3)/2;
		return Math.sqrt(s*((s-11)+(s-l2)+(s-l3)));
	}

	@Override
	public double perimetro() {
		return l1+l2+l3;
	}
	
	public Triangulo (double l1, double l2, double l3){
		super(7);
	    this.l1 = l1;
	    this.l2 = l2;
	    this.l3 = l3;
	}

	
}
