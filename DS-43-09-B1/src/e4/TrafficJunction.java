package e4;

public class TrafficJunction {

    enum Color {V, R, A, I} //Enumerado de los colores (verde, rojo, amarillo, intermitente)

    private Color northColor;
    private Color southColor;
    private Color eastColor;
    private Color westColor;

    //Variables para el color de cada semáforo

    private int counterN;
    private int counterS;
    private int counterE;
    private int counterW;

    //Contadores para cada semáforo

    public boolean isChanged = false;

    //Variable booleana para saber si un semáforo acaba de cambiar a verde


    public TrafficJunction() {

        //Contadores a 0 y el semáforo del norte a verde y el resto rojos

        northColor = Color.V;
        counterN = 0;


        southColor = Color.R;
        counterS = 0;


        eastColor = Color.R;
        counterE = 0;

        westColor = Color.R;
        counterW = 0;

    }

    public void timesGoesBy() {

       if (northColor == Color.V && !isChanged) { //Si el color es verde y no acaba de cambiar

           if (counterN < 15) //Si aún no pasó los 15 seg en verde sumamos 1 más

               counterN ++;

           else {

               counterN = 0;
               northColor = Color.A;

               //Si llega a los 15 reseteamos el contador y pasa a amarillo
           }

       }
       else if (northColor == Color.A) { //Si está en amarillo

           if (counterN < 5) //Si no pasó los 5 seg sumamos 1

               counterN ++;

           else {

               counterN = 0;
               northColor = Color.R;
               southColor = Color.V;
               isChanged = true;

               //Si llega a los 5 pasa a rojo y el siguiente pasa a verde
               //isChanged pasa a true para que no se sumen segs a más en el semáforo que se acaba de poner en verde
           }

       }

        //Si es rojo no se hace nada
        //Lo mismo para el resto de semáforos

        if (southColor == Color.V && !isChanged) {

            if (counterS < 15)

                counterS ++;

            else {

                counterS = 0;
                southColor = Color.A;
            }

        }
        else if (southColor == Color.A) {

            if (counterN < 5)

                counterN ++;

            else {

                counterN = 0;
                southColor = Color.R;
                eastColor = Color.V;
                isChanged = true;
            }

        }

        if (eastColor == Color.V && !isChanged) {

            if (counterE < 15)

                counterE ++;

            else {

                counterE = 0;
                eastColor = Color.A;
            }

        }
        else if (eastColor == Color.A) {

            if (counterE < 5)

                counterE ++;

            else {

                counterE = 0;
                eastColor = Color.R;
                westColor = Color.V;
                isChanged = true;

            }

        }

        if (westColor == Color.V && !isChanged) {

            if (counterW < 15)

                counterW ++;

            else {

                counterW = 0;
                westColor = Color.A;
            }

        }
        else if (westColor == Color.A) {

            if (counterW < 5)

                counterW ++;

            else {

                counterW = 0;
                westColor = Color.R;
                northColor = Color.V;
                isChanged = true;

            }

        }

        isChanged = false; //isChanged pasa a false otra vez
    }


    public void amberJunction(boolean active) {

        if (active) { //Si activamos la función todos los semáforos pasan a amarillo intermitente

            northColor = Color.I;
            southColor = Color.I;
            eastColor = Color.I;
            westColor = Color.I;

        }

        else { //Si no se reinicia el ciclo

            northColor = Color.V;
            counterN = 0;


            southColor = Color.R;
            counterS = 0;


            eastColor = Color.R;
            counterE = 0;

            westColor = Color.R;
            counterW = 0;

        }

    }


    @Override
    public String toString() {

        if (northColor == Color.I) //Si está el norte en intermitente lo están todos y devolvemos el String pedido

            return "[NORTH: AMBER ON][SOUTH: AMBER ON][EAST: AMBER ON][WEST: AMBER ON]";

        else {

            //Si no vemos el estado de cada semáforo y los concatenamos al final

            String N, S, E, W;

            if (northColor == Color.R)

                N = "[NORTH: RED]";

            else if (northColor == Color.V) {

                N = "[NORTH: GREEN ";
                N = N + counterN;
                N = N + "]";

            } else N = "[NORTH: AMBER OFF " + counterN + "]";


            if (southColor == Color.R) {

                S = "[SOUTH: RED]";

            } else if (southColor == Color.V) {

                S = "[SOUTH: GREEN ";
                S = S + counterS;
                S = S + "]";

            } else S = "[SOUTH: AMBER OFF " + counterS + "]";

            if (eastColor == Color.R)

                E = "[EAST: RED]";

            else if (eastColor == Color.V) {

                E = "[EAST: GREEN ";
                E = E + counterE;
                E = E + "]";

            } else E = "[EAST: AMBER OFF " + counterE + "]";

            if (westColor == Color.R) {

                W = "[WEST: RED]";

            } else if (westColor == Color.V) {

                W = "[WEST: GREEN ";
                W = W + counterW;
                W = W + "]";

            } else W = "[WEST: AMBER OFF " + counterW + "]";

            return N + S + E + W; //Devolvemos el string final
        }
    }

}

