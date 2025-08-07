/**
 * Main class to demonstrate polymorphism and interface usage
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Animal Kingdom! ===\n");
        
        // Creating specific animal objects
        Rabbit myRabbit = new Rabbit("white", 15.5);
        Cat myCat = new Cat("Persian");
        
        // Part 1: Using objects with their specific types
        System.out.println("--- Part 1: Specific Animal Behaviors ---");
        
        System.out.println("Rabbit Actions:");
        myRabbit.eat();
        myRabbit.move();
        myRabbit.wiggleEars(); // Rabbit-specific method
        
        System.out.println("\nCat Actions:");
        myCat.eat();
        myCat.move();
        myCat.purr(); // Cat-specific method
        
        // Part 2: Demonstrating Polymorphism
        System.out.println("\n--- Part 2: Polymorphism Magic! ---");
        
        // Here's the magic: We can treat both as Animals!
        Animals animal1 = myRabbit;  // A Rabbit IS an Animal
        Animals animal2 = myCat;     // A Cat IS an Animal
        
        // We can call interface methods on both
        System.out.println("\nTreating them as generic Animals:");
        makeAnimalDoThings(animal1);
        makeAnimalDoThings(animal2);
        
        // Part 3: Array of different animals
        System.out.println("\n--- Part 3: Animal Array ---");
        
        Animals[] zoo = new Animals[4];
        zoo[0] = new Rabbit("brown", 12.0);
        zoo[1] = new Cat("Siamese");
        zoo[2] = new Rabbit("gray", 14.5);
        zoo[3] = new Cat("Tabby");
        
        System.out.println("Making all animals in the zoo make sounds:");
        for (Animals animal : zoo) {
            System.out.print(animal.getSpecies() + ": ");
            animal.makeSound();
        }
        
        // Part 4: Demonstrating type checking and casting
        System.out.println("\n--- Part 4: Type Checking ---");
        
        for (Animals animal : zoo) {
            System.out.println("\nChecking animal type:");
            
            if (animal instanceof Rabbit) {
                System.out.println("This is a Rabbit!");
                Rabbit rabbit = (Rabbit) animal; // Cast back to Rabbit
                rabbit.dig(); // Now we can use Rabbit-specific methods
            } else if (animal instanceof Cat) {
                System.out.println("This is a Cat!");
                Cat cat = (Cat) animal; // Cast back to Cat
                if (cat.huntMouse()) {
                    System.out.println("The hunt was successful!");
                } else {
                    System.out.println("The mouse got away!");
                }
            }
        }
    }
    
    // Helper method that works with ANY Animal
    public static void makeAnimalDoThings(Animals animal) {
        System.out.println("\n" + animal.getSpecies() + " daily routine:");
        animal.eat();
        animal.move();
        animal.makeSound();
        animal.sleep();
    }
}