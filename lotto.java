  
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class lotto {
public static void main(String[] args) {
  
        Set<Integer> numerki = new HashSet<>();
        Random random = new Random();
        while (numerki.size() < 6) {
            int numerek = random.nextInt(49) + 1; 
            numerki.add(numerek);
        }
        System.out.println("crazy liczby " + numerki);
    
}

}
 

