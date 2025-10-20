import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class lotto4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> podawaneLiczby = new ArrayList<>();

        System.out.println("podaj liczby od 1 do 49");
        while (podawaneLiczby.size() < 6) {
            int LICZBA = scan.nextInt();
            if (LICZBA < 1 || LICZBA > 49) {
                System.out.println("masz podac numer od 1 do 49.");
            } else if (podawaneLiczby.contains(LICZBA)) {
                System.out.println("ta liczba juz wybrana");
            } else {
                podawaneLiczby.add(LICZBA);
            }
        }
        Collections.sort(podawaneLiczby);

        long startTime = System.currentTimeMillis();

        Random random = new Random();
        long liczbaLosowan = 0;
        List<Integer> numerki = new ArrayList<>();
        int trafienia = 0;

        while (true) {
            liczbaLosowan++;
            numerki.clear();
            while (numerki.size() < 6) {
                int numerek = random.nextInt(49) + 1;
                if (!numerki.contains(numerek)) {
                    numerki.add(numerek);
                }
            }
            Collections.sort(numerki);
            trafienia = 0;
            for (int x : podawaneLiczby) {
                if (numerki.contains(x)) {
                    trafienia++;
                }
            }
            if (trafienia == 6) {
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        double czasSekundy = (endTime - startTime) / 1000.0;

        System.out.println("\ntwoje liczbyy:       " + podawaneLiczby);
        System.out.println("wylosowane liczby:  " + numerki);
        System.out.println("liczba losowan:     " + liczbaLosowan);
        System.out.println("czas:     " + czasSekundy + " s");
    }
}