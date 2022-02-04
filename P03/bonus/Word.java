class Word {
	private char[] letters;

	private boolean containsNonAlpha(String word){
		char[] arr = word.toCharArray();
		for(int i = 0; i < arr.length; i++){
			if(!Character.isLetter(arr[i]) && 
								   arr[i] != ' ' &&
								   arr[i] != '.'){
				return true;
			}
		}
		return false;
	}

	public Word(String word){
		if(word.length() != 5 || containsNonAlpha(word)){
			throw new IllegalArgumentException("Invalid guess: Not 5 letters!");
		} 
		letters = word.toUpperCase().toCharArray();
	}

	public char charAt(int position){
		if(position > 4){
			throw new IndexOutOfBoundsException("Index out of bounds!");
		} 
		char letter = letters[position];
		return letter;
	}

	public void setCharAt(char c, int position){
		if(position > 4){
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}
		if(!Character.isLetter(c) && 
							   c != ' ' &&
							   c != '.'){
			throw new IllegalArgumentException("Invalid guess: Not 5 letters!");		
		}
		letters[position] = c;
	}

	@Override
	public String toString(){
		String str = new String(letters);
		return str; 
	}
}