import java.util.Scanner;
import java.lang.Math;

class Polygon {
	private int sides;
	private double[] lengths;

	public void addSide(double length){
		this.sides += 1;
		double[] temp = new double[this.sides];

		if(this.sides == 1){
			this.lengths = new double[1];
		} else {
			for(int i = 0; i < this.sides - 1; i++){
				temp[i] = this.lengths[i];
			}

			this.lengths = new double[this.sides];

			for(int i = 0; i < this.sides - 1; i++){
				this.lengths[i] = temp[i];
			}
		}

		this.lengths[this.sides - 1] = length;
	}

	public int getSides(){
		return this.sides;
	}
	
	public double getPerimeter(){
		int perimeter = 0;
		for(double i : this.lengths){
			perimeter += i;
		}

		return perimeter;
	}

	public double getArea(double apothem){
		return 0.5 * apothem * getPerimeter();
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

		int numSides = polygon.getSides();
		sideLength = polygon.getPerimeter()/numSides;
		double apothem = sideLength/(2 * Math.tan(3.14/numSides));
		double perimeter = polygon.getPerimeter();

		System.out.printf("Apothem: %f\n", apothem);
		System.out.printf("Perimenter of %d-sided polygon is %f\n", numSides, perimeter);
		System.out.printf("Area is %f\n", polygon.getArea(apothem));
	}
}