import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;
public class lotto3 {
    public static void main(String[] args) {
        List<Integer> podawaneliczby = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("prosze podac numer od 1 do 49");
        while (podawaneliczby.size() <6) {
            int LICZBA = scan.nextInt();
            if (LICZBA < 1 || LICZBA > 49) {
                System.out.println("masz podac numer od 1 do 49");
            } else if (podawaneliczby.contains(LICZBA)) {
                System.out.println("ta liczba juz wybrana");
            } else {
                podawaneliczby.add(LICZBA);
            }
        }

        List<Integer> numerki = new ArrayList<>();
        Random random = new Random();
        while (numerki.size() < 6) {
            int numerek = random.nextInt(49) + 1;
            numerki.add(numerek);
        }
        int trafienia = 0;
        for (int LICZBA : podawaneliczby) {
            if (numerki.contains(LICZBA)) {
                trafienia++;
            }
        }
        System.out.println("crazy liczby " + numerki);
        System.out.println("moje typy: " + podawaneliczby);
        System.out.println("liczba trafien: " + trafienia);

    }

}

