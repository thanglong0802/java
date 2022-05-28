package entity;

import itf.ThongTin;

import java.util.Scanner;

public abstract class Nguoi extends QuanLy implements ThongTin {

    private String tenGV, diaChi, soDienThoai;

    public Nguoi(String tenGV, String diaChi, String soDienThoai) {
        this.tenGV = tenGV;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public Nguoi() {
    }

    @Override
    public void nhapThongTin() {
        System.out.println("Nhập họ tên: ");
        this.setTenGV(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ: ");
        this.setDiaChi(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại: ");
        this.setSoDienThoai(new Scanner(System.in).nextLine());
    }

    @Override
    public String toString() {
        return "Họ tên:" + getTenGV() + ", địa chỉ:" + getDiaChi() + ", số điện thoại:" + getSoDienThoai();
    }

    public String getTenGV() {
        return tenGV;
    }
    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
