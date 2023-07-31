package CITC.chap01;

public class ex02 {
    public static void main(String[] args) {
        String str1 = "god";
        String str2 = "dog";
        String str3 = "god ";
        System.out.println(checkPermutation(str1, str2));
        System.out.println(checkPermutation(str1, str3));
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        if (sorting(str1).equals(str2)) {
            return false;
        } else {
            return true;
        }
    }

    public static String sorting(String str) {
        char[] sortedStr = str.toCharArray();
        java.util.Arrays.sort(sortedStr);
        return new String(sortedStr);
    }

}
