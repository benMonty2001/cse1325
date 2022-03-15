package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Fish extends Animal {
	private FishBreed breed;

	public Fish(FishBreed breed, String name, Gender gender, int age){
		super(name, gender, age);
		this.breed = breed;
	}

	public Fish(BufferedReader bufferedReader) throws IOException {
		super(bufferedReader);
		this.breed = FishBreed.valueOf(bufferedReader.readLine());
	}

	@Override
	public void save(BufferedWriter bufferedWriter) throws IOException {
		super.save(bufferedWriter);
		bufferedWriter.write(this.getBreed() + "\n");
	}

	@Override
	public String getFamily(){
		return "Fish";
	}

	@Override
	public String getBreed(){
		return breed.toString();
	}

	@Override 
	public String toString(){
		return "Family: Fish\n" + 
		 	   " Breed: " + breed + "\n" + super.toString();
	}
}