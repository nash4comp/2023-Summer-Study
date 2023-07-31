
// I'm going to solve this problem using Java.
// Before starting the coding process,

// 1. I'll first examine how to approach this algorithm by writing some sentences.
// 2. Then, I'll begin coding and once it is complete, I will perform a simple simulation to validate the results.
// 3. Finally, I will assess the time complexity and space complexity to conclude the process.

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbbbb";
        String str3 = "pwwkew";
        System.out.println(LengthOfLongestSubstring(str1));
        System.out.println(LengthOfLongestSubstring(str2));
        System.out.println(LengthOfLongestSubstring(str3));
    }

    public static int LengthOfLongestSubstringMine(String s) {
        // Initialize the two pointers to make a minimum sliding window.
        // leftPointer starts from index 0.
        // rightPointer starts from index 1.
        int leftPointer = 0;
        int rightPointer = 0;
        String subStr = "";

        // If the rightPointer is less than the length of given String, continue
        // iterating.
        while (rightPointer < s.length()) {
            // Extract the substrings while moving the rightPointer to the right.
            // At this point, compare the newly extracted character with the existing
            // substring to check for duplicates.

            // If a duplicate is found, stop extracting the substring and store the
            // extracted substring separately.
            // When storing this substring, if there is already an existing substring, store
            // the longest substring based on its length.
            // Move the leftPointer to the position of the rightPointer, and move the
            // rightPointer one position to the right.

            // s= "abcabcbb"
            // subStr = ""
            // s.substring(leftPointer, rightPointer) = "a"
            if (subStr.contains(s.charAt(rightPointer) + "")) {
                // Compare the length of substrings between existing and newly extracting one.
                if (subStr.length() < rightPointer - leftPointer) {
                    subStr = s.substring(leftPointer, rightPointer);
                }
                leftPointer = rightPointer;
                rightPointer++;
            } else {
                subStr += s.charAt(rightPointer);
                rightPointer++;
            }
        }
        System.out.println(subStr);
        // Return the length of stored substring.
        return subStr.isEmpty() ? 0 : subStr.length();

    }

    public static int LengthOfLongestSubstring(String s) {
        List<Character> substring = new ArrayList<>();
        int largestLength = 0;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            if (substring.contains(s.charAt(rightPointer))) {
                int index = substring.indexOf(s.charAt(rightPointer));
                substring.remove(index);
                if (index > 0)
                    substring.subList(0, index).clear();
            }
            substring.add(s.charAt(rightPointer));
            largestLength = Math.max(largestLength, substring.size());
        }
        return largestLength;
    }

}
