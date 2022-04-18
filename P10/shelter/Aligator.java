package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Aligator extends Animal {
	private AligatorBreed breed;

	public Aligator(AligatorBreed breed, String name, Gender gender, int age){
		super(name, gender, age);
		this.breed = breed;
	}

	public Aligator(BufferedReader bufferedReader) throws IOException {
		super(bufferedReader);
		this.breed = AligatorBreed.valueOf(bufferedReader.readLine());
	}

	public Aligator() {
		
	}

	@Override
	public void save(BufferedWriter bufferedWriter) throws IOException {
		super.save(bufferedWriter);
		bufferedWriter.write(this.getBreed() + "\n");
	}

	@Override
	public String getFamily(){
		return "Aligator";
	}

	@Override
	public String getBreed(){
		return breed.toString();
	}

	@Override
	public void create(Object breed, String name, Gender gender, int age) {
		super.name = name;
		super.gender = gender;
		super.age = age;
		this.breed = (AligatorBreed)breed;
	}

	@Override 
	public String toString(){
		return "Family: Aligator\n" + 
		 	   " Breed: " + breed + "\n" + super.toString();
	}
}