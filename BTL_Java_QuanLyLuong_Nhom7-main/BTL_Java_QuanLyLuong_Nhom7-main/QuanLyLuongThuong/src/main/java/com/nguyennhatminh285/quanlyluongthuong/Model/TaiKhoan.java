/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.Model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class TaiKhoan extends BaseModel implements Serializable{
    private long maTaiKhoan;
    private String taiKhoan;
    private String matKhau;
    private int quyen;

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public long getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(long maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }
    
    public TaiKhoan(String taiKhoan, String matKhau, int quyen) {
        this(taiKhoan, matKhau);
        this.quyen = quyen;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public Object[] toObjectArrayData() {
        Object[] answer = new Object[4];
        String[] tenQuyen = {"Quản Trị Viên", "Giảng Viên", "Kế Toán", "Nhân Sự", "Giám Đốc"};
        answer[0] = maTaiKhoan;
        answer[1] = taiKhoan;
        answer[2] = matKhau;
        answer[3] = tenQuyen[quyen];
        return answer;
    }
}
