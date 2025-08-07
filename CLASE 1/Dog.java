public class Dog implements Animals {
    
    private String breed;
    private int size;

    public Dog (String breed){
        this.breed = breed;
        this.size = 1;
    }

    @Override
    public void eat(){
        System.out.println("He likes to eat large pieces of meat");
    }

    @Override
    public void sleep() {
        System.out.println("He sleeps 12 hours a day, interspersed");
    }
    
    public void makeSound() {
        System.out.println("The Dog says: Guaw!");
    }
    
    @Override
    public void move() {
        System.out.println("The dog walks calmly and sometimes lazily.");
    }
    
    @Override
    public String getSpecies() {
        return "Dog";
    }

    public void wagTail(){

    }

    public void fetch(){
        
    }
}

