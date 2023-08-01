package Java.CITC.chap01;

public class Ex04 {
    public static void main(String[] args) {
        String str = "Tact coa";
        System.out.println(isPalindromePermutation(str));
    }

    public static boolean isPalindromePermutation(String str) {
        str.toLowerCase();
        str.trim();
        int length = str.length();
        int[] strChr = new int[26];

        for(int i =0; i<length;i++) {
            strChr[str.charAt(i) - 'A']++;
        }

        for (int num : strChr) {
            if(num % 2 != 0) return false;
        }
        return true;
    } else {
        
    }
    }}
