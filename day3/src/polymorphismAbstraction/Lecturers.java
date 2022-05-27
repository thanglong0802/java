package polymorphismAbstraction;

import java.util.Scanner;

public class Lecturers {
    private int iD;
    private String name, address, phoneNumber, level;

    private static int MAGIANGVIEN;
    private final static String GS = "GS-TS";
    private final static String PGS = "PGS-TS";
    private final static String GVC = "Giảng viên chính";
    private final static String TS = "Thạc sỹ";

    Lecturers(int iD) {
        if (MAGIANGVIEN == -1) {
            MAGIANGVIEN = 100;
            this.iD = MAGIANGVIEN;
            return;
        }
        this.iD = ++MAGIANGVIEN;
    }

    public void nhap(Scanner scanner) {
        System.out.println("Nhập họ tên: ");
        this.name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.address = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.phoneNumber = scanner.nextLine();
        System.out.println("Nhập trình độ: ");
        int choice = 0;
        while (true) {
            System.out.println("1. GS-TS");
            System.out.println("2. PGS-TS");
            System.out.println("3. Giảng viên chính");
            System.out.println("4. Thạc sỹ");
            System.out.println("===============================");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                this.level = GS;
                break;
            } else if (choice == 2) {
                this.level = PGS;
                break;
            } else if (choice == 3) {
                this.level = GVC;
                break;
            } else if (choice == 4) {
                this.level = TS;
                break;
            } else {
                System.out.println("Nhập lại!");
            }
        }
    }

    public int getiD() {
        return iD;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getLevel() {
        return level;
    }
    public void setiD(int iD) {
        this.iD = iD;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setLevel(String level) {
        this.level = level;
    }
}
