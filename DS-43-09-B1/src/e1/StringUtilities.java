package e1;

public class StringUtilities {

    public static boolean isValidMix (String a, String b, String c) {

        int currentPositionA = 0; //Variable para saber en qué posición de a estamos
        int currentPositionB = 0; //Variable para saber en qué posición de b estamos

        for (int i = 0; i < c.length(); i++) { //Recorremos las posiciones de la mezcla de c

            if (currentPositionA < a.length() && c.charAt(i) == a.charAt(currentPositionA)) //Si el caracter de c coincide con el actual de a

                currentPositionA ++; //Pasamos a buscar el siguiente hasta que tengamos todos

            else if (currentPositionB < b.length() && c.charAt(i) == b.charAt(currentPositionB)) //Si el caracter de c coincide con el actual de b

                currentPositionB ++; //Pasamos a buscar el siguiente hasta que tengamos todos

            else
                return false; //Si no coincide no es válida la mezcla
        }

        return (a.length() + b.length()) == c.length(); //Si c tiene todos los caracteres de a y b es válida
    }


    public static String generateRandomValidMix (String a, String b) {

        StringBuilder A = new StringBuilder(); //Un StringBuilder en el que almacenaremos la mezcla de a y b
        int secondIndexA = 1;
        int firstIndexA = 0;
        int secondIndexB = 1;
        int firstIndexB = 0;
        int count = 0;

        //Declaramos dos índices por cada variable para extraer un caracter y concatenarlo a c
        //Un contador para llevar la cuenta de cuántos caracteres llevamos concatenados

        while(count < (a.length() + b.length())) { //


            int randomNumber = (int) Math.floor(Math.random() * 2); //Generamos un número aleatorio 0 o 1 para elegir a o b

            if (randomNumber == 0 && (secondIndexA <= a.length())) { //Si es 0 y aún quedan caracteres de a por concatenar

                A.append(a, firstIndexA, secondIndexA); //Concatenamos al StringBuilder el caracter

                secondIndexA ++;
                firstIndexA ++;
                count ++;

                //Sumamos 1 a cada índice y al contador
            }

            else if (randomNumber == 1 && (secondIndexB <= b.length())) { //Si es 1 y aún quedan caracteres de b por concatenar

                A.append(b, firstIndexB, secondIndexB); //Concatenamos al StringBuilder el caracter

                secondIndexB ++;
                firstIndexB ++;
                count ++;

                //Sumamos 1 a cada índice y al contador

            }

        }

        return A.toString(); //Devolvemos el StringBuilder convertido a string
    }

}
