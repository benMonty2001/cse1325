import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class WordList {
    public static String getWord() throws FileNotFoundException { 
        File file = new File("wordlist.txt");

        Scanner in = new Scanner(file);

        ArrayList<String> words = new ArrayList<String>();
        while(in.hasNextLine()){
            words.add(in.nextLine());
        }
        return words.get((int) (words.size() * Math.random()));
    }
}
