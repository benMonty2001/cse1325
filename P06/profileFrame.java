import shelter.FishBreed;
import shelter.HamsterBreed;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;

public class profileFrame extends JFrame {
	public profileFrame(String family) {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(family);
		setLayout(new GridBagLayout());
		setVisible(false);

		//ComboBox
			//Breeds	
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

			//breed ComboBox
			JComboBox fishBreedComboBox = new JComboBox(fishBreeds);
			JComboBox hamsterBreedComboBox = new JComboBox(hamsterBreeds);

			switch(family) {
				case "Hamster" : {
					this.add(hamsterBreedComboBox);
					break;
				}
				case "Fish" : {
					this.add(fishBreedComboBox);
				}
			}
		//Fillables
	}
}




















