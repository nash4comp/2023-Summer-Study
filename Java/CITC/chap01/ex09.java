package CITC.chap01;

public class ex09 {
    public static void main(String[] args) {

    }

    boolean isRoatation(String s1, String s2) {
        int len = s1.length();
        if(len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1,s2);
        }
        return false;
    }
}
