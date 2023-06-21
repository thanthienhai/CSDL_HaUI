/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Set;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 12_Lab601
 */
public class deleteElement {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("element 1");
        set1.add("element 2");
        set1.add("element 3");
        set1.add("element 4");
        set1.add("element 5");
        //Xóa phần tử được chỉ định
        set1.remove("element 4");
        System.out.println(""+set1);
        //Xóa toàn bộ phần tử trong Set
        Set<String> set2 = new HashSet<>();
        set2.add("element 2");
        set2.add("element 4");
        set1.removeAll(set2); // xóa tất cả các phần tử trong set1 mà cũng có trong set2
        System.out.println(""+set1);
    }
}
