package entity;

import itf.ThongTin;

import java.util.Scanner;

public class GiangVienMonHoc implements ThongTin {
    private GiangVien giangVien;
    private MonHoc monHoc;
    private int soLuongLop;

    public GiangVien getGiangVien() {
        return giangVien;
    }
    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
    public MonHoc getMonHoc() {
        return monHoc;
    }
    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
    public int getSoLuongLop() {
        return soLuongLop;
    }
    public void setSoLuongLop(int soLuongLop) {
        this.soLuongLop = soLuongLop;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("Nhập số lượng lớp: ");
        int n;
        do {
            n = Integer.parseInt(new Scanner(System.in).nextLine());
            if (n <= 3) {
                this.soLuongLop = n;
                break;
            } else {
                System.out.println("Số lượng lớp không được vượt quá 3 lớp");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "GiangVienMonHoc{" +
                ", môn học: " + monHoc +
                ", số lượng lớp: " + soLuongLop +
                "}";
    }
}
