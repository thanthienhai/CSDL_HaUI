/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 12_Lab601
 */
public class minMaxSort {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(1);
        set.add(3);
        set.add(26);
        set.add(3);
        set.add(2003);
        set.add(53);
        set.add(112);
        int minElement = Collections.min(set); // tìm phần tử nhỏ nhất
        int maxElement = Collections.max(set); // tìm phần tử lớn nhất
        System.out.println("Min: " + minElement);
        System.out.println("Max: " + maxElement);
        //Vì Set không đảm bảo thứ tự của các element nên ta sẽ đưa Set về List để sắp xếp, sau đó đưa ngược lại Set
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(3);
        set1.add(1);
        set1.add(8);

        List<Integer> list = new ArrayList<>(set1); // chuyển đổi Set thành List để sắp xếp
        Collections.sort(list); // sắp xếp List

        set1 = new HashSet<>(list); // chuyển đổi List thành Set

        for (int element : set1) {
            System.out.println(element);
        }
    }
}
