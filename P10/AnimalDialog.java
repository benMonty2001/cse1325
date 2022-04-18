import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.BoxLayout;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JButton;

import shelter.Shelter;
import shelter.Gender;
import shelter.Animal;

public class AnimalDialog <T extends Animal> {

	private Shelter shelter;

	public AnimalDialog(T animal, JComboBox jComboBox, Shelter shelter, MainWin mainWin) {
		this.shelter = shelter;
		
		JDialog animalDialog = new JDialog(mainWin, "New Animal", true);
		
		animalDialog.setSize(200,170);
		animalDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		animalDialog.setLocationRelativeTo(null);
		animalDialog.setLayout(new BoxLayout(animalDialog.getContentPane(), BoxLayout.X_AXIS));

		//description panel (left)
		JPanel descriptionPanel = new JPanel();
		animalDialog.add(descriptionPanel);
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

			//breed
			JLabel breed = new JLabel("<html>Breed: <br/><br/><html>");
			descriptionPanel.add(breed);
			
			//gender
			JLabel gender = new JLabel("<html>Gender: <br/><br/><html>");
			descriptionPanel.add(gender);
			
			//name
			JLabel name = new JLabel("<html>Name: <br/><br/><html>");
			descriptionPanel.add(name);
			
			//age
			JLabel age = new JLabel("<html>Age: <br/><br/><br/><br/><html>");
			descriptionPanel.add(age);
		
		//collection panel (right)
		JPanel collectionPanel = new JPanel();
		animalDialog.add(collectionPanel);
		collectionPanel.setLayout(new BoxLayout(collectionPanel, BoxLayout.Y_AXIS));

			//breed
			collectionPanel.add(jComboBox);
			
			//gender
			JComboBox<Gender> genders = new JComboBox(Gender.values());
			collectionPanel.add(genders);
			
			//name
			JTextField nameField = new JTextField();
			Font font = new Font("SansSerif", Font.BOLD, 18);
			nameField.setFont(font);
			collectionPanel.add(nameField);
			
			//age
			JSlider ageSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
			JLabel ageLabel = new JLabel("age = " + ageSlider.getValue());
			ageSlider.addChangeListener(event -> ageLabel.setText("age = " + ageSlider.getValue()));
			collectionPanel.add(ageSlider);
			collectionPanel.add(ageLabel);

			//enter
			JButton enter = new JButton("Enter");
			enter.addActionListener(event -> {
				
				//animal

				animal.create((Object)jComboBox.getSelectedItem(), 
							  nameField.getText(), 
							  (Gender)genders.getSelectedItem(),
							  ageSlider.getValue());

				shelter.addAnimal(animal);
				mainWin.listAnimals();
			});
			collectionPanel.add(enter);
			
			//Visiblity
			animalDialog.setVisible(true);
		}
}