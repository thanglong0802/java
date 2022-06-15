package entity;

import java.util.Scanner;

public class Driver extends Roster implements inputITF {
    private int id;
    private String fullName;
    private String address;
    private int phoneNumber;
    private Elevel level;

    private static int AUTO_ID = -1;

    public Driver() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập họ tên: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.phoneNumber = checkNumber();
        System.out.println("Nhập trình độ: \n" +
                "1. A \n" +
                "2. B \n" +
                "3. C \n" +
                "4. D \n" +
                "5. E \n" +
                "6. F");
        System.out.print("Chọn: ");
        int choice;
        do {
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            if (choice > 0 && choice < 7) {
                break;
            } else {
                System.out.print("Chỉ chọn từ 1 đến 6, mời nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                this.level = Elevel.A;
                break;
            case 2:
                this.level = Elevel.B;
                break;
            case 3:
                this.level = Elevel.C;
                break;
            case 4:
                this.level = Elevel.D;
                break;
            case 5:
                this.level = Elevel.E;
                break;
            case 6:
                this.level = Elevel.F;
                break;
        }
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", level=" + level +
                '}';
    }

    public int checkNumber() {
        int result = 0;
        try {
            result = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Không thể nhập chữ, xin mời nhập số: ");
            checkNumber();
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Elevel getLevel() {
        return level;
    }

    public void setLevel(Elevel level) {
        this.level = level;
    }

}
