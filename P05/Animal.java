abstract class Animal {
	private String name;
	private Gender gender;
	private int age;

	public Animal(String name, Gender gender, int age){
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