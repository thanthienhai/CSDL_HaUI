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
public class test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
set.add(5);
set.add(3);
set.add(1);
set.add(8);

List<Integer> list = new ArrayList<>(set); // chuyển đổi Set thành List để sắp xếp
Collections.sort(list); // sắp xếp List

set = new HashSet<>(list); // chuyển đổi List thành Set

for (int element : set) {
    System.out.println(element);
}
    }
}
