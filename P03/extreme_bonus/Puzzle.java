class Puzzle {
    private Word solution;
    private boolean solved;

    public static final String RESET = "\033[0m";
    public static final String GRAY_BACKGROUND = "\033[0;100m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String YELLOW_BACKGROUND = "\033[0;103m";

    private String colorize(String input){
        char[] guess = input.toUpperCase().toCharArray();
        char[] actual = solution.toString().toCharArray();
        String[] colorized = new String[guess.length];

        for(int i = 0; i < guess.length; i++){
            boolean isCorrectLetter = false;
            boolean isCorrectIndex = false;  
            for(int j = 0; j < actual.length; j++){
                if(guess[i] == actual[j] && i == j){
                    isCorrectLetter = true;
                    isCorrectIndex = true;
                } else if(guess[i] == actual[j] && i != j){
                    isCorrectLetter = true;
                }

                if(isCorrectLetter && isCorrectIndex){
                    colorized[i] = GREEN_BACKGROUND + guess[i] + RESET;
                } else if(isCorrectLetter && !isCorrectIndex){
                    colorized[i] = YELLOW_BACKGROUND + guess[i] + RESET;
                } else {
                    colorized[i] = GRAY_BACKGROUND + guess[i] + RESET;
                }    
            }
        }

        return colorized[0] + 
               colorized[1] +
               colorized[2] +
               colorized[3] +
               colorized[4]; 
    }

    public Puzzle(String solution){
        this.solution = new Word(solution);
    }

    public boolean isSolved(){
        return solved;
    }

    public String compareGuess(String input) {
        Word guess = new Word(input);

        if(guess.toString().equals(solution.toString())){
            solved = true;
        }

        return colorize(guess.toString());
    }
}

