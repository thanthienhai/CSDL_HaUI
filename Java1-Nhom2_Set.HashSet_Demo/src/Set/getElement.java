/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author 12_Lab601
 */
public class getElement {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("element 1");
        set1.add("element 2");
        set1.add("element 3");
        set1.add("element 4");
        set1.add("element 5");
        
        //Cach 1 dung phuong thuc iterator()
        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        //Cach 2 dung vong lap for-each
        for (String element : set1) {
            System.out.println(element);
        }
    }
}
