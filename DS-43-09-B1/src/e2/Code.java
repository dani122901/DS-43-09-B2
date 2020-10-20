package e2;

public class Code {

    public static boolean isKeypadValid ( char [][] keypad ) {


        boolean columnas = false;

        if (keypad != null) {

            if ((keypad.length > 1) && (keypad[1] != null) && (keypad[1][0] == '2'))
                columnas = true;

            int aux = 49;

            if (columnas) {

                for (int i = 0; i < keypad[0].length; i++) {

                    for (int j = 0; j < keypad.length; j++) {

                        if (aux <= 57) {

                            if (keypad[j][i] != (char) aux)

                                return false;

                            else aux++;

                        }

                        if((aux == 58) && (keypad[j][i] == '0'))

                            aux = 65;

                        else if ((aux >= 65) && (aux <= 90)) {

                            if (keypad[j][i] != (char) aux)

                                return false;

                            else aux ++;

                        }
                    }
                }
            } else {

                for (int i = 0; i < keypad.length; i++) {

                    for (int j = 0; j < keypad[i].length; j++) {

                        if (aux <= 57) {

                            if (keypad[i][j] != (char) aux)

                                return false;

                            else aux++;

                        }

                        if((aux == 58) && (keypad[i][j] == '0'))

                            aux = 65;

                        else if ((aux >= 65) && (aux <= 90)) {

                            if (keypad[i][j] != (char) aux)

                                return false;

                            else aux ++;

                        }
                    }
                }
            }
            return true;
        }
        else return false;
    }

    public static boolean areMovementsValid ( String [] movements ) {
            if (movements !=null) {
                for (int n = 0; n < movements.length; n++) {
                    if (movements[n] != null) {
                        for (int i = 0; i < movements[n].length(); i++) {
                            if ((movements[n].charAt(i) != 'U') && (movements[n].charAt(i) != 'R') && (movements[n].charAt(i) != 'L') && (movements[n].charAt(i) != 'D')) {
                                return false;
                            }
                        }
                    }
                    else return false;
                }
            }
            else return false;
        return true;
    }
    /**
     * Given a keypad and an array of movements , it returns a String with the code
     * resulting from applying the movements on the keypad .
     * @param keypad alphanumeric keypad .
     * @param movements Array with the different movements to be made for each
    number of the key .
     * @return Resulting code .
     * @throws IllegalArgumentException if the keypad of the movements are invalid .
     */
    public static String obtainCode ( char [][] keypad , String [] movements ) {
        String finalCode = "";
        int row = 0;
        int column = 0;
        for (String movement : movements) {
            if (movement != null) {
                for (int n = 0; n < movement.length(); n++) {
                    if (column < (keypad[0].length - 1) && movement.charAt(n) == 'R') {
                        column++;
                    } else if (column > 0 && movement.charAt(n) == 'L') {
                        column--;
                    } else if (row > 0 && movement.charAt(n) == 'U') {
                        row--;
                    } else if (row < (keypad.length - 1) && movement.charAt(n) == 'D') {
                        row++;
                    }
                }
                if (row >= 0 && row < keypad.length && column >= 0 && column < keypad[0].length)
                    finalCode = finalCode + keypad[row][column];
                else throw new IllegalArgumentException("Invalid position");
            }
        }
        return finalCode;
    }
}
