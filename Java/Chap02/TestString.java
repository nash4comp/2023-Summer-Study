package Chap02;

class TestString {
	public static void main(String[] args)
    {
        char[] ch = {'0', '1', '2', '3', '4', '5', '6'};
        String str = new String(ch, 2, 3);
        System.out.println(str);
    }
}