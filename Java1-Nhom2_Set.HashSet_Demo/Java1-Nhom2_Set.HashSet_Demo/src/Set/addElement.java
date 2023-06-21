/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 12_Lab601
 */
public class addElement {
    public static void main(String[] args) {
        //Khai báo Set
        Set<String> set1 = new HashSet<>();
        //Thêm phần tử vào phần 1 bằng add()
        set1.add("element 1");
        set1.add("element 2");
        set1.add("element 3");
        System.out.println(""+set1);
        //Thêm phần tử vào lần 2 bằng Collections
        Collections.addAll(set1, "apple", "banana", "orange");
        System.out.println(""+set1);
    }
}
