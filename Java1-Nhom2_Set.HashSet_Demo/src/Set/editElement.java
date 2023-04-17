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
public class editElement {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("element 1");
        set1.add("element 2");
        set1.add("element 3");
        set1.add("element 4");
        set1.add("element 5");
        System.out.println(""+set1);
        //Trong Set của Java, các phần tử không thể sửa đổi trực tiếp.
        //Tuy nhiên, ta có thể làm theo cái sau, remove() phần tử cần sửa -> add() phần tử mởi vào
        set1.remove("element 3"); // Xóa phần tử cũ
        set1.add("new element");
        System.out.println(""+set1);
    }
}
