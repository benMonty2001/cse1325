import shelter.FishBreed;
import shelter.HamsterBreed;
import shelter.Hamster;
import shelter.Fish;
import shelter.Shelter;
import shelter.Gender;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JButton;

import java.awt.Color;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import javax.swing.JLabel;

import java.lang.Character;

public class profileFrame extends JFrame {
	public profileFrame(String family, Shelter shelter, MainWin mainWin) {
		setSize(200,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(family);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		setLocationRelativeTo(null);
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
					JComboBox<String> fishBreedComboBox = new JComboBox<String>(fishBreeds);
					//Hamster
					JComboBox<String> hamsterBreedComboBox = new JComboBox<String>(hamsterBreeds);
		
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
				JComboBox<String> gendersComboBox = new JComboBox<String>(genders);
				data.add(gendersComboBox);

			//Fillables
				//Name
				JTextField nameField = new JTextField("name");
				data.add(nameField);
				//Age
				JSlider ageSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
				JLabel ageLabel = new JLabel("age = " + ageSlider.getValue());
				ageSlider.addChangeListener(event -> ageLabel.setText("age = " + ageSlider.getValue()));
				data.add(ageSlider);
				data.add(ageLabel);

			//Buttons
				//Enter
				JButton enter = new JButton("Enter");
			
				if(family == "Hamster") {
					enter.addActionListener(event -> {
						shelter.addAnimal(
							new Hamster(HamsterBreed.valueOf(String.valueOf(hamsterBreedComboBox.getSelectedItem())), 
										nameField.getText(), 
										Gender.valueOf(String.valueOf(gendersComboBox.getSelectedItem())),
										ageSlider.getValue()
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
										ageSlider.getValue()
							)
						);
						mainWin.updateDisplay();
					});
				}
				data.add(enter);
	}
}