import shelter.*;
public class Mass {
	public static void main(String[] args){
		Shelter shelter = new Shelter("Animal Farm");

		try{
			Hamster hamster = new Hamster(HamsterBreed.DWARF, "Percival", Gender.MALE, 21);
			shelter.addAnimal(hamster);
		} catch(IllegalArgumentException e){
			System.err.println(e.getMessage() + "\n");
		} try {
			Fish fish = new Fish(FishBreed.GUPPY, "Princess", Gender.FEMALE, -8);
			shelter.addAnimal(fish);
		} catch(IllegalArgumentException e){
			System.err.println(e.getMessage() + "\n");
		}
		System.out.println(shelter.toString());
	}
}