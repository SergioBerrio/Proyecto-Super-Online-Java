
abstract class FigurasGeometricas {
	

	/*public double area(){
		return 0.0;
	}
	
	public double perimetro(){
		return 0.0;
	}*/
	
	public int pos;
	
	public FigurasGeometricas(int p) {
		this.pos = p;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
}
