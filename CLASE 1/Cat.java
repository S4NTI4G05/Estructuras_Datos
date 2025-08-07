/**
 * The Cat class also implements the Animal interface.
 * Notice how it implements the same methods differently than Rabbit!
 */
public class Cat implements Animals {
    
    // Attributes specific to cats
    private String breed;
    private int lives;
    
    // Constructor
    public Cat(String breed) {
        this.breed = breed;
        this.lives = 9; // Cats traditionally have "9 lives"
    }
    
    // Implementation of eat() from Animal interface
    @Override
    public void eat() {
        System.out.println("The cat delicately eats fish and drinks milk 🐟");
    }
    
    // Implementation of sleep() from Animal interface
    @Override
    public void sleep() {
        System.out.println("The cat curls up and sleeps for 16 hours a day");
    }
    
    // Implementation of makeSound() from Animal interface
    @Override
    public void makeSound() {
        System.out.println("The cat says: Meow! 🐱");
    }
    
    // Implementation of move() from Animal interface
    @Override
    public void move() {
        System.out.println("The cat walks silently and gracefully");
    }
    
    // Implementation of getSpecies() from Animal interface
    @Override
    public String getSpecies() {
        return "Cat";
    }
    
    // Methods unique to Cat
    public void purr() {
        System.out.println("The cat purrs contentedly: purrrrr...");
    }
    
    public void climb() {
        System.out.println("The cat climbs up the tree with sharp claws");
    }
    
    public boolean huntMouse() {
        System.out.println("The cat stalks and attempts to catch a mouse...");
        // Randomly determine if the hunt was successful
        return Math.random() > 0.5;
    }
    
    // Getter methods
    public String getBreed() {
        return breed;
    }
    
    public int getLives() {
        return lives;
    }
}