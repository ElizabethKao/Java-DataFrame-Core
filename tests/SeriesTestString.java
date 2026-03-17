import static org.junit.jupiter.api.Assertions.*;

class SeriesTestString {

    Series<String> s;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        String[] rowNamesString = {"D", "E", "F"};
        String[] dataString = {"hi", "im", "liz"};

        s = new Series<String> (rowNamesString, dataString);

        System.out.println(s.toString());

    }

    @org.junit.jupiter.api.Test
    void getDataTest() {
        String[] expected = {"hi", "im", "liz"};
        assertArrayEquals(expected, s.getData());
    }

    @org.junit.jupiter.api.Test
    void appendTest() {
        s.append("G", "kristen");
        assertEquals(4, s.getLength());
        assertEquals("kristen", s.iloc(3));
    }
    @org.junit.jupiter.api.Test
    void locTest() {
        assertEquals("im", s.loc("E"));
        assertNull(s.loc("W"));

        assertThrows(NullPointerException.class, () -> s.loc((String) null));
        assertThrows(IllegalArgumentException.class, () -> s.loc(""));
    }

    @org.junit.jupiter.api.Test
    void locArrayTest() {
        String[] testers = {"D", "E", "blahblahblah"};
        String[] expected = {"hi", "im", null};
        assertArrayEquals(expected, s.loc(testers));

        assertThrows(NullPointerException.class, () -> s.loc((String[]) null));

        assertThrows(IllegalArgumentException.class, () -> s.loc(new String[0]));
    }

    @org.junit.jupiter.api.Test
    void ilocTest() {
        assertEquals("hi", s.iloc(0));
        assertNull(s.iloc(999));
    }

    @org.junit.jupiter.api.Test
    void dropTest() {
        assertTrue(s.drop("E"));
        assertEquals(2, s.getLength());
        assertFalse(s.drop("Z"));

        assertThrows(NullPointerException.class, () -> s.drop(null));
    }

    @org.junit.jupiter.api.Test
    void fillNullTest() {
        s.append("G", null);
        s.fillNull("space");
        assertEquals("space", s.loc("G"));

        assertThrows(IllegalArgumentException.class, () -> s.fillNull(null));

    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {

        System.out.println("===========");
        System.out.println(s.toString());
    }
}