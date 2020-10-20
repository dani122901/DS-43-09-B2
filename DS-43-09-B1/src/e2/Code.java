package e2;

public class Code {

    public static boolean isKeypadValid ( char [][] keypad ) {


        boolean rows = false;

        if (keypad != null) {

            if ((keypad.length > 1) && (keypad[1] != null) && (keypad[1][0] == '2'))
                rows = true;

            int aux = 49;

            if (rows) {

                for (int i = 0; i < keypad[0].length; i++) {

                    for (char[] position : keypad) {

                        if (aux <= 57) {

                            if (position[i] != (char) aux)

                                return false;

                            else aux++;

                        }

                        if ((aux == 58) && (position[i] == '0'))

                            aux = 65;

                        else if ((aux >= 65) && (aux <= 90)) {

                            if (position[i] != (char) aux)

                                return false;

                            else aux++;

                        }
                    }
                }
            } else {

                for (char[] position : keypad) {

                    for (char c : position) {

                        if (aux <= 57) {

                            if (c != (char) aux)

                                return false;

                            else aux++;

                        }

                        if ((aux == 58) && (c == '0'))

                            aux = 65;

                        else if ((aux >= 65) && (aux <= 90)) {

                            if (c != (char) aux)

                                return false;

                            else aux++;

                        }
                    }
                }
            }
            return true;
        }
        else return false;
    }

    public static boolean areMovementsValid ( String [] movements ) {

        if (movements != null) {

            for (String movement : movements) {

                if (movement != null) {

                    for (int j = 0; j < movement.length(); j++) {

                        if (movement.charAt(j) != 'R' && movement.charAt(j) != 'L' && movement.charAt(j) != 'U' && movement.charAt(j) != 'D') {

                            return false;

                        }
                    }
                } else return false;

            }
            return true;

        }

        else return false;

    }


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
