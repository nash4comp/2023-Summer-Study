package CITC.chap01;

public class ex03 {
    public static void main(String[] args) {
        String str = "Mr John Smith       ";
        int length = 13;
        System.out.println(URLify(str, length));
    }

    public static String URLify(String str, int length) {
        return str.substring(0, length).replace(" ", "%20");
    }
}
