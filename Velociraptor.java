import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a Velociraptor.
 * Velociraptors age, move, eat foxes and rabbits, and die.
 * 
 * Foxes have more nutritional value than rabbits; given the opportunity,
 * a velociraptor will always eat a fox instead of a rabbit.
 * 
 * @author Catherine Oldfield
 * for RVCC GDEV242 - Fall 2020
 * from code inspired by David J. Barnes and Michael Kölling
 * @version 11-08-2020
 */
public class Velociraptor extends Animal
{
    // Characteristics shared by all velociraptors (class variables).
    
    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 10;
    // The age to which a fox can live.
    private static final int MAX_AGE = 300;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.10;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // The food value of a single fox.
    private static final int FOX_FOOD_VALUE = 12;
    // The food value of a single rabbit.
    private static final int RABBIT_FOOD_VALUE = 5;
    // A shared random number generator.
    private static final Random rand = Randomizer.getRandom();
    
    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a velociraptor. A velociraptor can be created as a new born
     * (age zero and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the velociraptor will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Velociraptor(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) {
            // age = rand.nextInt(MAX_AGE);
            setAge(rand.nextInt(MAX_AGE));
            foodLevel = rand.nextInt(FOX_FOOD_VALUE);
        }
        else {
            // age = 0;
            foodLevel = FOX_FOOD_VALUE;
        }
    }
    
    /**
     * This is what the velociraptor does most of the time: it hunts for
     * foxes and rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newVelociraptors A list to return newly born velociraptors.
     */
    public void act(List<Animal> newVelociraptors)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newVelociraptors);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    /**
     * Make this velociraptor more hungry. This could result in the
     * velociraptor's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Look for foxes or rabbits adjacent to the current location.
     * If there is a fox, the Velociraptor will eat the fox. Otherwise,
     * it will eat the rabbit.
     * Only the first live animal (fox or rabbit) is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Fox)   // always eat a fox before a rabbit
            {
                Fox fox = (Fox) animal;
                if(fox.isAlive()) { 
                    fox.setDead();
                    foodLevel = FOX_FOOD_VALUE;
                    return where;
                }
            }
            else if(animal instanceof Rabbit)   // no foxes found, look for rabbits
            {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive()) { 
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }
    
    /**
     * Check whether or not this velociraptor is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newVelociraptors A list to return newly born velociraptors.
     */
    private void giveBirth(List<Animal> newVelociraptors)
    {
        // New velociraptors are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Velociraptor young = new Velociraptor(false, field, loc);
            newVelociraptors.add(young);
        }
    }
    
    /**
     * Get the breeding age of a Velociraptor.
     * @return BREEDING_AGE     The breeding age of a Velociraptor.
     */
    public int getBreedingAge()
    {
        return BREEDING_AGE;
    }
    
    /**
     * Get the breeding age of a Velociraptor.
     * @return MAX_AGE     The breeding age of a Velociraptor.
     */
    public int getMaxAge()
    {
        return MAX_AGE;
    }
    
    /**
     * Return the breeding probability of a Velociraptor.
     * @return  The breeding probability of a Velociraptor.
     */
    public double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    /**
     * Return the maximum litter size of a Velociraptor.
     * @return  The maximum litter size of a Velociraptor.
     */
    public int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
}
