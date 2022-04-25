package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Objects;

public class Aligator extends Animal {
	protected AligatorBreed breed;

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
	public String toStringGUI(){
		return "Aligator" + ", " + breed + ", " + super.toStringGUI();
	}

	@Override 
	public String toString() {
		return "Aligator" + "\n" +
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
        Aligator a = (Aligator)o;
        
        return (this.name   == a.name   && 
        	    this.age    == a.age    &&
        	    this.gender == a.gender &&
        	    this.breed  == a.breed    );
    }
}