import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class lotto2 {
    public static void main(String[] args) {
        List<Integer> numerki = new ArrayList<>();
        Random random = new Random();
        while (numerki.size() < 6) {
            int numerek = random.nextInt(49) + 1;
            numerki.add(numerek);
        }
        System.out.println("crazy liczby " + numerki);

    }

}




