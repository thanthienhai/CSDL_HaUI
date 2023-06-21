/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.Model;

/**
 *
 * @author Admin
 */
public class HeSoLuong extends BaseModel{
    private long maHeSoLuong;
    private String tenHeSoLuong;
    private float heSoLuong;

    public HeSoLuong() {
    }

    public HeSoLuong(String tenHeSoLuong, float heSoLuong) {
        this.tenHeSoLuong = tenHeSoLuong;
        this.heSoLuong = heSoLuong;
    }
    
    
    public HeSoLuong(long maHeSoLuong, String tenHeSoLuong, float heSoLuong) {
        this.maHeSoLuong = maHeSoLuong;
        this.tenHeSoLuong = tenHeSoLuong;
        this.heSoLuong = heSoLuong;
    }

    public long getMaHeSoLuong() {
        return maHeSoLuong;
    }
    
    
    public String getTenHeSoLuong() {
        return tenHeSoLuong;
    }

    public void setTenHeSoLuong(String tenHeSoLuong) {
        this.tenHeSoLuong = tenHeSoLuong;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }


    @Override
    public Object[] toObjectArrayData() {
        Object[] answer = new Object[3];
        answer[0] = maHeSoLuong;
        answer[1] = tenHeSoLuong;
        answer[2] = heSoLuong;
        return answer;
    }

    @Override
    public String toString() {
        return String.valueOf(heSoLuong);
    }
}
