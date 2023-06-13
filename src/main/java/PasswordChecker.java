
public class PasswordChecker {
    private int minLength = 5;
    private int maxRepeats = 2;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Недопустимое значение minLength");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) throws IllegalArgumentException {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Недопустимое значение maxRepeats");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (password.length() < minLength) {
            return false;
        }
        int counter = 0;
        for (int i = 0; i < (password.length() - 1); i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                counter++;
                if (counter == maxRepeats) {
                    return false;
                }

            } else {
                counter = 0;
            }
        }

//        char prevLetter=' ';
//        for(char letter:password.toCharArray()) {
//            if (letter==prevLetter){
//                counter++;
//            } else {
//                counter=0;
//            }
//            if (counter==maxRepeats){
//                return false;
//            }
//            prevLetter=letter;
//        }

        return true;
    }
}
