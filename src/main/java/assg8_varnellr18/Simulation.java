package assg8_varnellr18;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Program to simulate a line at a bank.
 * I'm almost 90% sure this isn't how this was intended to be solved, but it works, and I think by all technicality it
 * meets the requirements. Just don't look too closely.
 * @author Ryan Varnell
 */
public class Simulation {
    // Number of people in the line and their total combined wait when all is said and done. Unit of time is arbitrary.
    private static int patrons = 0;
    private static double totalWait = 0;

    private static final String fileName = "assg8_input.txt";

    // EventList will ultimately contain all events. I don't think this was intended, but it works in my head for now.
    // If I have time, I'll get around to cleaning this up.
    private static final EventList list = new EventList();

    public static void main(String[] args) {
        // Read the file (which creates the events) and use the EventList sort() method to sort the events.
        readFile(fileName);
        list.sort();

        // Iterate through every event in the list. Simply changes prompt depending on event type.
        System.out.println("Simulation Begins");
        ListIterator<Event> eventListIterator = list.listIterator();
        while (eventListIterator.hasNext()) {
            Event e = eventListIterator.next();
            switch (e.getType()) {
                case 'A' -> processArrival(e);
                case 'D' -> processDeparture(e);
            }
            eventListIterator.remove();
        }
        System.out.println("Simulation Ends\n");

        // Bureaucracy statistics.
        printFormatted("Total number of people processed:", patrons);
        printFormatted("Average of time spent waiting:", totalWait / patrons);
    }

    /**
     * "Processes" an arrival event, but doesn't do a lot.
     * @param e Arrival event to be processed.
     */
    public static void processArrival(Event e) {
        printFormatted("Processing an arrival event at time:", e.getTime());
    }

    /**
     * "Processes" a departure event, but doesn't do a lot.
     * @param e Departure event to be processed.
     */
    public static void processDeparture(Event e) {
        printFormatted("Processing a departure event at time:", e.getTime());
    }

    /**
     * Just takes a String and an Integer and prints it formatted neatly to the terminal.
     * @param s String to be printed.
     * @param i Integer to be printed.
     */
    public static void printFormatted(String s, int i) {
        System.out.format("%-40s%-2d\n", s, i);
    }

    /**
     * Just takes a String and a double and prints it formatted neatly to the terminal.
     * @param s String to be printed.
     * @param d Integer to be printed.
     */
    public static void printFormatted(String s, double d) {
        DecimalFormat format = new DecimalFormat("0.####");  // Drops trailing zeros for whole numbers.
        String formattedFloat = format.format(d);
        System.out.format("%-40s%-2s\n", s, formattedFloat);
    }

    /**
     * Reads the arrival file and also calculates the persons' departure times. Inputs the arrival and departure events
     * into the EventList.
     * @param fileName Name of the file to be read.
     */
    public static void readFile(String fileName) {
        try {
            Scanner inputStream = new Scanner(new File(fileName));

            int lastDeparture = 0; // Keeps the time of the last departure.

            while (inputStream.hasNext()) {
                // Every line in the input file is a new arrival, so create a new arrival event and increase the
                // patron count.
                Event arrival = new Event(inputStream.nextInt(), 'A');
                patrons++;

                int transactionTime = inputStream.nextInt();
                int departure;

                // If the last departure has already occurred, process the current arrival immediately; It's departure
                // being its arrival time added to its transaction time.
                // If there is still someone ahead in the queue being processed, this person's departure time will be
                // the previous departure added to their transaction time.
                if (arrival.getTime() > lastDeparture) {
                    departure = arrival.getTime() + transactionTime;
                } else {
                    departure = lastDeparture + transactionTime;
                }

                lastDeparture = departure;
                totalWait += departure - arrival.getTime() - transactionTime;

                // Add an arrival event, and it's calculated departure event to the EventList
                list.add(arrival);
                list.add(new Event(departure, 'D'));
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
            e.printStackTrace();
        }
    }
}
