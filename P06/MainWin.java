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
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWin extends JFrame{
	private Shelter shelter = new Shelter("Animal");
	private JFrame mainWin = new JFrame("Maveric Animal Shelter");
	
	private profileFrame HamsterProfile = new profileFrame("Hamster", shelter, this);
	private profileFrame FishProfile = new profileFrame("Fish", shelter, this);

	private JLabel display = new JLabel("");

	public MainWin() {
		playGUI();
	}

	public void playGUI(){
		//MainJFrame
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setSize(500, 500);
		mainWin.setLayout(new BorderLayout());

		//JMenuBar
		JMenuBar menubar = new JMenuBar();
		mainWin.setJMenuBar(menubar);

		//ShelterDisplay
		mainWin.add(display, BorderLayout.CENTER);
		
		//JMenu 
			//File 
			JMenu file = new JMenu("File");
			menubar.add(file);
				//Quit
				JMenuItem quit = new JMenuItem("Quit");
				quit.addActionListener(event -> System.exit(0));
				file.add(quit);
			//Animal
			JMenu animal = new JMenu("Animal");
			menubar.add(animal);
				//Hamster
				JMenuItem hamster = new JMenuItem("New Hamster");
				hamster.addActionListener(event -> createProfile("Hamster"));
				animal.add(hamster);
				//Fish
				JMenuItem fish = new JMenuItem("New Fish");
				fish.addActionListener(event -> createProfile("Fish"));
				animal.add(fish);
			//Help
			JMenu help = new JMenu("Help");
			menubar.add(help);
				//About
				JMenuItem about = new JMenuItem("About");
				about.addActionListener(event -> {
					JOptionPane.showMessageDialog(this, 
						 "MASS\n" +
						 "Mavs Animal Shelter Software\n" +
						 "Version 1.0\n" + 
						 "Licensed under Creative Commons Zero - CC0");
				});
				help.add(about);
		//JToolBar
			JToolBar toolBar = new JToolBar();
			mainWin.add(toolBar, BorderLayout.NORTH);
			//Hamster
			Icon hamsterIcon = new ImageIcon("hamster.png");
			JButton hamsterButton = new JButton(hamsterIcon);
			hamsterButton.addActionListener(event -> createProfile("Hamster"));
			toolBar.add(hamsterButton);
			//Fish
			Icon fishIcon = new ImageIcon("fish.png");
			JButton fishButton = new JButton(fishIcon);
			fishButton.addActionListener(event -> createProfile("Fish"));
			toolBar.add(fishButton);
		//Finalize
		mainWin.setVisible(true);
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

	public void updateDisplay() {
		display.setText("<html>" + shelter.toString()
                               .replaceAll("<","&lt;")
                               .replaceAll(">", "&gt;")
                               .replaceAll("\n", "<br/>")
                      + "</html>");
	}
}