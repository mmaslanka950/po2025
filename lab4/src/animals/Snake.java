package animals;

public class Snake extends Animal {
    public Snake() {
        super("Snake", 0);
    }

    public String getDescription() {
        return "To zwierze to: "+name + " oraz ma " + legs + " nog";
    }
}
