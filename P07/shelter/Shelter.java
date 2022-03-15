package shelter;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Shelter {
	private String name;
	private String filename;
	private ArrayList<Animal> animals = new ArrayList<>();

	public Shelter(String name){
		this.name = name;
	}

	public Shelter(BufferedReader bufferedReader) throws IOException {
		int sizeShelter = Integer.parseInt(bufferedReader.readLine());
		
		for(int i = 0; i < sizeShelter; i++) {
			String family = bufferedReader.readLine();
			switch(family) {
				case "Fish" : {
					this.addAnimal(new Fish(bufferedReader));
					break;
				}
				case "Hamster" : {
					this.addAnimal(new Hamster(bufferedReader));
					break;
				}
			}
		}
	}

	public void save(BufferedWriter bufferedWriter) throws IOException {
		for(int i = 0; i < this.getNumAnimals(); i++) {
			Animal animal = getAnimal(i);
			bufferedWriter.write(animal.getFamily() + "\n");
			animal.save(bufferedWriter);
		}
	}

	public String getFilename() {
		return this.filename;
	}

	public String getName() {
		return this.name;
	}

	public void addAnimal(Animal animal){
		animals.add(animal);
	}

	public int getNumAnimals(){
		return (int)animals.size();
	}

	public Animal getAnimal(int index){
		return animals.get(index);
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString(){
		String result = "";
		for(int a = 0; a < animals.size(); a++){
			result += animals.get(a).toString();
			if(a < animals.size() - 1){
				result += "\n\n";
			}
		}
		return result;
	}

}