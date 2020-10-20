package e1;

public class StringUtilities {

    public static boolean isValidMix (String a, String b, String c) {

        int currentPositionA = 0;
        int currentPositionB = 0;

        for (int i = 0; i < (c.length()); i++) {

            if (currentPositionA < a.length() && c.charAt(i) == a.charAt(currentPositionA))

                currentPositionA ++;

            else if (currentPositionB < b.length() && c.charAt(i) == b.charAt(currentPositionB))

                currentPositionB ++;

            else
                return false;
        }

        return (a.length()+b.length()==c.length());
    }


    public static String generateRandomValidMix (String a, String b) {

        StringBuilder A = new StringBuilder();
        int secondIndexA = 1;
        int firstIndexA = 0;
        int secondIndexB = 1;
        int firstIndexB = 0;
        int count = 0;

        while (count < (a.length() + b.length())) {


            int randomNumber = (int) Math.floor(Math.random() * 2);

            if (randomNumber == 0 && (secondIndexA <= a.length())) {

                A.append(a, firstIndexA, secondIndexA);

                secondIndexA++;
                firstIndexA++;
                count++;
            } else if (randomNumber == 1 && (secondIndexB <= b.length())) {

                A.append(b, firstIndexB, secondIndexB);

                secondIndexB++;
                firstIndexB++;
                count++;

            }


        }
        return A.toString();
    }
}
