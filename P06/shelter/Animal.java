package shelter;
abstract class Animal {
	private String name;
	private Gender gender;
	private int age;

	public Animal(String name, Gender gender, int age){
		if(age < 0){
			throw new IllegalArgumentException("age must be positive!");
		}

		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	abstract String family();
	abstract String breed();

	@Override
	public String toString(){
		return "  Name: " + name   + "\n" + 
			   "Gender: " + gender + "\n" + 
			   "   Age: " + age    + " wks";
	}
}