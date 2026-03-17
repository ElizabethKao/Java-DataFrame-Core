import static org.junit.jupiter.api.Assertions.*;

class SeriesTestDouble {

    Series<Double> s;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        String[] rowNames = {"A", "B", "C"};
        Double[] data = {1.1, 2.2, 3.3};

        s = new Series<Double>(rowNames, data);
        System.out.println(s.toString());

    }

    @org.junit.jupiter.api.Test
    void getDataTest() {
        String[] expected = {"1.1", "2.2", "3.3"};
        assertArrayEquals(expected, s.getData());
    }

    @org.junit.jupiter.api.Test
    void appendTest() {
        s.append("D", 400.0);
        assertEquals(4, s.getLength());
        assertEquals(400, s.iloc(3));
    }
    @org.junit.jupiter.api.Test
    void locTest() {
        assertEquals(2.2, s.loc("B"));
        assertNull(s.loc("W"));

        assertThrows(NullPointerException.class, () -> s.loc((String) null));
        assertThrows(IllegalArgumentException.class, () -> s.loc(""));
    }

    @org.junit.jupiter.api.Test
    void locArrayTest() {
        String[] testers = {"A", "B", "blahblahblah"};
        Double[] expected = {1.1, 2.2, null};
        assertArrayEquals(expected, s.loc(testers));

        assertThrows(NullPointerException.class, () -> s.loc((String[]) null));
    }

    @org.junit.jupiter.api.Test
    void ilocTest() {
        assertEquals(1.1, s.iloc(0));
        assertNull(s.iloc(10000));
    }

    @org.junit.jupiter.api.Test
    void dropTest() {
        assertTrue(s.drop("B"));
        assertEquals(2, s.getLength());
        assertFalse(s.drop("Missing"));

        assertThrows(NullPointerException.class, () -> s.drop(null));
    }

    @org.junit.jupiter.api.Test
    void fillNullTest() {
        s.append("D", null);
        s.fillNull(5.5);
        assertEquals(5.5, s.loc("D"));

        assertThrows(IllegalArgumentException.class, () -> s.fillNull(null));

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("===========");

        System.out.println(s.toString());
    }
}