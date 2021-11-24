package extraCreditAssg_varnellr18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Class to create a flight map from given files. Uses an adjacent list I think.
 * @author Ryan Varnell
 */
public class FlightMap implements FlightMapInterface {
	// It's a list of lists. Important.
	LinkedList<LinkedList<City>> flightMap;

	/**
	 * Creates an empty FlightMap
	 */
	public FlightMap() {
		flightMap = new LinkedList<>();
	}

	/**
	 * Retrieves information about the cities and adjacency's from the two
	 * files provided and stores the information in the FlightMap object.
	 * @param cityFileName The name of a file containing a list of city names;
	 *        one city name per line.
	 * @param flightFileName The name of a file showing city adjacency's.
	 *        There will be two city names listed per line, separated by a tab
	 *        character; the first city on the line is adjacent to the
	 *        second city on the same line.
	 * @throws FileNotFoundException if either the city file or the flight
	 *         file are not able to be opened.
	 */
	public void loadFlightMap(String cityFileName, String flightFileName)
			throws FileNotFoundException {

		// Creates a new ArrayList for each City in the City file, sets that City as the initial object in said list,
		// and adds the Arraylist to the flightMap arrayList.
		Scanner cityFile = new Scanner(new File(cityFileName));
		while (cityFile.hasNextLine()) {
			LinkedList<City> list = new LinkedList<>();
			City city = new City(cityFile.nextLine());
			list.add(city);
			flightMap.add(list);
		}
		cityFile.close();

		// Iterate through the adjacency's in the flight file and connect the cities to one another.
		Scanner flightFile = new Scanner(new File(flightFileName));
		while (flightFile.hasNextLine()) {

			// For each line in the flight file, "split" will contain the origin city at split[0] and it's adjacent
			// city at split[1].
			String[] split = flightFile.nextLine().split("\t");

			// This first for/if combo will iterate through each ArrayList in the flightMap, and if it finds a list
			// beginning with a City whose name matches with the origin City in the flight file (i.e. split[0]) then...
			for (LinkedList<City> originCity : flightMap) {
				if (originCity.get(0).getName().equals(split[0])) {
					// ...It iterates through the flightMap list again until it finds another match for a list
					// beginning with a City whose name matches that of the adjacent city in the flight file
					// (i.e. split[1]), and adds the adjacent City to the end of the list of the origin City through a
					// call to insertAdjacent.
					for (LinkedList<City> adjacentCity : flightMap) {
						if (adjacentCity.get(0).getName().equals(split[1])) {
							insertAdjacent(originCity.get(0), adjacentCity.get(0));
						}
					}
				}
			}
		}
	}

	/**
	 * Inserts information into the flight map to record the fact that there
	 * is a direct flight between aCity and adjCity. Both aCity and adjCity
	 * are assumed to be valid cities that are served by the airline.
	 * @param aCity The origin city.
	 * @param adjCity The destination city.
	 */
	public void insertAdjacent(City aCity, City adjCity) {
		for (LinkedList<City> originCity : flightMap){
			if (originCity.get(0).equals(aCity)) {
				for (LinkedList<City> adjacentCity : flightMap) {
					if (adjacentCity.get(0).equals(adjCity)) {
						originCity.add(adjacentCity.get(0));
					}
				}
			}
		}
	}

	/**
	 * Displays to the screen, a list of all cities served by the airline
	 * along with the names of cities to which each is adjacent.
	 */
	public void displayFlightMap() {
		for (LinkedList<City> list : flightMap) {
			displayAdjacentCities(list.get(0));
		}
	}

	/**
	 * Displays to the screen, the names of all cities served by the airline.
	 */
	public void displayAllCities() {
		for (LinkedList<City> list : flightMap) {
			System.out.println(list.get(0));
		}
	}

	/**
	 * Displays to the screen, the names of all cities which are adjacent
	 * to aCity; aCity is assumed to be a valid city served by the airline.
	 * @param aCity The city for which the adjacency list is desired.
	 */
	public void displayAdjacentCities(City aCity) {
		for (LinkedList<City> list : flightMap) {
			if (list.get(0).equals(aCity)) {
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));

					// Will only print the directional arrow up until the last adjacent City.
					if (i < list.size() - 1)
						System.out.print(" -> ");
				}
				System.out.println();
				return;
			}
		}
	}

	/**
	 * Records information to note that aCity has been visited in the path
	 * so that aCity won't be returned again; aCity is assumed to be
	 * a valid city served by the airline.
	 * @param aCity The city to be marked.
	 */
	public void markVisited(City aCity) {
		aCity.visit();
	}

	/**
	 * Removes the visited marks on all cities served by the airline.
	 */
	public void unVisitAll() {
		for (LinkedList<City> list : flightMap){
			list.get(0).clear();
		}
	}

	/**
	 * Determines whether aCity has been visited
	 * @param aCity The city for which you wish to determine visited status.
	 * @return True if aCity has been visited, and false otherwise.
	 */
	public boolean isVisited(City aCity) {
		return aCity.isVisited();
	}

	/**
	 * Gets the next unvisited city, if any, to which aCity is adjacent.
	 * @param aCity The city for which you wish to get the next adjacency.
	 * @return The next unvisited city to which you can directly travel
	 *         from aCity, or null there are no unvisited cities to which
	 *         you can travel from aCity.
	 */
	public City getNextCity(City aCity) {
		for (LinkedList<City> list : flightMap) {
			if (list.get(0).equals(aCity)) {
				for (int i = 1; i < list.size(); i++) {
					if (!list.get(i).isVisited())
						return list.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Determines if the airline serves aCity
	 * @param aCity The city to check
	 * @return True if the airline has flights leaving or arriving at
	 *         aCity and false otherwise
	 */
	public boolean servesCity(City aCity) {
		for (LinkedList<City> list : flightMap) {
			if (list.get(0).equals(aCity))
				return true;
		}
		return false;
	}

	/**
	 * Determines if there is a sequence of flights which start at originCity,
	 * and take you to destinationCity; Both originCity and destinationCity are
	 * assumed to be valid cities served by the airline.
	 * @param originCity The city from which the search should begin
	 * @param destinationCity The final city at which you wish to arrive
	 * @return A LinkedList object containing a list of cities starting at the
	 *         originCity and ending at destinationCity, if there is a sequence
	 *         of flights from originCity to destinationCity. The
	 *         originCity will be found in position 0 of the list.
	 *         If no sequence of flights exist, then null will be returned.
	 */
	public LinkedList<City> getPath(City originCity, City destinationCity) {

		// Used the textbook code so almost visually identical.
		Stack<City> stack = new Stack<>();

		City topCity, nextCity;
		unVisitAll();	// Clear marks on all cities.

		// Push origin city onto stack, mark it visited.
		stack.push(originCity);
		markVisited(originCity);

		topCity = stack.peek();
		while (!stack.isEmpty() && (!topCity.equals(destinationCity))) {
			nextCity = getNextCity(topCity);

			if (nextCity == null) {
				stack.pop(); // No city found; backtrack.
			} else {
				stack.push(nextCity);
				markVisited(nextCity);
			}	// end if
			try {
				topCity = stack.peek();
			} catch (EmptyStackException e) {
				// Yeah, I know the stack's empty stop crashing the program.
				assert true;
			}
		}	// end while

		// If the stack's empty there's no path so return null, otherwise pop the stack to a LinkedList and return it.
		if (stack.isEmpty()) {
			return null;
		} else {
			LinkedList<City> path = new LinkedList<>();
			while (!stack.isEmpty()) {
				path.add(stack.pop());
			}
			return path;
		}
	}
}
