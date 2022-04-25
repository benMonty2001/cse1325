import shelter.Hamster;
import shelter.Fish;
import shelter.Aligator;
import shelter.Gender;
import shelter.FishBreed;
import shelter.HamsterBreed;
import shelter.AligatorBreed;
import shelter.Shelter;
import shelter.Animal;
import shelter.Client;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JDialog;
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
import javax.swing.JComboBox;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class MainWin extends JFrame{
	private Shelter shelter = new Shelter("");
	private JLabel display = new JLabel("");

	private JFrame mainWin = new JFrame("MASS");

	public MainWin() {
		playGUI();
	}

	public void playGUI(){
		//MainJFrame
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setSize(500, 500);
		mainWin.setLayout(new BorderLayout());
		mainWin.setLocationRelativeTo(null);

		//JMenuBar
		JMenuBar menubar = new JMenuBar();
		mainWin.setJMenuBar(menubar);

		//ShelterDisplay
		mainWin.add(display, BorderLayout.CENTER);
		
		//JMenu 
			//File 
			JMenu file = new JMenu("File");
			menubar.add(file);
				//New
				JMenuItem newShelter = new JMenuItem("New");
				newShelter.addActionListener(event -> {
					try {
						onNewShelterClick();
					} catch(IOException e) {
						System.out.println(e.getMessage());
					}
				});
				file.add(newShelter);
				//Open
				JMenuItem open = new JMenuItem("Open");
				open.addActionListener(event -> {
					try {
						onOpenShelterClick();
					} catch(FileNotFoundException e) {
						JOptionPane.showMessageDialog(this, "File Not Found!");
						System.err.println(e.getMessage());
					} catch(IOException e) {
						System.err.println(e.getMessage());
					}				
				});
				file.add(open);
				//Save
				JMenuItem save = new JMenuItem("Save");
				save.addActionListener(event -> {
					try {
						onSaveShelterClick();
					} catch(IOException e) {
						System.err.println(e.getMessage());
					}
				});
				file.add(save);
				//Save As
				JMenuItem saveAs = new JMenuItem("SaveAs");
				saveAs.addActionListener(event -> {
					try {
						onSaveShelterAsClick();
					} catch(IOException e) {
						System.err.println(e.getMessage());
					}
				});
				file.add(saveAs);
				//Quit
				JMenuItem quit = new JMenuItem("Quit");
				quit.addActionListener(event -> System.exit(0));
				file.add(quit);
			//Client
			JMenu client = new JMenu("Client");
			menubar.add(client);
				//New
				JMenuItem _new = new JMenuItem("New");
				client.add(_new);
				_new.addActionListener(event -> {
					onNewClick();
				});
				//List
				JMenuItem list = new JMenuItem("List");
				client.add(list);
				list.addActionListener(event -> {
					listClients();
				});
				//Adopt
				JMenuItem adopt = new JMenuItem("Adopt");
				client.add(adopt);
				adopt.addActionListener(event -> {
					onAdoptAnimalClick();
				});
			//Animal
			JMenu animal = new JMenu("Animal");
			menubar.add(animal);
				//Hamster
				JMenuItem hamster = new JMenuItem("New Hamster");
				hamster.addActionListener(event -> newAnimal(new Hamster(), new JComboBox(HamsterBreed.values())));
				animal.add(hamster);
				//Fish
				JMenuItem fish = new JMenuItem("New Fish");
				fish.addActionListener(event -> newAnimal(new Fish(), new JComboBox(FishBreed.values())));
				animal.add(fish);
				//Aligator
				JMenuItem aligator = new JMenuItem("New Aligator");
				aligator.addActionListener(event -> newAnimal(new Aligator(), new JComboBox(AligatorBreed.values())));
				animal.add(aligator);
				//List Animals
				JMenuItem listAnimals = new JMenuItem("List Animals");
				animal.add(listAnimals);
				listAnimals.addActionListener(event -> {
					listAnimals();
				});
				//List Adoption
				JMenuItem listAdopted = new JMenuItem("List Adopted");
				animal.add(listAdopted);
				listAdopted.addActionListener(event -> {
					listAdoptions();
				});
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
			hamsterButton.addActionListener(event -> newAnimal(new Hamster(), new JComboBox(HamsterBreed.values())));
			toolBar.add(hamsterButton);
			//Fish
			Icon fishIcon = new ImageIcon("fish.png");
			JButton fishButton = new JButton(fishIcon);
			fishButton.addActionListener(event -> newAnimal(new Fish(), new JComboBox(FishBreed.values())));
			toolBar.add(fishButton);
			//Aligator
			Icon aligatorIcon = new ImageIcon("aligator.png");
			JButton aligatorButton = new JButton(aligatorIcon);
			aligatorButton.addActionListener(event -> newAnimal(new Aligator(), new JComboBox(AligatorBreed.values())));
			toolBar.add(aligatorButton);
			//Client
			Icon clientIcon = new ImageIcon("client.png");
			JButton clientButton = new JButton(clientIcon);
			clientButton.addActionListener(event -> new ClientDialog(shelter, this));
			toolBar.add(clientButton);
			//Adopt
			Icon adoptIcon = new ImageIcon("heart.png");
			JButton adoptButton = new JButton(adoptIcon);
			adoptButton.addActionListener(event -> onAdoptAnimalClick());
			toolBar.add(adoptButton);
		//Finalize
		mainWin.setVisible(true);
	}

	public void onSaveShelterClick() throws IOException {
		if(shelter.getFilename() == null) {
			JOptionPane.showMessageDialog(this, "No file has been created to save!");
			return;
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(shelter.getFilename()));

		//write animals
		shelter.save(bufferedWriter);

		bufferedWriter.close(); 
	}

	public void onSaveShelterAsClick() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".mass", "mass");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File("."));
		int result = fileChooser.showSaveDialog(this);
		
		if(result != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selectedFile));

		//write animals
		shelter.save(bufferedWriter);
		shelter.setFilename(selectedFile.toString());

		bufferedWriter.close();
	}


	public void onOpenShelterClick() throws FileNotFoundException, IOException {
		int save = 0;

		int numAnimals = 0;
		ListIterator<Animal> iAnimals = shelter.animalListIterator();

		while(iAnimals.hasNext()) {
			iAnimals.next();
			numAnimals ++;
		}

		if(numAnimals > 0) {
			save = JOptionPane.showConfirmDialog(this, "Opening a new file will delete unsaved changes! Do you wish to proceed?", "alert", JOptionPane.YES_NO_OPTION);
		}
		
		if(save == 1 || save == -1) {
			return;
		}

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".mass", "mass");

		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File("."));
		
		int result = fileChooser.showOpenDialog(this);
		
		if(result != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());

		BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));

		//.mass signature
		String signature = bufferedReader.readLine();

		if(!signature.equals("🐹🐠")) {
			JOptionPane.showMessageDialog(this, "File Format Not Supported");
			return;
		}

		//create shelter
		display.setText("");
		shelter = new Shelter(bufferedReader);
		shelter.setFilename(selectedFile.toString());
		
		bufferedReader.close();

		listAnimals();
	}

	public void onNewShelterClick() throws IOException {
		int numAnimals = 0;
		Iterator<Animal> iAnimals = shelter.animalListIterator();

		while(iAnimals.hasNext()) {
			numAnimals ++;
		}

		if(numAnimals > 0) {
			int result = JOptionPane.showConfirmDialog(this, "Creating a new file will delete unsaved changes! Do you wish to proceed?", "alert", JOptionPane.YES_NO_OPTION);
			
			if(result == 1) {
				return;
			}
		}

		shelter = new Shelter("");
		this.onSaveShelterAsClick();
	}

	public void onNewClick() {
		new ClientDialog(shelter, this);	
	}
	
	public void onAdoptAnimalClick() {

		ArrayList<Animal> animalsArrayList = new ArrayList<>();
		ListIterator<Animal> animalsi = shelter.animalListIterator();

		ArrayList<Client> clientsArrayList = new ArrayList<>();
		ListIterator<Client> clientsi = shelter.clientListIterator();

		while(animalsi.hasNext()) {
			animalsArrayList.add(animalsi.next());
		}

		while(clientsi.hasNext()) {
			clientsArrayList.add(clientsi.next());
		}

        JLabel animalsLabel = new JLabel("Animal");
        JComboBox<Animal> animalJComboBox = new JComboBox(animalsArrayList.toArray());

        JLabel clientsLabel = new JLabel("Client");
        JComboBox<Client> clientJComboBox = new JComboBox(clientsArrayList.toArray());
        
        Object[] objects = { animalsLabel, animalJComboBox, clientsLabel, clientJComboBox };
        
        int button = JOptionPane.showConfirmDialog( this,
										            objects,
										            "New Adoption",
										            JOptionPane.OK_CANCEL_OPTION);
		if(button == JOptionPane.OK_OPTION) {
            shelter.adopt((Animal)animalJComboBox.getSelectedItem(), (Client)clientJComboBox.getSelectedItem());
        	listAdoptions();
        }
    }

	public void listClients() {
		display.setText("<html>" + shelter.clientsToString()
                               .replaceAll("<","&lt;")
                               .replaceAll(">", "&gt;")
                               .replaceAll("\n", "<br/>")
                      + "</html>");
	}

	public void listAdoptions() {
		display.setText("<html>" + shelter.adoptionsToString()
	                               .replaceAll("<","&lt;")
	                               .replaceAll(">", "&gt;")
	                               .replaceAll("\n", "<br/>")
	                      + "</html>");	
	}

	public void listAnimals() {
		display.setText("<html>" + shelter.toString()
                               .replaceAll("<","&lt;")
                               .replaceAll(">", "&gt;")
                               .replaceAll("\n", "<br/>")
                      + "</html>");
	}

	private <T extends Animal> void newAnimal(T animal, JComboBox jComboBox) {
		AnimalDialog animalDialog = new AnimalDialog(animal, jComboBox, shelter, this);
	}
}