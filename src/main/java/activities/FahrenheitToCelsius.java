// Ryan Varnell

package activities;

import java.util.*;

// Converts a user-provided temperature in Fahrenheit to Celsius
public class FahrenheitToCelsius {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int fahrenheit;
    double celsius;

    // Prompts the user for their selected temperature
    System.out.print(
      "Enter a temperature in Fahrenheit to be converted to Celsius: "
    );
    fahrenheit = input.nextInt();

    celsius = ((double) fahrenheit - 32) * 5 / 9;
    System.out.println(fahrenheit + " Fahrenheit is " + celsius + " Celsius.");
  }
}
