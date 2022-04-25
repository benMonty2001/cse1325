package shelter;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.ListIterator;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Shelter {


	//FIELDS


	private String name;
	private String filename;
	private ArrayList<Animal> animals = new ArrayList<>();
	private ArrayList<Client> clients = new ArrayList<>();
	private HashMap<Animal, Client> adoptions = new HashMap<>();


	//CONSTRUCTORS


	public Shelter(String name){
		this.name = name;
	}
	public Shelter(BufferedReader bufferedReader) throws IOException {
		int numAnimals = Integer.parseInt(bufferedReader.readLine());
		int numClients = Integer.parseInt(bufferedReader.readLine());
		int numAdoptions = Integer.parseInt(bufferedReader.readLine());
		
		for(int i = 0; i < numAnimals; i++) {
			String type = bufferedReader.readLine();
			switch(type) {
				case "Fish" : {
					this.addAnimal(new Fish(bufferedReader));
					break;
				}
				case "Hamster" : {
					this.addAnimal(new Hamster(bufferedReader));
					break;
				}
				case "Aligator" : {
					this.addAnimal(new Aligator(bufferedReader));
				}
			}
		}

		//clients

		for(int i = 0; i < numClients; i++) {
			this.addClient(new Client(bufferedReader));
		}

		//adoptions
		for(int i = 0; i < numAdoptions; i++) {
			String type = bufferedReader.readLine();
			switch(type) {
				case "Fish" : {
					Fish fish = new Fish(bufferedReader);
					Client client = new Client(bufferedReader);
					adoptions.put(fish, client);
					break;
				}
				case "Hamster" : {
					Hamster hamster = new Hamster(bufferedReader);
					Client client = new Client(bufferedReader);
					adoptions.put(hamster, client);					
					break;
				}
				case "Aligator" : {
					Aligator aligator = new Aligator(bufferedReader);
					Client client = new Client(bufferedReader);
					adoptions.put(aligator, client);					
				}
			}
		}
	}
	public void save(BufferedWriter bufferedWriter) throws IOException {
		//signature
		bufferedWriter.write("🐹🐠\n");

		//number of animals
		bufferedWriter.write(animals.size() + "\n");
		bufferedWriter.write(clients.size() + "\n");
		bufferedWriter.write(adoptions.size() + "\n");

		for(int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			bufferedWriter.write(animal.getFamily() + "\n");
			animal.save(bufferedWriter);
		}

		for(int i = 0; i < clients.size(); i++) {
			Client client = clients.get(i);
			client.save(bufferedWriter);
		}

		//save adoptions

		Iterator<Animal> adoptedAnimalsi = adoptedAnimalIterator();

		while(adoptedAnimalsi.hasNext()) {

			Animal animal = adoptedAnimalsi.next();
			Client client = getAdoptedClient(animal);

			try {
				bufferedWriter.write(animal + "");
				bufferedWriter.write(client + "");
			} catch(IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	public String getFilename() {
		return this.filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}


	//ANIMALS


	public void addAnimal(Animal animal){
		animals.add(animal);
	}
	public ListIterator<Animal> animalListIterator() {
		return animals.listIterator();
	}
	@Override
	public String toString(){
		String result = "";
		for(int a = 0; a < animals.size(); a++) {
			result += animals.get(a).toStringGUI();
			if(a < animals.size() - 1) {
				result += "\n\n";
			}
		}
		return result;
	}
	

	//CLIENTS


	public void addClient(Client client) {
		this.clients.add(client);
	}
	public ListIterator<Client> clientListIterator() {
		return clients.listIterator();
	}
	public String clientsToString() {
		String result = "";
		for(int c = 0; c < clients.size(); c++) {
			result += clients.get(c).toStringGUI();
			if(c < clients.size() - 1) {
				result += "\n\n";
			}
		}
		return result;
	}


	//ADOPTIONS


	public void adopt(Animal animal, Client client) {
		adoptions.put(animal, client);
		
		//remove animal from arrayList
		ListIterator<Animal> animali = animalListIterator();
		int index = 0;
		while(animali.hasNext()) {
			if(animali.next().equals(animal)) {
				break;
			}
			index++;
		}
		animals.remove(index);
	}
	public Iterator<Animal> adoptedAnimalIterator() {
		return adoptions.keySet().iterator();
	}

	public Client getAdoptedClient(Animal animal) {
		Iterator<Animal> adoptedAnimalsi = adoptedAnimalIterator();
		while(adoptedAnimalsi.hasNext()) {
			if(adoptedAnimalsi.next().equals(animal)) {
				return adoptions.get(animal);
			}
		}

		return new Client("fail", "fail");
	}

	public String adoptionsToString() {
		String result = "";

		for (Animal a : adoptions.keySet()) {
    		String key = a.toStringGUI();
    		String value = adoptions.get(a).toStringGUI();

    		result += key + " <---> " + value + "\n";
		}

		return result;
	}	


}