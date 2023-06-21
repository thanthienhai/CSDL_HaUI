/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.Model;

/**
 *
 * @author Admin
 */
public class Thuong extends BaseModel{
    private long maThuong;
    private String tenThuong;
    private float tienThuong;

    public Thuong() {
    }

    public Thuong(String tenThuong, float tienThuong) {
        this.tenThuong = tenThuong;
        this.tienThuong = tienThuong;
    }

    public Thuong(long maThuong, String tenThuong, float tienThuong) {
        this.maThuong = maThuong;
        this.tenThuong = tenThuong;
        this.tienThuong = tienThuong;
    }

    public long getMaThuong() {
        return maThuong;
    }

    public void setMaThuong(long maThuong) {
        this.maThuong = maThuong;
    }
    
    
    public String getTenThuong() {
        return tenThuong;
    }

    public void setTenThuong(String tenThuong) {
        this.tenThuong = tenThuong;
    }

    public float getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(float tienThuong) {
        this.tienThuong = tienThuong;
    }

    @Override
    public Object[] toObjectArrayData() {
        Object[] objects = new Object[3];
        objects[0] = maThuong;
        objects[1] = tenThuong;
        objects[2] = tienThuong;
        return objects;
    }
}
