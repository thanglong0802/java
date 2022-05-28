package entity;

import java.util.Scanner;

public class MonHoc extends Nguoi {
    private int id, tongSoTiet, soTietLyThuyet;
    private String tenMonHoc;
    private double kinhPhi;

    private static int AUTO_ID = -1;

    public MonHoc() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("Mã môn học: " + this.getId());
        System.out.println("Nhập tên môn học: ");
        this.setTenMonHoc(new Scanner(System.in).nextLine());

        System.out.println("Nhập tổng số tiết: ");
        int n;
        do {
            n = Integer.parseInt(new Scanner(System.in).nextLine());
            if (n > 0 && n <= 200) {
                this.tongSoTiet = n;
                break;
            } else {
                System.out.println("Tổng số tiết phải lớn hơn 0 và không vượt quá 200");
            }
        } while (true);

        System.out.println("Nhập số tiết lý thuyết: ");
        int m;
        do {
            m = Integer.parseInt(new Scanner(System.in).nextLine());
            if (m > 0) {
                this.soTietLyThuyet = m;
                break;
            } else {
                System.out.println("Tổng số tiết lý thuyết phải lớn hơn 0");
            }
        } while (true);

        System.out.println("Nhập mức phí: ");
        int k;
        do {
            k = Integer.parseInt(new Scanner(System.in).nextLine());
            if (k > 0) {
                this.kinhPhi = k;
                break;
            } else {
                System.out.println("Học không phiễn phí, mời nhập mức phí!");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Mã môn học: " + getId() +
                ", tên môn học: " + getTenMonHoc() +
                ", tổng số tiết: " + getTongSoTiet() +
                ", tổng số tiết lý thuyết: " + getSoTietLyThuyet() +
                ", kinh phí: " + getKinhPhi();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTenMonHoc() {
        return tenMonHoc;
    }
    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
    public int getTongSoTiet() {
        return tongSoTiet;
    }
    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }
    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }
    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }
    public double getKinhPhi() {
        return kinhPhi;
    }
    public void setKinhPhi(double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }
}
