import shelter.FishBreed;
import shelter.HamsterBreed;
import shelter.Hamster;
import shelter.Fish;
import shelter.Shelter;
import shelter.Gender;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;

import java.lang.Character;

public class profileFrame extends JFrame {
	public profileFrame(String family, Shelter shelter, MainWin mainWin) {
		setSize(200,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(family);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		setVisible(false);

		//Description Panel
		JPanel description = new JPanel();
		this.add(description);
		description.setLayout(new BoxLayout(description, BoxLayout.Y_AXIS));
		description.setSize(100,200);
		
		description.add(new JLabel("Breed:"));
		description.add(new JLabel(" "));
		description.add(new JLabel("Gender:"));
		description.add(new JLabel(" "));
		description.add(new JLabel("Name:"));
		description.add(new JLabel(" "));
		description.add(new JLabel("Age:"));
		description.add(new JLabel(" "));
		description.add(new JLabel(" "));
		description.add(new JLabel(" "));
		description.add(new JLabel(" "));
		description.add(new JLabel(" "));

		//Data Panel
		JPanel data = new JPanel();
		this.add(data);
		data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
		data.setSize(100,200);
			//ComboBox
				//enum Breeds to String	
					//Hamster
					HamsterBreed[] enumHamsterBreeds = HamsterBreed.values();
					String[] hamsterBreeds = new String[HamsterBreed.values().length];
				
					for(int i = 0; i < HamsterBreed.values().length; i++) {
						hamsterBreeds[i] = String.valueOf(enumHamsterBreeds[i]);
					}

					//Fish
					FishBreed[] enumFishbreeds = FishBreed.values();
					String[] fishBreeds = new String[FishBreed.values().length];

					for(int i = 0; i < FishBreed.values().length; i++){
						fishBreeds[i] = String.valueOf(enumFishbreeds[i]);
					}
				//Breeds to ComboBox
					//Fish
					JComboBox fishBreedComboBox = new JComboBox(fishBreeds);
					FishBreed fishBreed = FishBreed.valueOf(String.valueOf(fishBreedComboBox.getSelectedItem()));

					//Hamster
					JComboBox hamsterBreedComboBox = new JComboBox(hamsterBreeds);
		
					switch(family) {
						case "Hamster" : {
							data.add(hamsterBreedComboBox);
							break;
						}
						case "Fish" : {
							data.add(fishBreedComboBox);
						}
					}
				//enum Genders to String
					Gender[] enumGenders = Gender.values();
					String[] genders = new String[Gender.values().length];

					for(int i = 0; i < Gender.values().length; i++){
						genders[i] = String.valueOf(enumGenders[i]);
					}

				//Genders to ComboBox
				JComboBox gendersComboBox = new JComboBox(genders);
				data.add(gendersComboBox);

			//Fillables
				//Name
				JTextField nameField = new JTextField("name");
				data.add(nameField);
				//Age
				JTextField ageField = new JTextField("age");
				data.add(ageField);

			//Button
			JButton enter = new JButton("Enter");
			
			if(family == "Hamster") {
				enter.addActionListener(event -> {
					shelter.addAnimal(
						new Hamster(HamsterBreed.valueOf(String.valueOf(hamsterBreedComboBox.getSelectedItem())), 
									nameField.getText(), 
									Gender.valueOf(String.valueOf(gendersComboBox.getSelectedItem())),
									Integer.parseInt(ageField.getText())
						)
					);
					mainWin.updateDisplay();
				});
			} else if(family == "Fish") {
				enter.addActionListener(event -> {
					shelter.addAnimal(
						new Fish(FishBreed.valueOf(String.valueOf(fishBreedComboBox.getSelectedItem())), 
									nameField.getText(), 
									Gender.valueOf(String.valueOf(gendersComboBox.getSelectedItem())),
									Integer.parseInt(ageField.getText())
						)
					);
					mainWin.updateDisplay();
				});
			}
			data.add(enter);
	}
}