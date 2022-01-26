import java.util.Scanner;

class Polygon {
	private int sides;
	private double perimeter;

	public void addSide(double length){
		this.sides += 1;
		this.perimeter += length;
	}

	public int getSides(){
		return this.sides;
	}
	
	public double getPerimeter(){
		return this.perimeter;
	}

	public static void main(String[] args){
		Polygon polygon = new Polygon();
		double sideLength = 1;

		while(sideLength > 0){
			System.out.print("Side length (0 when done): ");
			Scanner in = new Scanner(System.in);
			sideLength = in.nextDouble();

			if(sideLength <= 0){
				break;
			}

			polygon.addSide(sideLength);
		}

		System.out.printf("Perimenter of %d-sided polygon is %f\n", polygon.getSides(), 
																	polygon.getPerimeter());
	}
}