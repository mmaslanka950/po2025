package zadania;
import animals.Dog;
import animals.Animal;
import animals.Snake;
import animals.Parrot;
import java.util.Random;

public class Zoo {
    Animal[] animals = new Animal[100];

    public Zoo() {
        wypelnianiezwierzetami();
    }
    void wypelnianiezwierzetami() {
        Random randomowe = new Random();
        for (int i = 0; i < animals.length; i++) {
            int r = randomowe.nextInt(3);
            switch (r) {
                case 0:
                    animals[i] = new Parrot();
                    break;
                case 1:
                    animals[i] = new Dog();
                    break;
                case 2:
                    animals[i] = new Snake();
                    break;
            }
        }
    }
    public int wszystkienogi() {
        int suma = 0;
        for (Animal a : animals) {
            suma += a.legs;
        }
        return suma;
    }

    public static void main(String[] args) {
        Zoo mojeZoo = new Zoo();
        System.out.println(new Snake().getDescription());
        System.out.println(new Parrot().getDescription());
        System.out.println(new Dog().getDescription());

        System.out.println("suma wszystkicb nog tych zwierzat: " + mojeZoo.wszystkienogi());

    }
}




