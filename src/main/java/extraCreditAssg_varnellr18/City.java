package extraCreditAssg_varnellr18;

import java.util.ArrayList;

public class City{
	String cityName;
	boolean visited;

	/**
	 * Initializes a City with cityName and marks the
	 * City as unvisited.
	 * @param cityName The name of the city to create
	 */
	public City(String cityName) {
		this.cityName = cityName;
		visited = false;
	}
	
	
	/** 
	 * Gets the name of the City
	 * @return The city name
	 */
	public String getName() {
		return cityName;
	}
	

	/**
	 * Determines if a City has been visited
	 * @return True if the city has been visited
	 *         and false otherwise
	 */
	public boolean isVisited() {
		return visited;
	}
	
	
	/**
	 * Marks the City as having been visited
	 */
	public void visit() {
		this.visited = true;
	}
	

	/**
	 * Clears the visited mark so the city will
	 * be marked as unvisited.
	 */
	public void clear() {
		this.visited = false;
	}


	/**
	 * Overridden equals method determines if the
	 * current City name is equal to obj
	 * @param obj The object to be compared to this City
	 * @return True if this city name matches the city name
	 *         in obj, and false otherwise
	 */
	public boolean equals(Object obj) {
		return obj instanceof City && ((City) obj).cityName.equals(this.cityName);
	}
	

	/**
	 * Overrridden toString method
	 * @return The name of the city
	 */
	public String toString() {
		return this.cityName;
	}
}
