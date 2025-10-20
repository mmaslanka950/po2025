public class codingbat {
    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    public static void main(String[] args) {
        codingbat obj = new codingbat();
        System.out.println(obj.firstHalf("abcd"));
        System.out.println(obj.firstHalf("kamilkamil"));
        System.out.println(obj.firstHalf("madmax"));

    }
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }

        return false;
    }
}
