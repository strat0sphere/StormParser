import static junit.framework.Assert.assertEquals;

public class TupleTest {

    Tuple tuple = new Tuple();

    @org.junit.Before
    public void setUp() throws Exception {



        tuple.setBefore(5);
        tuple.setAfter(15);

    }

    @org.junit.Test
    public void testtoString() {

        assertEquals("Expected tuple should be tab delimited", "5\t15", tuple.toString());
    }
}