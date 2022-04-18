package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public abstract class Animal {
	protected String name;
	protected Gender gender;
	protected int age;

	public Animal(String name, Gender gender, int age){
		if(age < 0){
			throw new IllegalArgumentException("age must be positive!");
		}

		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Animal(BufferedReader bufferedReader) throws IOException {
		this.name = bufferedReader.readLine();
		this.gender = Gender.valueOf(bufferedReader.readLine());
		this.age = Integer.parseInt(bufferedReader.readLine());
	}

	public Animal() {
		
	}

	public abstract String getFamily();
	public abstract String getBreed();

	public abstract void create(Object breed, String name, Gender gender, int age);
	
	public void save(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write(this.name + "\n");
		bufferedWriter.write(this.gender + "\n");
		bufferedWriter.write(this.age + "\n");
	}

	@Override
	public String toString(){
		return "  Name: " + name   + "\n" + 
			   "Gender: " + gender + "\n" + 
			   "   Age: " + age    + " wks";
	}
}