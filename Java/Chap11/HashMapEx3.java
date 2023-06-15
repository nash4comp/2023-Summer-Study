package Chap11;

import java.util.*;

public class HashMapEx3 {
    static HashMap phoneBook = new HashMap();

    static void addPhoneNo(String name, String tel) {
        addPhoneNo("etc", name, tel);
    }

    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap group = (HashMap) phoneBook.get(groupName);
        group.put(tel, name);

    }

    static void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName, new HashMap());
        }
    }

    static void printList() {
        Set set = phoneBook.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();

            Set subSet = ((HashMap) e.getValue()).entrySet();
            Iterator subIt = subSet.iterator();

            System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");

            while (subIt.hasNext()) {
                Map.Entry subE = (Map.Entry) subIt.next();
                String telNo = (String) subE.getKey();
                String name = (String) subE.getValue();
                System.out.println(name + " " + telNo);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        addPhoneNo("Friend", "Jane", "778-111-1111");
        addPhoneNo("Friend", "Tom", "778-222-2222");
        addPhoneNo("Friend", "Jeff", "778-333-3333");
        addPhoneNo("Company", "Michael", "778-444-4444");
        addPhoneNo("Company", "Albert", "778-555-5555");
        addPhoneNo("Company", "Jason", "778-666-6666");
        addPhoneNo("Company", "Brenda", "778-777-7777");
        addPhoneNo("Family", "Ife", "778-888-8888");
        addPhoneNo("Family", "Yue", "778-999-9999");
        printList();
    }

}
