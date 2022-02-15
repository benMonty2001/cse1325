import java.util.Random;
import java.util.Scanner;

public class Crypto {
	public static String generateKey(){
		char[] letters =  "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] scrambled = new char[26];
		int[] index = new int[26];
		Random random = new Random();
		boolean hasGeneratedZeroBefore = false;
		for(int i = 0; i < 26; i++){ //consider letters a-z
			int randomIndex = 0;
			while(true){ //generate random index
				boolean isBadIndex = false;	//assume index will be good
				randomIndex = random.nextInt(26);
				for(int j : index){ //check all previous indexes //initially, 26 zeros
					if(randomIndex == 0 && hasGeneratedZeroBefore){
						isBadIndex = true;
					} else if(randomIndex == j && j != 0){
						isBadIndex = true;
					}
				}
				if(isBadIndex){
					continue;
				} else {
					if(randomIndex == 0){
						hasGeneratedZeroBefore = true;
					}
					index[i] = randomIndex;
					break;
				}	
			}
			scrambled[randomIndex] = letters[i];
		}
		return String.valueOf(scrambled);
	}
	public static void cryptoCycle(Substitution substitution, char choice){		
		Scanner in = new Scanner(System.in);
		switch(choice){
			case 'e' : {
				System.out.println("Enter text to encrpyt");
				while(true){
					String unencrypted = in.nextLine();					
					if(unencrypted.length() == 0){
						break;
					}
					System.out.println(substitution.encrypt(unencrypted));
				}
				break;
			} 
			case 'd' : {
				System.out.println("Enter text to decrpyt");
				while(true){
					String encrypted = in.nextLine();
					if(encrypted.length() == 0){
						break;
					}
					System.out.println(substitution.decrypt(encrypted));
				}
				break;
			}
		}
	}

	public static void main(String args[]){
		String key;
		if(args.length == 1){
			switch(args[0]){
				case "-h" : {
					System.out.println("usage: java Crypto [key | rot13]");
					System.exit(1);
				}
				default: {
					key = args[0];
				}
			}
		} else {
			key = generateKey();
		}
		Substitution substitution;
		if(key.equals("rot13")){
			substitution = new Rot13();
		} else {
			substitution = new Substitution(key);
		}
		while(true){
			System.out.print("(e)ncrypt, (d)ecrypt, or (q)uit? ");
			Scanner in = new Scanner(System.in);
			char choice = in.nextLine().charAt(0);
			if(choice == 'q'){
				System.exit(0);
			} else {
				cryptoCycle(substitution, choice);
			}
		}
	}
}