package Chap11;

import java.util.*;

public class TreeSetLotto {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }
        System.out.println(set);
        System.out.println(set.first());
        System.out.println(set.last());
    }
}
