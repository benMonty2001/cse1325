package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Objects;

public class Fish extends Animal {
	protected FishBreed breed;

	public Fish(FishBreed breed, String name, Gender gender, int age){
		super(name, gender, age);
		this.breed = breed;
	}

	public Fish(BufferedReader bufferedReader) throws IOException {
		super(bufferedReader);
		this.breed = FishBreed.valueOf(bufferedReader.readLine());
	}

	public Fish() {
		
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
	public void create(Object breed, String name, Gender gender, int age) {
		super.name = name;
		super.gender = gender;
		super.age = age;
		this.breed = (FishBreed)breed;
	}

	@Override 
	public String toStringGUI(){
		return "Fish" + ", " + breed + ", " + super.toStringGUI();
	}

	@Override 
	public String toString() {
		return "Fish" + "\n" +
			    super.toString() + "\n" + breed + "\n";
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
        Fish f = (Fish)o;
        
        return (this.name   == f.name   && 
        	    this.age    == f.age    &&
        	    this.gender == f.gender &&
        	    this.breed  == f.breed    );
    }
}