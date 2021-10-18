import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<FigurasGeometricas> figuras = new ArrayList<FigurasGeometricas>();
		//ArrayList<Rectangulo> rectangulos = new ArrayList<Rectangulo>();
		
		double areaTotal = 0;
		double perimetroTotal = 0;
		String colorFigura = "";
		
		for (int i = 0; i <= Math.random()*101; i++) {
			Circulo circulo = new Circulo(Math.random()*11, 1);
			Rectangulo rectangulo = new Rectangulo(Math.random()*11, Math.random()*11);
			Triangulo triangulo = new Triangulo(Math.random()*11, Math.random()*11, Math.random()*11);
			
			figuras.add(circulo);
			figuras.add(rectangulo);
			figuras.add(triangulo);
	
		}
		
		for (int i = 0; i < figuras.size(); i++) {
			if(figuras.get(i) instanceof Circulo) {		
				Circulo circulo = (Circulo) figuras.get(i);
				
				areaTotal = circulo.area();
				perimetroTotal = circulo.perimetro();
				
				System.out.println("La figura " + i + " es un círculo.");
				
			} else if(figuras.get(i) instanceof Rectangulo) {
				Rectangulo rectangulo = (Rectangulo) figuras.get(i);
				
				areaTotal = rectangulo.area();
				perimetroTotal = rectangulo.perimetro();
				
				System.out.println("La figura " + i + " es un rectángulo.");
				
			} else if(figuras.get(i) instanceof Triangulo) {
				Triangulo triangulo = (Triangulo) figuras.get(i);
				
				areaTotal = triangulo.area();
				perimetroTotal = triangulo.perimetro();
				
				System.out.println("La figura " + i + " es un triángulo.");
				
			} 
			
			if(figuras.get(i) instanceof FiguraBidimensional) {
				FiguraBidimensional figura = (FiguraBidimensional) figuras.get(i);
				
				colorFigura = figura.color();
				
				System.out.println("La figura es de color " + colorFigura);
				
			}
			
			
			System.out.println("El área total de la figura  es: " + areaTotal + " m.");
			System.out.println("El perímetro total de la f es: " + perimetroTotal + " m.\n");
			
			//System.out.println("\nEl área total de la figura es: " + figuras.get(i).area() + " m.");
			//System.out.println("\nEl área total de la figura es: " + figuras.get(i).perimetro() + " m.");
		}
		
		/*for (FigurasGeometricas circulo: figuras) {
			System.out.println("\nEl área total de la figura es: " + circulo.area() + " m.");
			System.out.println("El perímetro total de la figura es: " + circulo.perimetro() + " m.\n");
		}*/
		
		//System.out.println(circulos);
		
		//System.out.println("Hola Mundo");
		
		//Circulo circulo1 = new Circulo(scanner);
		//circulo1.setRadio(2);	
		
		//Circulo circulo2 = new Circulo(scanner);
		//circulo2.setRadio(4);	
		
		//Circulo circulo3 = new Circulo(scanner);
		//circulo3.setRadio(6);
		
		//double areaTotal = circulo1.area() + circulo2.area() + circulo3.area();
		//double perimetroTotal = circulo1.perimetro() + circulo2.perimetro() + circulo3.perimetro();
		
		/*Rectangulo rectangulo = new Rectangulo(2, 4);
		
		System.out.println("\nEl área total del rectángulo es: " + rectangulo.area() + " m.");
		System.out.println("El perímetro total del rectángulo es: " + rectangulo.perimetro() + " m.\n");*/
		
		//System.out.println("ArrayList de figuras " + figuras);
		
		//Punto punto = new Punto();
		//System.out.println(punto.area());
		
		//FigurasGeometricas fg = new FigurasGeometricas();
		
		scanner.close();
	}
}
