public class CharacterReplacement {
    public static void main(String[] args) {
        String str1 = "ABAB";
        String str2 = "AABABBA";
        System.out.println(characterReplacement(str1, 2));
        System.out.println(characterReplacement(str2, 1));
    }

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[26];    // counts how many upper case alphabet in a given string
        int ans = 0;
        int max = 0;    // the number of the most frequently occurred alphabet in current window
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
