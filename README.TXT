Project: foxes-and-rabbits-v2
Authors: Catherine Oldfield for RVCC GDEV242, Fall 2020
INspired by code from Michael Kölling and David J. Barnes

This project is part of the material for chapter 10 of the book

   Objects First with Java - A Practical Introduction using BlueJ
   Sixth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2016

A predator-prey simulation involving foxes and rabbits in
an enclosed rectangular field.

This is the first version of the simulation. This version
does not use inheritance.

How to start:
    Create a Simulator object.
    Then call one of:
        + simulateOneStep - for a single step.
        + simulate - and supply a number (say 10) for that many steps.
        + runLongSimulation - for a simulation of 500 steps.

Summary of changes for the project:
Starting with foxes and rabbits-v2 project, complete the following:
   Exercise 12.45:
      Move the age field from Fox and Rabbit to Animal. Initialize it to
      zero in the constructor. Provide accessor and mutator methods for it
      and use these in Fox and Rabbit rather than in direct accesses to 
      the field. Make sure the program compiles and runs as before.
         Changes are pretty straightforward in moving the field and
         adding accessor/mutator methods.
   Exercise 12.46:
      Move the canBreed method from Fox and Rabbit to Animal, and rewrite it
      as shown in Code 12.8. Provide appropriate versions of getBreedingAge
      in Fox and Rabbit that return the distinctive breeding age values.
         Again, very straightforward in moving the canBreed method, and
         writing abstract method getBreedingAge in Animal, then the 
         appropriate version in each subclass.
   Exercise 12.47:
      Move the incrementAge method from Fox and Rabbit to Animal by
      providing an abstract getMaxAge method in Animal and concrete versions
      in Fox and Rabbit.
         Following from the above exercise, creating an abstract
         method in Animal and concrete versions in the subclasses. Also
         needed to create absrtact method to access the maximum age in
         each applicable subclass.
   Exercise 12.48:
      Can the breed method be moved to Animal? If so, make this change.
         Following from above, and relies on the result of Exercise 12.46
         to know if the particular instance of an Animal subclass has
         reached breeding age.
   Exercise 12.51:
      Define a completely new type of animal for the simulation, as a 
      subclass of Animal. You will need to decide what sort of impact its
      existence will have on the existing animal types. For instance, your
      animal might compete with foxes as a predator on the rabbit population,
      or your animal might prey on foxes but not on rabbits. You will 
      probably find that you need to experiment quite a lot with the 
      configuration settings you use for it. You will need to modify the 
      populate method to have some of your animals created at the start of
      the simulation.
      You should also define a new color for your new animal class. You
      can find a list of predefined color names on the API page documenting
      the Color class in the java.awt package.
         Very easy to create the actual class; with main methods moved to the
         Animal class, there's very little code creation (as in, writing from
         scratch), which is the entire point of using inheritance. By using
         the other subclasses as a shell, the actual creation of a new class
         was simple. Finding the balance of the numbers (breeding age, max 
         age, food value, etc.) proved a little more interesting and very 
         much an exercise in trial and error - which is in part the point
         of a simulation, after all.
Other:
   Researching what the professor meant by "Use Markdown to edit your READ.ME
   file detailing your changes and assumptions" since it was never covered in
   class. Lead to quite a few dead ends before finding useful links in the
   GitHub tutorials. For students who have not used this tool before, this
   part of the assignment could cause a lot of frustration on knowing what
   is meant by it.
   I had initially created a "Lab10Class" as a place to put the text of
   each exercise, copied from the book. Had I known beforehand how to 
   edit this file here on GitHub, I could have put that information here
   to have it right at hand. That would have been much more useful to 
   know up front.
