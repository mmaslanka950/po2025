import java.util.Scanner;
public class hallo {
public static void main(String[] args) {
  Scanner odczyt = new Scanner(System.in);
  System.out.println("podaj wartosc");
  int x = odczyt.nextInt();
 
 for(int i=0; i<x; i++){
  
  for(int j=0;j<i; j++ )
  {
    System.out.print("*");
  }
  System.out.println("");
 }
}
}