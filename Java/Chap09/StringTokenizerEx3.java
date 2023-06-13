package Chap09;

import java.util.StringTokenizer;

public class StringTokenizerEx3 {
    public static void main(String[] args) {
        String source = "1.Tom,100,100,100|2.Jenny,98,80,90|3.Eric,80,90,90";
        StringTokenizer st = new StringTokenizer(source, "|");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(token, ",");
            while (st2.hasMoreTokens()) {
                System.out.println(st2.nextToken());
            }
            System.out.println("--------");
        }
    }
}
