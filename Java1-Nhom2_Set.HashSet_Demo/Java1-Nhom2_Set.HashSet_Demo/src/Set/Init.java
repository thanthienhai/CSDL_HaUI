/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Set;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 12_Lab601
 */
public class Init {
    public static void main(String[] args) {
        //Khai báo Set bằng cách sử dụng constructor của một lớp cụ thể
        Set<String> set1 = new HashSet<>();
        set1.add("apple");
        set1.add("banana");
        set1.add("orange");
        System.out.println(""+set1);
        set1.add("ThanNgocThien");
        System.out.println(""+set1);
        //Khai báo Set, Sử dụng phương thức tĩnh of() của lớp Set tạo các giá trị định trước 
        Set<String> set2 = Set.of("apple2", "banana2", "orange2"); // Java 9 trở lên để khởi tạo một Set với các giá trị được chỉ định trước.
        System.out.println(""+set2);
        //set2.add("ThanNgocThien"); //Báo lỗi: không thể thêm được phần tử
        //Khai báo Set, khởi tạo với lớp Collections
        Set<String> set3 = new HashSet<>();
        Collections.addAll(set3, "apple3", "banana3", "orange3");
        System.out.println(""+set3);
        set3.add("ThanThien");
        System.out.println(""+set3);
        Set<String> set4 = Collections.emptySet();
        System.out.println(""+set4);
        //set4.add("ThanGoc"); Không thể thêm phần tử
        Set<Integer> set5 = Collections.singleton(42);
        System.out.println(""+set5);
        //set5.add(26); Không thể thêm phần tử
    }
    
}
