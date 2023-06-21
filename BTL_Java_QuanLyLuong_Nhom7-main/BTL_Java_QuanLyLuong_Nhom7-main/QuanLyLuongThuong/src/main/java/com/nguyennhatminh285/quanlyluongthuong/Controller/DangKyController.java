/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.Controller;

import com.nguyennhatminh285.quanlyluongthuong.Model.TaiKhoan;
import com.nguyennhatminh285.quanlyluongthuong.util.KetNoiCSDL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DangKyController {
    private static final String findExistUser = "select count(*) from TAIKHOAN where taikhoan = ?";
    private static final String insertNewUser = "insert into TAIKHOAN(TAIKHOAN, MATKHAU, QUYEN) values(?,?,?)";
    
    public static String onRegisterEvent(TaiKhoan taikhoan) throws SQLException{
        try{
            Connection connection = KetNoiCSDL.getConnection();
            
            //Xử lý tìm tài khoản tồn tại
            PreparedStatement preparedStatement = connection.prepareStatement(findExistUser);
            preparedStatement.setString(1, taikhoan.getTaiKhoan());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();//Chuyển con trỏ về bản ghi đầu
            int countRow = resultSet.getInt(1);
            
            if(countRow > 0){
                throw new Exception("Tài Khoản Đã Tồn Tại");
            }
            
            //Xử lý chèn tài khoản mới vào hệ thống
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertNewUser);
            preparedStatement1.setString(1, taikhoan.getTaiKhoan());
            preparedStatement1.setString(2, taikhoan.getMatKhau());
            preparedStatement1.setInt(3, taikhoan.getQuyen());
            preparedStatement1.executeUpdate();
            
            return "Tạo Tài Khoản Thành Công";
        }catch(Exception ex){
            return ex.toString();
        }
    }
}
