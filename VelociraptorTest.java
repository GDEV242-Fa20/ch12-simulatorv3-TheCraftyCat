

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VelociraptorTest.
 *
 * @author Catherine Oldfield
 * for RVCC GDEV242 - Fall 2020
 * @version 11-08-2020
 */
public class VelociraptorTest
{
    /**
     * Default constructor for test class VelociraptorTest
     */
    public VelociraptorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test the creation of a Velociraptor with the random age flag set
     * to true - to make sure that created Velociraptors adhere to the
     * guidelines of the class.
     */
    @Test
    public void testVelociraptor()
    {
        Field field1 = new Field(10, 10);
        Location location1 = new Location(5, 5);
        Velociraptor raptor1 = new Velociraptor(true, field1, location1);
        assertTrue(raptor1.getAge() <= raptor1.getMaxAge());
    }
}

