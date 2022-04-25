package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Objects;

public class Hamster extends Animal { 
	protected HamsterBreed breed;

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
	public String toStringGUI() {
		return "Hamster" + ", " + breed + ", " + super.toStringGUI();
	}

	@Override 
	public String toString() {
		return "Hamster" + "\n" + super.toString() + "\n" + breed + "\n";
	}


	@Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash + Objects.hashCode(this.name)   		 +
        				   Objects.hashCode(this.breed)  		 +
        				   Objects.hashCode((Integer)(this.age)) +
        				   Objects.hashCode(this.gender);

        return hash;
    }


	@Override
	 public boolean equals(Object o) {
        if(this == o) {
        	return true;
        }
        if(o == null) {
        	return false; 
        }
        if(this.getClass() != o.getClass()) {
        	return false;
        }
        Hamster h = (Hamster) o;
        
        return (this.name   == h.name   && 
        	    this.age    == h.age    &&
        	    this.gender == h.gender &&
        	    this.breed  == h.breed    );
    }
}