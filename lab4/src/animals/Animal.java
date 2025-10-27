package animals;

public abstract class Animal {
    public String name;
    public int legs;
    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }
    public abstract String getDescription();
}