package assg5_varnellr18;

import junit.framework.TestCase;

/**
 * JUnit 3 test class for RationalNum
 * @author Ryan Varnell
 */
public class TestRationalNum extends TestCase {
    private RationalNum num1, num2, num3, num4;
    @Override

    protected void setUp() throws Exception {
        super.setUp();
        num1 = new RationalNum();
        num2 = new RationalNum(3);
        num3 = new RationalNum(-6, 8);
        num4 = new RationalNum();
    }

    public void testToString() {
        assertEquals("-6/8", num3.toString());
    }

    public void testEquals() {
        assertEquals(num1, num4);
        assertFalse(num1.equals(num2));
    }

    public void testGetDenominator() {
        assertEquals(8, num3.getDenominator());
        assertNotSame(7, num3.getDenominator());
    }

    public void testGetNumerator() {
        assertEquals(-6, num3.getNumerator());
        assertNotSame(-7, num3.getNumerator());
    }

    public void testAdd() {
        assertEquals("18/8", num2.add(num3).toString());
    }

    public void testSub() {
        assertEquals("30/8", num2.sub(num3).toString());
    }

    public void testMul() {
        assertEquals("-18/8", num2.mul(num3).toString());
    }

    public void testDiv() {
        assertEquals("-24/6", num2.div(num3).toString());
    }

    public void testNeg() {
        assertEquals("6/8", num3.neg().toString());
    }
}