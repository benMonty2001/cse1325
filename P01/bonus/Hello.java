import java.util.Scanner;

public class Hello {
	public static void main(String[] args){
		System.out.print("Enter username: ");

		//create instance of Scanner called userInterface
											//specify origin
		Scanner userInterface = new Scanner(System.in);
		String name = userInterface.nextLine();
		System.out.println("Hello, " + name);
	}
}