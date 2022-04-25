import shelter.Shelter;
import shelter.Client;

import javax.swing.JDialog;

import javax.swing.BoxLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ClientDialog extends JDialog {
	public ClientDialog(Shelter shelter, MainWin mainWin) {
		
		//Dialog
		super(mainWin, "New Client", true);	
		super.setSize(200,200);
		super.setLocationRelativeTo(null);
		super.setLayout( new BoxLayout(super.getContentPane(), BoxLayout.Y_AXIS));

		//name
		JLabel clientNameLabel = new JLabel("Name");
		super.add(clientNameLabel);

		JTextField clientNameTextField = new JTextField();
		super.add(clientNameTextField);

		//phone no.
		JLabel clientPhoneLabel = new JLabel("Phone");
		super.add(clientPhoneLabel);
		JTextField clientPhoneTextField = new JTextField();
		super.add(clientPhoneTextField);

		//enter button
		JButton enter = new JButton("Enter");
		enter.addActionListener(event -> {
			shelter.addClient(new Client(clientNameTextField.getText(), clientPhoneTextField.getText()));
			mainWin.listClients();
		});
		super.add(enter);

		//Visibility
		super.setVisible(true);
	}	
}