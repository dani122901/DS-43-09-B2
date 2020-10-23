package e2;

public class Code {

    public static boolean isKeypadValid ( char [][] keypad ) {


        boolean columns = false; //Variable que nos indica como recorrer el teclado

        if (keypad != null) { //Si el teclado no es nulo

            if ((keypad.length > 1) && (keypad[1] != null) && (keypad[1][0] == '2'))

                columns = true;

            //Si el teclado tiene más de una fila y el primer elemento de la siguiente es un 2 significa que tenemos
            //que recorrerlo en columnas, columns = true

            int aux = 49; //Variable para llevar cuenta del ascii en el que estamos (empezando en el 1)

            if (columns) { //En columnas

                for (int i = 0; i < keypad[0].length; i++) { //Bucle recorrer columnas

                    for (char[] position : keypad) { //Bucle recorrer filas

                        if (aux <= 57) { // Mientras no pasemos del número 9

                            if (position[i] != (char) aux) //Si el siguiente número del teclado no sigue el orden

                                return false; //No es un teclado válido y devolvemos false

                            else aux++; // Si es correcto seguimos con el siguiente

                        }

                        if ((aux == 58) && (position[i] == '0')) //Cuando pasemos del 9 vendría el 0 en el teclado y vemos si es

                            aux = 65; //Si es el 0 pasamos a las letras, empezando en la A (ascii 65)

                        else if ((aux >= 65) && (aux <= 90)) { //Mientras sigamos entre la A y la Z

                            if (position[i] != (char) aux) //Si no siguen el orden

                                return false; //Devolvemos falso al no ser válido el teclado

                            else aux++; //Si no seguimos con la siguiente

                        }
                    }
                }
            } else { //Lo mismo pero recorriéndolo por filas

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

        if (movements != null) { //Si el string de movimientos no es nulo lo recorremos

            for (String movement : movements) {

                if (movement != null) { //No puede haber movimientos nulos

                    for (int j = 0; j < movement.length(); j++) {

                        if (movement.charAt(j) != 'R' && movement.charAt(j) != 'L' && movement.charAt(j) != 'U' && movement.charAt(j) != 'D') {

                            return false;

                            //Si los desplazamientos dentro de cada movimiento no son válidos (L, R, U, D) devolvemos falso

                        }
                    }
                } else return false;

            }
            return true;

        }

        else return false;

    }


    public static String obtainCode ( char [][] keypad , String [] movements ) {

        String finalCode = ""; //El string donde almacenamos el código

        int row = 0;
        int column = 0;

        //Variables para saber el dígito del código

        for (String movement : movements) { //Vamos recorriendo los movimientos

            if (movement != null) { //Si no es nulo

                for (int n = 0; n < movement.length(); n++) { //Según nos diga el movimiento nos movemos en la fila o la columna

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

                if (row >= 0 && row < keypad.length && column >= 0 && column < keypad[0].length) //Si nos indica una posicion válida del teclado

                    finalCode = finalCode + keypad[row][column]; //Agregamos al string el dígito obtenido

                else throw new IllegalArgumentException("Invalid position");
            }
        }

        return finalCode; //Devolvemos el código final
    }

}
