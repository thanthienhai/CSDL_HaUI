/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.Controller;

import com.nguyennhatminh285.quanlyluongthuong.Model.NhanVien;
import com.nguyennhatminh285.quanlyluongthuong.util.KetNoiCSDL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class QuanLyThongTinCaNhanController {
    private static final String ON_QUERY_USER_INFO = "select TENNHANVIEN, GIOITINH, NGAYSINH, DIACHI, CHUCVU, TRINHDO from NHANVIEN inner join TAIKHOAN on NHANVIEN.MATAIKHOAN = TAIKHOAN.MATAIKHOAN where TAIKHOAN.MATAIKHOAN = ?;";
    
    public NhanVien onQueryUserInfo(long id) throws SQLException{
        Connection connection = null;
        try {
            connection = KetNoiCSDL.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(ON_QUERY_USER_INFO);
            preparedStatement.setLong(1, id);
            System.out.println("id in:" + id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTenNhanVien(resultSet.getString(1));
            nhanVien.setGioiTinh(resultSet.getInt(2));
            nhanVien.setNgaySinh(new Date(resultSet.getDate(3).getTime()));
            nhanVien.setDiaChi(resultSet.getString(4));
            nhanVien.setChucVu(resultSet.getString(5));
            nhanVien.setTrinhDo(resultSet.getString(6));
            System.out.println("Nhan Vien: " + nhanVien);
            return nhanVien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        finally{
            if(connection != null){
                connection.close();
            }
        }
    }
}
