package animals;

public class Parrot extends Animal {
    public Parrot() {
        super("Parrot", 2);
    }


    public String getDescription() {
        return "To zwierze to "+ name + " oraz ma " + legs + " nog.";
    }
}