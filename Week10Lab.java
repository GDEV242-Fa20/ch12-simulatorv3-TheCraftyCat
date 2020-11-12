
/**
 * Write a description of class Week10Lab here.
 * 
 * Literally just a place for me to copy-paste the assignment from the 
 * book due to limited (physical) desk space.
 *
 * @Catherine Oldfield
 * for RVCC GDEV242 - Fall 2020
 * @version 11/08/2020
 */
public class Week10Lab
{
    /**
     * 12.45 - DONE
     * Move the age field from Fox and Rabbit to Animal. Initialize it to
     * zero in the constructor. Provide accessor and mutator methods for it
     * and use these in Fox and Rabbit rather than in direct accesses to 
     * the field. Make sure the program compiles and runs as before.
     * 
     * 12.46 - DONE
     * Move the canBreed method from Fox and Rabbit to Animal, and rewrite it
     * as shown in Code 12.8. Provide appropriate versions of getBreedingAge
     * in Fox and Rabbit that return the distinctive breeding age values.
     * 
     * Note to self: see page 440 in text book for code.
     * 
     * 12.47 - DONE
     * Move the incrementAge method from Fox and Rabbit to Animal by
     * providing an abstract getMaxAge method in Animal and concrete versions
     * in Fox and Rabbit.
     * 
     * 12.48 - DONE
     * Can the breed method be moved to Animal? If so, make this change.
     * 
     * 12.51 - DONE
     * Define a completely new type of animal for the simulation, as a 
     * subclass of Animal. You will need to decide what sort of impact its
     * existence will have on the existing animal types. For instance, your
     * animal might compete with foxes as a predator on the rabbit population,
     * or your animal might prey on foxes but not on rabbits. You will 
     * probably find that you need to experiment quite a lot with the 
     * configuration settings you use for it. You will need to modify the 
     * populate method to have some of your animals created at the start of
     * the simulation.
     * 
     * You should also define a new color for your new animal class. You
     * can find a list of predefined color names on the API page documenting
     * the Color class in the java.awt package.
     * 
     * From the professor: Place all of your assumptions about how the new 
     * class interacts with the system in the class header
     */
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Week10Lab
     */
    public Week10Lab()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
