package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Hamster extends Animal { 
	private HamsterBreed breed;

	public Hamster(HamsterBreed breed, String name, Gender gender, int age) {
		super(name, gender, age);
		this.breed = breed;
	}

	public Hamster(BufferedReader bufferedReader) throws IOException {
		super(bufferedReader);
		this.breed = HamsterBreed.valueOf(bufferedReader.readLine()); 
	}

	public Hamster() {

	}

	@Override
	public void save(BufferedWriter bufferedWriter) throws IOException {
		super.save(bufferedWriter);
		bufferedWriter.write(this.getBreed() + "\n");
	}

	@Override
	public String getFamily() {
		return "Hamster";
	}

	@Override
	public String getBreed() {
		return breed.toString();
	}

	@Override
	public void create(Object breed, String name, Gender gender, int age) {
		super.name = name;
		super.gender = gender;
		super.age = age;
		this.breed = (HamsterBreed)breed;
	}

	@Override 
	public String toString() {
		return "Family: Hamster" + "\n" +
			   " Breed: " + breed  + "\n" + super.toString();
	}
}