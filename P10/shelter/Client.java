package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Client {
	private String name;
	private String phone;

	public Client(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public Client(BufferedReader bufferedReader) throws IOException {
		this.name = bufferedReader.readLine();
		this.phone = bufferedReader.readLine();
	}

	public void save(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write(this.name + "\n");
		bufferedWriter.write(this.phone + "\n");
	}

	@Override
	public String toString() {
		return "Name:  " + this.name + "\n" + "Phone: " + this.phone + "\n";
	}
}