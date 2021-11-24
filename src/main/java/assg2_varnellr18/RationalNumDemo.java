// Class to test RationalNum
// @author Ryan Varnell

package assg2_varnellr18;

public class RationalNumDemo {
    public static void main(String[] args) {
        // Default constructor test
        RationalNum num1 = new RationalNum();
        System.out.println("Default constructor test: " + num1);

        // Single numerator constructor test
        RationalNum num2 = new RationalNum(1);
        System.out.println("Single numerator constructor test: " + num2);

        // Numerator & denominator constructor tests
        RationalNum num3 = new RationalNum(2, 3);
        System.out.println("Numerator & denominator constructor test: " + num3);

        System.out.print("Trying to use a zero as a denominator: ");
        RationalNum notRationalNum = new RationalNum(5, 0);

        // Equality tests
        RationalNum num4 = new RationalNum();
        System.out.println("Equality test (true): " + num1.equals(num4));

        System.out.println("Equality test (false): " + num1.equals(num2));

        // getDenominator test
        System.out.println("getDenominator test: " + num3.getDenominator());

        // getNumerator test
        System.out.println("getNumerator test: " + num3.getNumerator());

        // Addition test
        System.out.println("Addition test: " + num2.add(num3));

        // Subtraction test
        System.out.println("Subtraction test: " + num2.sub(num3));

        // Multiplication test
        System.out.println("Multiplication test: " + num2.mul(num3));

        // Division test
        System.out.println("Division test: " + num2.div(num3));

        // Negation test
        System.out.println("Negation test: " + num3.neg());
    }
}
