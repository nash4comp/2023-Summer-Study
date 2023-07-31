package Practice;

public class Test {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "abcded";
        System.out.println(check(str1));
        System.out.println(check(str2));

    }

    public static boolean check(String str) {
        if (str.length() > 256)
            return false;

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
