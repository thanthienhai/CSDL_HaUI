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
public class Example {
    public static class EmployeeManager{
        private Set<String> employeeIds = new HashSet<>();

        public boolean addEmployee(String employeeId) {
            return employeeIds.add(employeeId);
        }

        public boolean removeEmployee(String employeeId) {
            return employeeIds.remove(employeeId);
        }

        public boolean containsEmployee(String employeeId) {
            return employeeIds.contains(employeeId);
        }

        public Set<String> getAllEmployeeIds() {
            return employeeIds;
        }
    }
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Thêm nhân viên mới
        manager.addEmployee("NV001");
        manager.addEmployee("NV002");
        manager.addEmployee("NV003");
        // Kiểm tra xem mã nhân viên "NV002" có tồn tại trong danh sách hay không
        if (manager.containsEmployee("NV002")) {
            System.out.println("Mã nhân viên NV002 tồn tại trong danh sách.");
        } else {
            System.out.println("Mã nhân viên NV002 không tồn tại trong danh sách.");
        }
        // Xóa nhân viên có mã "NV003"
        manager.removeEmployee("NV003");
        // Kiểm tra xem mã nhân viên "NV003" có tồn tại trong danh sách hay không
        if (manager.containsEmployee("NV003")) {
            System.out.println("Mã nhân viên NV003 tồn tại trong danh sách.");
        } else {
            System.out.println("Mã nhân viên NV003 không tồn tại trong danh sách.");
        }
    }
}
