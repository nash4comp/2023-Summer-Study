package Chap02;

public class ConstantPoolTest {
    public static void main(String[] args) {
        String str1 = "AAA";
        String str2 = "AAA";
        String str3 = "AAA";
        String str4 = "BBB";
        String str5 = new String("AAA");
        String str6 = new String("CCC");
        String str7 = new String("DDD");

        System.out.println("str1 addr: " + str1.hashCode());
        System.out.println("str2 addr: " + str2.hashCode());
        System.out.println("str3 addr: " + str3.hashCode());
        System.out.println("str4 addr: " + str4.hashCode());
        System.out.println("str5 addr: " + str5.hashCode());
        System.out.println("str6 addr: " + str6.hashCode());
        System.out.println("str7 addr: " + str7.hashCode());

    }
    
}
