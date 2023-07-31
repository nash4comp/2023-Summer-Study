package CITC.chap01;

public class ex06 {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compress(str));
    }

    public static String compress(String str) {
        int counter = 0;
        int pointer = 0;
        String temp = "";
        char ch = str.charAt(pointer);
        pointer++;

        while (pointer < str.length()) {
            if (ch == str.charAt(pointer)) {
                ch = str.charAt(pointer);
                counter++;
                pointer++;
            } else {
                temp += "" + ch + counter;
                counter = 0;
                pointer++;
            }
        }
        System.out.println(str);
        System.out.println(temp);
        return temp.length() >= str.length() ? str : temp;
    }
}
