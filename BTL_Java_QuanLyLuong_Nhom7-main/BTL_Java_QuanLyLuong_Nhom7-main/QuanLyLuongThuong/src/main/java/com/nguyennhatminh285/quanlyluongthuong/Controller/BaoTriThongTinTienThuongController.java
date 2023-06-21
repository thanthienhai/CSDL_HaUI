/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.Controller;

import com.nguyennhatminh285.quanlyluongthuong.Model.Thuong;
import com.nguyennhatminh285.quanlyluongthuong.util.IUpdateTableEvent;
import com.nguyennhatminh285.quanlyluongthuong.util.KetNoiCSDL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BaoTriThongTinTienThuongController {
    private static final String QUERY_ALL_TIENTHUONG = "select * from THUONG";
    private static final String INSERT_NEW_TIENTHUONG = "insert into THUONG(TENTHUONG, TIENTHUONG) values(?,?)";
    private static final String UPDATE_TIENTHUONG = "update THUONG set TENTHUONG = ?, TIENTHUONG = ? where MATHUONG = ?";
    private static final String DELETE_TIENTHUONG = "delete from THUONG where MATHUONG = ?";
    private IUpdateTableEvent iUpdateTableEvent;
    
    public void setUpdateTableEvent(IUpdateTableEvent iUpdateTableEvent) {
        this.iUpdateTableEvent = iUpdateTableEvent;
    }
    
    public ArrayList<Thuong> onQueryAllTienThuong() throws SQLException{
        Connection connection = null;
        try {
            connection = KetNoiCSDL.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_TIENTHUONG);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<Thuong> answer= new ArrayList<>();
            
            while(resultSet.next()){
               Thuong thuong = new Thuong();
               thuong.setMaThuong(resultSet.getLong(1));
               thuong.setTenThuong(resultSet.getString(2));
               thuong.setTienThuong(resultSet.getFloat(3));
               answer.add(thuong);
            }
            return answer;
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
    
    public void addNewTienThuong(Thuong thuong) throws SQLException{
        Connection connection = null;
        try {
            connection = KetNoiCSDL.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_TIENTHUONG);
            preparedStatement.setString(1, thuong.getTenThuong());
            preparedStatement.setFloat(2, thuong.getTienThuong());
            preparedStatement.executeUpdate();
            
            iUpdateTableEvent.onUpdateDataOnTableEvent();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public void updateTienThuongByID(Thuong thuong) throws SQLException{
        Connection connection = null;
        try {
            connection = KetNoiCSDL.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TIENTHUONG);
            preparedStatement.setString(1, thuong.getTenThuong());
            preparedStatement.setFloat(2, thuong.getTienThuong());
            preparedStatement.setLong(3, thuong.getMaThuong());
            preparedStatement.executeUpdate();
            
            iUpdateTableEvent.onUpdateDataOnTableEvent();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
            if(connection != null){
                connection.close();
            }
        }
    }
    
    public void deleteTienThuongByID(long ID) throws SQLException{
        Connection connection = null;
        try {
            connection = KetNoiCSDL.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TIENTHUONG);
            preparedStatement.setLong(1, ID);
            preparedStatement.executeUpdate();
            
            iUpdateTableEvent.onUpdateDataOnTableEvent();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
            if(connection != null){
                connection.close();
            }
        }
    }
}
