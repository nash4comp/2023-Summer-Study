package CITC.chap01;

public class ex05 {
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "ple";
        String str3 = "pale";
        String str4 = "bae";

        System.out.println(checkEdit(str1, str2));
        System.out.println(checkEdit(str1, str3));
        System.out.println(checkEdit(str1, str4));
    }

    public static boolean checkEdit(String str1, String str2) {
        char[] strChr1 = str1.toCharArray();
        char[] strChr2 = str2.toCharArray();

        int[] strInt1 = new int['z' - 'a' + 1];
        int[] strInt2 = new int['z' - 'a' + 1];

        for (char ch : strChr1) {
            strInt1[ch - 'a']++;
        }

        for (char ch : strChr2) {
            strInt2[ch - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < strInt1.length; i++) {
            if (strInt1[i] != strInt2[i]) {
                count++;
            }
        }
        return count <= 1 ? true : false;
    }
}
