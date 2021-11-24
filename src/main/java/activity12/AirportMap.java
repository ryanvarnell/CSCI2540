package activity12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Program to read from a text file to construct a dictionary of airport codes and cities.
 * @author Ryan Varnell
 * @author Nimra Javed
 */
public class AirportMap {
    static String fileName = "activity12_input.txt";
    static HashMap<String, String> airportDictionary = createDictionary(fileName);

    public static void main(String[] args) {
        displayMenu();
        Scanner kbd = new Scanner(System.in);
        String choice = kbd.nextLine();
        switch (choice) {
            case "1" -> displayPortsAndCities();
            case "2" -> {
                System.out.println("Give me a code and a city.");
                String code = kbd.nextLine();
                String city = kbd.nextLine();
                addAirport(code, city);
            }
            case "3" -> {
                System.out.println("Enter code :)");
                String code = kbd.nextLine();
                search(code);
            }
            case "4" -> {
                System.out.println("cya");
                System.exit(1);
            }
        }
    }

    public static HashMap<String, String> createDictionary(String fileName) {
        HashMap<String, String> hashMap = new HashMap<>();
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (inputStream.hasNextLine()) {
            hashMap.put(inputStream.next(), inputStream.next());
        }

        return hashMap;
    }

    public static void displayMenu() {
        System.out.println("""
                1. Display all the airports/cities
                2. Add a new airport
                3. Search for an airport
                4. Exit""");
    }

    public static void displayPortsAndCities() {
        Set<String> test = airportDictionary.keySet();
        Iterator<String> test2 = test.iterator();
        while (test2.hasNext()) {
            System.out.println(test2.next());
        }
    }

    public static void addAirport(String code, String city) {
        airportDictionary.put(code, city);
    }

    public static Iterator<String> search(String code) {
        Set<String> test = airportDictionary.keySet();
        Iterator<String> test2 = test.iterator();
        while (test2.hasNext()) {
            if (test2.next().equals(code)) {
                return test2;
            }
        }
        return test2;
    }
}
