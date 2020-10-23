package e3;

import java.util.Objects;

public class Clock {

    enum Period {PM, AM }

    private final int clockHours24;
    private final int clockHours12;
    private final int clockMinutes;
    private int clockSeconds;
    private final Period clockPeriod;

    //Variables que tiene la clase reloj


    public Clock ( String s) {

        if (s != null && (s.length() == 8 || s.length() == 11)) { //Si el string es no nulo y tiene una de las longitudes válidas

            int hour = Integer.parseInt(s.substring(0,2)); //Guardamos las horas
            int minutes = Integer.parseInt(s.substring(3,5)); //Guardamos los minutos
            int seconds = Integer.parseInt(s.substring(6,8)); //Guardamos los segundos

            if (s.length() == 8 && hour >= 0 && hour < 24) { //Si es longitud 8 es formato 24h

                clockHours24 = hour; // Guardamos la hora en su variable

                if (hour > 0 && hour <= 12) { //Adaptar la hora 24h al formato 12h

                    clockHours12 = hour;
                    clockPeriod = Period.AM;
                }

                else if (hour > 12) {

                    clockHours12 = hour - 12;
                    clockPeriod = Period.PM;
                }

                else {

                    clockHours12 = 12;
                    clockPeriod = Period.AM;

                }

                if (minutes <= 60) //Si los minutos tienen un valor válido los almacenamos

                    clockMinutes = minutes;

                else throw new IllegalArgumentException("Not a valid hour");

                if (seconds <= 60) //Si los segundos tienen un valor válido los almacenamos

                    clockSeconds = seconds;

                else throw new IllegalArgumentException("Not a valid hour");

            } else if (s.length() == 11 && hour > 0 && hour <= 12) { //Si es formato 12h

                    clockHours12 = hour;

                if (minutes <= 60)

                    clockMinutes = minutes;

                else throw new IllegalArgumentException("Not a valid hour");

                if (seconds <= 60)

                    clockSeconds = seconds;

                if (s.charAt(9) == 'A' && s.charAt(10) == 'M') { //Vemos si es AM

                    clockPeriod = Period.AM;

                    if (hour < 12) //Adaptamos la hora al formato 24h

                        clockHours24 = hour;

                    else clockHours24 = 0;

                } else if (s.charAt(9) == 'P' && s.charAt(10) == 'M') { //Vemos si es PM

                    clockPeriod = Period.PM;

                    if (hour < 12) //Adaptamos la hora al formato 24h

                        clockHours24 = hour + 12;

                    else clockHours24 = hour;

                } else throw new IllegalArgumentException("Not a valid hour");

            } else throw new IllegalArgumentException("Not a valid hour");


        } else throw new IllegalArgumentException("Not a valid hour");

    }


    public Clock ( int hours , int minutes , int seconds ) { //Formato 24h lo mismo que en el anterior

        if (hours >= 0 && hours < 24) {

            clockHours24 = hours;

            if (hours > 0 && hours <= 12) {

                clockHours12 = hours;

                if (hours < 11)

                    clockPeriod = Period.AM;

                else clockPeriod = Period.PM;

            } else if (hours > 12) {

                clockHours12 = hours - 12;
                clockPeriod = Period.PM;

            }
            else {

                clockHours12 = hours + 12;
                clockPeriod = Period.AM;
            }

        } else throw new IllegalArgumentException ("Not a valid hour");

        if (minutes >= 0 && minutes <=60)

            clockMinutes = minutes;

        else throw new IllegalArgumentException ("Not a valid hour");

        if (seconds >= 0 && seconds <= 60)

            clockSeconds = seconds;

        else throw new IllegalArgumentException ("Not a valid hour");

    }

    public Clock ( int hours , int minutes , int seconds , Period period ) { //Formato 12h lo mismo que en el primer constructor

        if (hours >= 0 && hours <= 12)

            clockHours12 = hours;

        else throw new IllegalArgumentException ("Not a valid hour");

        if (minutes >= 0 && minutes <= 60)

            clockMinutes = minutes;

        else throw new IllegalArgumentException ("Not a valid hour");

        if (seconds >= 0 && seconds <= 60)

            clockSeconds = seconds;

        else throw new IllegalArgumentException ("Not a valid hour");

        if (period.equals(Period.PM)) {

            clockPeriod = Period.PM;

            if (hours < 12)

                clockHours24 = hours + 12;

            else clockHours24 = hours;
            

        } else if (period.equals(Period.AM)) {

            clockPeriod = Period.AM;

            if (hours < 12)

                clockHours24 = hours;

            else clockHours24 = 0;

        } else throw new IllegalArgumentException ("Not a valid hour");

    }

    public int getHours24 () {

        return clockHours24; //Devolvemos la hora 24h

    }

    public int getHours12 () {

        return clockHours12; //Devolvemos la hora 12h

    }

    public int getMinutes () {

        return clockMinutes; //Devolvemos los minutos
    }

    public int getSeconds () {

        return clockSeconds; //Devolvemos los segundos
    }

    public Period getPeriod () { //Devolvemos el periodo

        return clockPeriod;

    }

    public String printHour24 () {

        String HourIn24Format; //String en el que almacenamos la hora

        //If elses para añadir los 0 necesarios para adaptarlo al formato pedido

        if (clockHours24 < 10)

            HourIn24Format = "0" + clockHours24 + ":";

        else HourIn24Format = clockHours24 + ":";

        if (clockMinutes < 10)

            HourIn24Format = HourIn24Format + "0" + clockMinutes + ":";

        else HourIn24Format = HourIn24Format + clockMinutes + ":";

        if (clockSeconds < 10)

            HourIn24Format = HourIn24Format + "0" + clockSeconds;

        else HourIn24Format = HourIn24Format + clockSeconds;

        System.out.print(HourIn24Format);

        return HourIn24Format; //Devolvemos la hora en el formato pedido
    }

    public String printHour12 () {

        String HourIn12Format; //String en el que almacenamos la hora

        //If elses para añadir los 0 necesarios para el formato pedido

        if (clockHours12 < 10)

            HourIn12Format = "0" + clockHours12 + ":";

        else HourIn12Format = clockHours12 + ":";

        if (clockMinutes < 10)

            HourIn12Format = HourIn12Format + "0" + clockMinutes + ":";

        else HourIn12Format = HourIn12Format + clockMinutes + ":";

        if (clockSeconds < 10)

            HourIn12Format = HourIn12Format + "0" + clockSeconds + " " + clockPeriod;

        else HourIn12Format = HourIn12Format + clockSeconds + " " + clockPeriod;

        System.out.print(HourIn12Format);

        return HourIn12Format; //Devolvemos la hora en el formato pedido
    }

    @Override
    public boolean equals ( Object o) {

        //Función equals. Son iguales 2 relojes si expresan la misma hora independientemente del formato

        if (this == o) return true;

        if (o == null) return false;

        if (this.getClass() != o.getClass()) return false;

        Clock clock = (Clock) o;

        if (this.clockHours24 != clock.clockHours24) return false;

        if (this.clockMinutes != clock.clockMinutes) return false;

        if (this.clockSeconds != clock.clockSeconds) return false;

        return this.clockPeriod == clock.clockPeriod;


    }

    @Override
    public int hashCode () {

        //Hashcode con los mismos campos a tener en cuenta que el equals

       return Objects.hash(clockHours24, clockMinutes, clockSeconds, clockPeriod);

    }

}
