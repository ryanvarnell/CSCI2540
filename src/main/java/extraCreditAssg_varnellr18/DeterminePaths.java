package extraCreditAssg_varnellr18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A program to determine if an airline services two cities and if so, what path would be available to fly between
 * those two cities, or if there would be a path at all. This program assumes that the input files are consistent in their
 * spelling of the cities' names and that while there may be spaces separating words in the cities' names, the only tab
 * character present in the files separates the cities themselves.
 * @author Ryan Varnell
 */
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

			// Take a line of the request file and split the indicated cities into originCity and destinationCity using
			// the tab space as a delimiter.
			String[] cities = requestFile.nextLine().split("\t");
			City originCity = new City(cities[0]);
			City destinationCity = new City(cities[1]);

			// If the airline doesn't serve either city, say so and move onto the next line of the request file.
			if (!flightMap.servesCity(originCity) || !flightMap.servesCity(destinationCity)) {
				System.out.print("The airline does not serve city ");
				if (!flightMap.servesCity(originCity))
					System.out.println(originCity);
				else
					System.out.println(destinationCity);
			}

			// Otherwise, try to find a path between the origin and the destination.
			else {
				LinkedList<City> path = flightMap.getPath(originCity, destinationCity);

				// No path found.
				if (path == null)
					System.out.println("No sequence of flights exist between cities " + originCity + " and "
							+ destinationCity);

					// Congratulations there's a path :)
				else {
					System.out.println("The following sequence of flights exist between cities " + originCity + " and "
							+ destinationCity + ":");

					// Because flightMap's getPath method uses a stack it returns the path backwards, so the list needs
					// to be iterated through backwards to make sense.
					for (int i = path.size() - 1; i >= 0; i--) {
						System.out.print(path.get(i));

						// Will only print the directional arrow up until the last adjacent City, then it'll start
						// a new line
						if (i > 0)
							System.out.print(" -> ");
						else System.out.println();
					}
				}
			}
		}
	}
}
