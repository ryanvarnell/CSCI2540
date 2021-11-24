// A class to store and manipulate rational numbers.
// @author Ryan Varnell

package assg2_varnellr18;

public class RationalNum {
    private int numerator, denominator;

    // Default Constructor.
    public RationalNum() {
        numerator = 0;
        denominator = 1;
    }

    // Constructor for numerator assignment only.
    public RationalNum(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }

    // Constructor for numerator and denominator assignment. Checks for zero division and negatives.
    public RationalNum(int numerator, int denominator) {
        if (denominator == 0) System.out.println("Zero cannot be in the denominator.");
        else if (denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    // Returns a string with the rational number in X/Y format.
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Tests to make sure the parameter passed is a RationalNum, and compares it to the current RationalNum.
    public boolean equals(Object userObject) {
        return (userObject instanceof RationalNum) &&
                ((this.numerator * ((RationalNum) userObject).denominator) ==
                        (((RationalNum) userObject).numerator * this.denominator));
    }

    // Getter for denominator.
    public int getDenominator() {
        return denominator;
    }

    // Getter for numerator.
    public int getNumerator() {
        return numerator;
    }

    // Adds two RationalNums using formula (A/B) + (C/D) = (A*D + B*C) / (B*D).
    public RationalNum add(RationalNum secondNum) {
        return new RationalNum((this.numerator * secondNum.denominator + this.denominator * secondNum.numerator),
                (this.denominator * secondNum.denominator));
    }

    // Subtracts two RationalNums using formula (A/B) -(C/D) = (A*D -B*C) / (B*D).
    public RationalNum sub(RationalNum secondNum) {
        return new RationalNum((this.numerator * secondNum.denominator - this.denominator * secondNum.numerator),
                (this.denominator * secondNum.denominator));
    }

    // Multiplies two RationalNums using formula (A/B) * (C/D) = (A*C) / (B*D)
    public RationalNum mul(RationalNum secondNum) {
        return new RationalNum((this.numerator * secondNum.numerator), (this.denominator * secondNum.denominator));
    }

    // Divides two RationalNums using formula (A/B) / (C/D) = (A*D) / (B*C)
    public RationalNum div(RationalNum secondNum) {
        return new RationalNum((this.numerator * secondNum.denominator), (this.denominator * secondNum.numerator));
    }

    // Negates this RationalNum and returns a new RationalNum.
    public RationalNum neg() {
        return new RationalNum(this.numerator * -1, this.denominator);
    }
}
