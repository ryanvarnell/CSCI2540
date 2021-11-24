package extraCreditAssg_varnellr18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class DeterminePaths {
	private static final String CITY_FILE_NAME = "cityFile.txt";
	private static final String FLIGHT_FILE_NAME = "flightFile.txt";
	private static final String REQUEST_FILE_NAME = "requestFile.txt";

	public static void main(String[] args) {
		FlightMap flightMap = new FlightMap();
		Scanner requestFile = null;
		try {
			flightMap.loadFlightMap(CITY_FILE_NAME, FLIGHT_FILE_NAME);
			requestFile = new Scanner(new File(REQUEST_FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		// Loop to process the flight path requests.
		while (requestFile.hasNextLine()) {
			String[] cities = requestFile.nextLine().split("\t");
			City originCity = new City(cities[0]);
			City destinationCity = new City(cities[1]);
			
			if (!flightMap.servesCity(originCity))
				doesNotServe(originCity);
			else if (!flightMap.servesCity(destinationCity))
				doesNotServe(destinationCity);
			else {
				LinkedList<City> path = findPath(flightMap, originCity, destinationCity);
				if (path == null)
					System.out.println("No sequence of flights exist between cities " + originCity + " and " 
							+ destinationCity);
				else {
					System.out.println("The following sequence of flights exist between cities " + originCity + " and "
							+ destinationCity + ":");
					for (int i = path.size() - 1; i >= 0; i--) {
						System.out.print(path.get(i));

						// Will only print the directional arrow up until the last adjacent City, otherwise it'll start
						// a new line
						if (i > 0)
							System.out.print(" -> ");
						else System.out.println();
					}
				}
			}
		}
	}

	public static LinkedList<City> findPath(FlightMap flightMap, City originCity, City destinationCity) {
		return flightMap.getPath(originCity, destinationCity);
	}
	
	public static void doesNotServe(City city) {
		System.out.println("The airline does not serve city " + city);
	}
}
