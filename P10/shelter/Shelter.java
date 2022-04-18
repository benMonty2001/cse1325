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
	private ArrayList<Client> clients = new ArrayList<>();

	public Shelter(String name){
		this.name = name;
	}

	public Shelter(BufferedReader bufferedReader) throws IOException {
		int numAnimals = Integer.parseInt(bufferedReader.readLine());
		int numClients = Integer.parseInt(bufferedReader.readLine());
		
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

		for(int i = 0; i < numClients; i++) {
			this.addClient(new Client(bufferedReader));
		}
	}

	public void save(BufferedWriter bufferedWriter) throws IOException {
		//signature
		bufferedWriter.write("🐹🐠\n");

		//number of animals
		bufferedWriter.write(this.getNumAnimals() + "\n");
		bufferedWriter.write(this.getNumClients() + "\n");

		for(int i = 0; i < this.getNumAnimals(); i++) {
			Animal animal = getAnimal(i);
			bufferedWriter.write(animal.getFamily() + "\n");
			animal.save(bufferedWriter);
		}

		for(int i = 0; i < this.getNumClients(); i++) {
			Client client = getClient(i);
			client.save(bufferedWriter);
		}
	}

	public String getFilename() {
		return this.filename;
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

	public void addClient(Client client) {
		this.clients.add(client);
	}

	public int getNumClients() {
		return (int)clients.size();
	}

	public Client getClient(int index) {
		return clients.get(index);
	}

	public String clientsToString() {
		String result = "";
		for(int c = 0; c < clients.size(); c++) {
			result += clients.get(c).toString();
			if(c < clients.size() - 1) {
				result += "\n\n";
			}
		}
		return result;
	}

	@Override
	public String toString(){
		String result = "";
		for(int a = 0; a < animals.size(); a++) {
			result += animals.get(a).toString();
			if(a < animals.size() - 1) {
				result += "\n\n";
			}
		}
		return result;
	}

}