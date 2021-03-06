/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.text.DateFormat;
//import java.time.Instant;
//import static java.time.temporal.ChronoUnit.DAYS;
//import java.util.concurrent.TimeUnit;
//import TimeUnit java.util.concurrent.TimeUnit.DAYS;

public class daysold {

/**
 * Calculate how many days between today and the date, and them out
 * @param birthday      {@code String} The start date
 */
public static void days(String birthday) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false); // raises ParseException error on Feb 29 on non leap year

//      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");

        Calendar today = GregorianCalendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        Calendar bday = GregorianCalendar.getInstance();
        bday.set(Calendar.HOUR_OF_DAY, 0);
        bday.set(Calendar.MINUTE, 0);
        bday.set(Calendar.SECOND, 0);
        bday.set(Calendar.MILLISECOND, 0);

        ;         try {// Attempt to parse user input
                Date date = formatter.parse(birthday);
                bday.setTime(date);
        }
        catch (java.text.ParseException e) {
//				e.printStackTrace();
                System.out.println("Invalid birthday! Must be in format: yyyy-MM-dd and not be February 29 on a non leap year.");
                return;
//        System.out.println("Invalid birthday! Must be in format: yyyy-dd-MM");
        }

        // format output strings
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM d yyyy");
        String formattedbDay = outputFormat.format(bday.getTime());
        String formattedToday = outputFormat.format(today.getTime());



//      find age in milliseconds, then convert to days if the date is valid
//      there are  86400000 milliseconds in a day ( Math.round will take care of daylight savings's 1 hour difference )
//     Instances aren't in the standard library in java 7 :(
        long daysOld = Math.round((today.getTime().getTime() - bday.getTime().getTime()) / (double) 86400000);
//      int daysOld = (int) TimeUnit.MILLISECONDS.toDays(today.getTimeInMillis()-bday.getTimeInMillis()); // off-by-one in some cases :/

        if(daysOld<0) {
                System.out.println(String.format("Birthday: %s; today: %s -- Wrong birthday!", formattedbDay, formattedToday));
                return;
        }

//    THIS WOULD BE SO MUCH BETTER IN JAVA 8
//      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
//      ░░░░░▄█▀▀░░░░▄▄▄▄░░░░▄░░░░░░░░░░░░░░░░░
//      ▄░░░░▀░░░░▄█▀▀░░░░░░░█░░░░░░░░░░░░▄▄▄░▀
//      ░▀▄▄░░░░░▀▀░░░▄▄▄▄░░█░░░░░░░░░░▄▄█░░░░░
//      ░░░░▀▀▄░░░░░░▀▀░░░░░▀▄░░░░░░▄▄█████▀█▄░
//      ░░░░░░░▀▀▄▄░░░░░░░░░░█▄░░░░██▀▀▀▄█▀▀▀▀▄
//      ░░░░░░░░░░░▀▀▄░░░░░░░░▀▄░░▄██░░░░░░░░░█
//      ░░░░░░░░░░░░░░▀▀▄░░░░░░░▀▄▄██░░░░░░░░█▀
//      ░░░░░░░░░░░░░░░░▄██▄░░░░░░█▀▀█▀░▄▄▀▀▀░░
//      ░░░░░░░░░░░░░░▄█▀░▀▀░░░░░█░░█░▀▀▀█░░░░░
//      ░░░░░░░░░░░░░██░░░░░░░░░░█░░█░░░░█░░░░░
//      ▄░░░░░░░░░░▄█▀░░░░░░░░░▄░█░▄▀░░░█░░░░░░
//      ░▀▄░░░░░░▄█▀░░░░░▄▀████████▀▀▀▀█▀░░░░░░
//      ░░░▀▀▄▄▄█▀░░░░░░░█░▀███▀██▀▀▀▀██░░░░░░░
//      ░░░░░░░▀██░░░░░░█▀░░▀██░░█░░░░██░░░░░░░
//      ░░░░░░░░░░░░░░░░█░░░░███░█░░░░█▀░░░░░░░
//      ░░░░░░░░░░░░░░░░▀▄░░░░▀▀▄░░░░░█░░░░░░░░
//      ░░░░░░░░░░░░░░░░░░░░░░░░▀▄░░░░░░░░░░░░░
//      int daysOld =  (int) DAYS.between(bday.getTime().toInstant(),today.getTime().toInstant()); //getTime returns a Date object, which gets converted to an instant so that java can calculate the days between
//      if(daysOld<0) {
//        System.out.println(String.format("Birthday: %s; today: %s -- Wrong birthday!", formattedbDay, formattedToday));
//        return;
//        }

        System.out.println(String.format(
                                   "Birthday: %s; today: %s -- You are %d days old.", formattedbDay, formattedToday, daysOld));
}

/**
 * Main entry
 * @param args          {@code String[]} Command line arguments
 */
public static void main(String[] args) {
        days("2000-01-01");
        days("3000-01-01");  // This is a wrong birthday
}

}
