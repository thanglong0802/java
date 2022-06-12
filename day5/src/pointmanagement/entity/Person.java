package pointmanagement.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Person extends TranscriptDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fullName, address, phoneNumber, classes;

    public void inputPersonInfo() {
        System.out.println("Nhập họ tên: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Nhập lớp học: ");
        this.classes = new Scanner(System.in).nextLine();
    }

    public String showPersonInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(", họ tên: ").append(getFullName()).
                append(", địa chỉ: ").append(getAddress()).
                append(", số điện thoại: ").append(getPhoneNumber()).
                append(", lớp học: ").append(getClasses());
        return builder.toString();
    }

    public static int enterNumber() {
        int result = 0;
        try {
            result = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (Exception e) {
            System.out.println("Nhập lại số!");
            enterNumber();
        }
        return result;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
