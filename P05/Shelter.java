import java.util.ArrayList;

public class Shelter {
	private String name;
	private ArrayList<Animal> animals = new ArrayList<>();

	public Shelter(String name){
		this.name = name;
	}

	public void addAnimal(Animal animal){
		animals.add(animal);
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