public class Fish extends Animal{
	private FishBreed breed;

	public Fish(FishBreed breed, String name, Gender gender, int age){
		super(name, gender, age);
		this.breed = breed;
	}

	@Override
	public String family(){
		return "Fish";
	}

	@Override
	public String breed(){
		return breed.toString();
	}

	@Override 
	public String toString(){
		return "Family: Fish\n" + 
		 	   " Breed: " + breed + "\n" + super.toString();
	}
}