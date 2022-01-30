/*



+ Yes, arrayLists are better for this project, 
  since traditional arrays cannot dynamically allocate memory. 

+ Although copying and pasting old arrays into new ones does work,
  It takes more time and memory to do so. 



*/

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

class Polygon {
	private int sides;
	private ArrayList<Double> lengths;

	public void addSide(double length){
		this.sides += 1;
		if(this.lengths == null){
			this.lengths = new ArrayList<Double>();
			this.lengths.add(length);
		} else {
			this.lengths.add(length);
		}
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
		Scanner in = new Scanner(System.in);
		Polygon polygon = new Polygon();
		double sideLength = 1;

		while(sideLength > 0){
			System.out.print("Side length (0 when done): ");
			sideLength = in.nextDouble();

			if(sideLength <= 0){
				break;
			}

			polygon.addSide(sideLength);
		}

		System.out.print("Apothem: ");
		double apothem = in.nextDouble();

		/*

		//Calculate the apothem

		sideLength = polygon.getPerimeter()/numSides;
		double apothem = sideLength/(2 * Math.tan(3.14/numSides));

		*/

		double perimeter = polygon.getPerimeter();
		double area = polygon.getArea(apothem);
		int numSides = polygon.getSides();

		System.out.printf("Perimenter of %d-sided polygon is %f\n", numSides, perimeter);
		System.out.printf("Area is %f\n", area);
	}
}