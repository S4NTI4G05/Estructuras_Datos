/**
 * The Rabbit class implements the Animal interface.
 * This means it MUST provide implementations for ALL methods in Animal.
 */
public class Rabbit implements Animals {
    
    // Attributes specific to rabbits
    private String furColor;
    private double earLength;
    
    // Constructor - this runs when we create a new Rabbit
    public Rabbit(String furColor, double earLength) {
        this.furColor = furColor;
        this.earLength = earLength;
    }
    
    // Implementation of eat() from Animal interface
    @Override
    public void eat() {
        System.out.println("The rabbit nibbles on carrots and lettuce 🥕");
    }
    
    // Implementation of sleep() from Animal interface
    @Override
    public void sleep() {
        System.out.println("The rabbit sleeps in its burrow, ears alert even while resting");
    }
    
    // Implementation of makeSound() from Animal interface
    @Override
    public void makeSound() {
        System.out.println("The rabbit stays quiet (rabbits rarely make sounds)");
    }
    
    // Implementation of move() from Animal interface
    @Override
    public void move() {
        System.out.println("The rabbit hops quickly with powerful hind legs!");
    }
    
    // Implementation of getSpecies() from Animal interface
    @Override
    public String getSpecies() {
        return "Rabbit";
    }
    
    // Methods unique to Rabbit (not from the interface)
    public void dig() {
        System.out.println("The rabbit digs a burrow in the ground");
    }
    
    public void wiggleEars() {
        System.out.println("The rabbit wiggles its " + earLength + " cm long ears");
    }
    
    // Getter methods for attributes
    public String getFurColor() {
        return furColor;
    }
    
    public double getEarLength() {
        return earLength;
    }
}