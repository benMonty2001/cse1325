public class Mass {
	public static void main(String[] args){
		Shelter shelter = new Shelter("Animal Farm");
		
		Hamster hamster = new Hamster(HamsterBreed.DWARF, "Percival", Gender.MALE, 21);
		Fish fish = new Fish(FishBreed.GUPPY, "Princess", Gender.FEMALE, 8);

		shelter.addAnimal(hamster);
		shelter.addAnimal(fish);

		System.out.println(shelter.toString());
	}
}