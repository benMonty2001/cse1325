import shelter.Hamster;
import shelter.Fish;
import shelter.Gender;
import shelter.FishBreed;
import shelter.HamsterBreed;
import shelter.Shelter;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mass extends JFrame{

	JFrame mass = new JFrame("Maveric Animal Shelter");
	
	profileFrame HamsterProfile = new profileFrame("Hamster");
	profileFrame FishProfile = new profileFrame("Fish");

	public Mass() {
		playGUI();
	}

	public void playGUI(){
		//MainJFrame
		mass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mass.setSize(500, 500);
		mass.setVisible(true);

		//JMenuBar
		JMenuBar menubar = new JMenuBar();
		mass.setJMenuBar(menubar);
		
		//JMenu  
		JMenu add = new JMenu("add");
		menubar.add(add);
		//JMenuItem
			//Hamster
			JMenuItem hamster = new JMenuItem("Hamster");
			hamster.addActionListener(event -> createProfile("Hamster"));
			add.add(hamster);
			
			//Fish
			JMenuItem fish = new JMenuItem("Fish");
			fish.addActionListener(event -> createProfile("Fish"));
			add.add(fish);
	}

	public void createProfile(String family) {
		switch(family) {
			case "Hamster" : {
		 		HamsterProfile.setVisible(true);
		 		break;
		 	} 
			case "Fish" : {
				FishProfile.setVisible(true);
				break;
			}
		}
	}

	public static void main(String[] args){
		Mass mass = new Mass();
		Shelter shelter = new Shelter("Animal");

		




		/*
		try{
			Hamster hamster = new Hamster(HamsterBreed.DWARF, "Percival", Gender.MALE, 21);
			shelter.addAnimal(hamster);
		} catch(IllegalArgumentException e){
			System.err.println(e.getMessage() + "\n");
		} try {
			Fish fish = new Fish(FishBreed.GUPPY, "Princess", Gender.FEMALE, 8);
			shelter.addAnimal(fish);
		} catch(IllegalArgumentException e){
			System.err.println(e.getMessage() + "\n");
		}
		//System.out.println(shelter.toString());
		*/


	}
}