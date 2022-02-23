public class Hamster extends Animal{
	private HamsterBreed breed;

	public Hamster(HamsterBreed breed, String name, Gender gender, int age){
		super(name, gender, age);
		this.breed = breed;
	}

	@Override
	public String family(){
		return "Hamster";
	}

	@Override
	public String breed(){
		return breed.toString();
	}

	@Override 
	public String toString(){
		return "Family: Hamster" + "\n" +
			   " Breed: " + breed  + "\n" + super.toString();
	}
}