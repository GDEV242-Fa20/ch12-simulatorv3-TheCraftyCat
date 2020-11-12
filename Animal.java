import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author Catherine Oldfield
 * for RVCC GDEV242 - Fall 2020
 * from code written by David J. Barnes and Michael Kölling
 * @version 11-08-2020
 */
public abstract class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    
    // The animal's age (per exercise 12.45).
    private int age;
    
    // A shared random number generator to control breeding
    // (per Exercise 12.48).
    private static final Random rand = Randomizer.getRandom();
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
        age = 0;
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
    
    /**
     * Set the animal's age.
     * @param newAge    The age value to assign to the animal.
     * 
     * This satisfies part of Exercise 12.45.
     */
    protected void setAge(int newAge)
    {
        age = newAge;
    }
    
    /**
     * Get the animal's age.
     * @return age  The age value assigned to the animal.
     * 
     * This satisfies part of Exercise 12.45.
     */
    protected int getAge()
    {
        return age;
    }
    
    /**
     * An animal can breed if it has reached the breeding age.
     * @return true if the animal can breed.
     * 
     * This satisfies part of Exercise 12.46.
     */
    public boolean canBreed()
    {
        return age >= getBreedingAge();
    }
    
    /**
     * Return the breeding age of this animal.
     * @return  The breeding age of this animal.
     * 
     * This satisfies part of Exercise 12.46.
     */
    abstract protected int getBreedingAge();
    
    /**
     * Increase the age.
     * This could result in the Animal's death.
     * 
     * This satisfies part of Exercise 12.47.
     */
    protected void incrementAge()
    {
        int myAge = getAge();
        myAge++;
        if(myAge > getMaxAge()) {
            setDead();
        }
    }
    
    /**
     * Return the maximum age of this animal.
     * @return  The maximum age of this animal.
     * 
     * This satisfies part of Exercise 12.47.
     */
    abstract protected int getMaxAge();
    
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     * 
     * This satisfies part of Exercise 12.48.
     */
    protected int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
    
    /**
     * Return the breeding probability of this animal.
     * @return  The breeding probability of this animal.
     * 
     * This satisfies part of Exercise 12.48.
     */
    abstract protected double getBreedingProbability();
    
    /**
     * Return the maximum litter size of this animal.
     * @return  The maximum litter size of this animal.
     * 
     * This satisfies part of Exercise 12.48.
     */
    abstract protected int getMaxLitterSize();
}
