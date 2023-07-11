
/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
and removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.

*/


public class Valid_Palindrome {
    public static void main(String[] args) {

        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = " ";

        System.out.println(isPalindromeMy(str1));
        System.out.println(isPalindromeMy(str2));
        System.out.println(isPalindromeMy(str3));

    }

    public static boolean isPalindromeMy(String s) {

        // 1. remove all the non-alphanumeric characters.
        // 1.1. alphanumeric characters: a-z, A-Z, 0-9
        // delete non-alphanumeric characters in String
        String filteredStr = "";

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (('a' <= temp && temp <= 'z') || ('A' <= temp && temp <= 'Z') || ('0' <= temp && temp <= '9')) {
                filteredStr += temp;
            }
        }

        // 2. convert all the letters into lowercase letters by using toLowercase method

        String loweredStr = filteredStr.toLowerCase();

        // 3. determine whether the string is palindrome or not.
        // by reversing the original string and comparing between them.

        String reversedStr = "";

        for (int i = 0; i < loweredStr.length(); i++) {
            reversedStr += loweredStr.charAt(loweredStr.length() - 1 - i);
        }

        return loweredStr.equals(reversedStr);

    }

    public static boolean isPalindromeSolution(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            Character start = s.charAt(i);
            Character end = s.charAt(i);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            i++;
            j++;
        }
        return true;
    }

}
