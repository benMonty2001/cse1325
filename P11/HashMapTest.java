import java.util.HashMap;
import shelter.Hamster;
import shelter.Gender;
import shelter.Animal;
import shelter.HamsterBreed;
import shelter.Client;

public class HashMapTest {
	public static void main(String args[]) {
		HashMap<Animal, Client> map = new HashMap<>();

		Hamster hammy = new Hamster(HamsterBreed.CHINESE, "hammy", Gender.MALE, 10);
		Client client = new Client("Henry", "817-946-0470");

		map.put(hammy, client);

		map.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + "" + entry.getValue());
		});
	}
}