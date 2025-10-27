package animals;

public class Dog extends Animal {
    public Dog() {
        super("Dog", 4);
    }

    public String getDescription() {
        return "To zwierze to: "+ name + " oraz ma " + legs + " nog.";
    }
}