class Word {
	private char[] letters;

	public Word(String word){
		word = word.toUpperCase();
		letters = word.toCharArray();
	}

	public char charAt(int position){
		char letter = letters[position];
		return letter;
	}

	public void setCharAt(char c, int position){
		letters[position] = c;
	}

	@Override
	public String toString(){
		String str = new String(letters);
		return str; 
	}
}