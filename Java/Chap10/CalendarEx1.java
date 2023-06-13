package Chap10;

import java.util.*;

public class CalendarEx1 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println("This year: " + today.get(Calendar.YEAR));
        System.out.println("Month(0~11, 0: Jan): " + today.get(Calendar.MONTH));
        System.out.println("Time zone " + today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
    }
}
