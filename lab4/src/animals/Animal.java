package animals;

public abstract class Animal {
    protected int age;
    public void eat() {
        System.out.println("Animal” + getName()  „is eating");
    }
    public abstract String getName();
}