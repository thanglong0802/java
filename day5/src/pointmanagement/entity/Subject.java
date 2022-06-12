package pointmanagement.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id, unitNumber;
    private String nameSub, typeSub;

    private static int AUTO_ID = -1;

    private static final String DAI_CUONG = "Đại cương";
    private static final String CO_SO_NGANH = "Cơ sở ngành";
    private static final String CHUYEN_NGANH = "Chuyên ngành";

    public Subject() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    public void inputSubInfo() {
        System.out.println("Nhập tên môn học: ");
        this.nameSub = new Scanner(System.in).nextLine();
        System.out.println("Nhập số đơn vị học trình: ");
        this.unitNumber = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Nhập loại môn học: ");
        while (true) {
            System.out.println("1. Đại cương");
            System.out.println("2. Cơ sở ngành");
            System.out.println("3. Chuyên ngành");
            int choice = Person.enterNumber();
            if (choice == 1) {
                this.typeSub = DAI_CUONG;
                break;
            } else if (choice == 2) {
                this.typeSub = CO_SO_NGANH;
                break;
            } else if (choice == 3) {
                this.typeSub = CHUYEN_NGANH;
                break;
            } else {
                System.out.println("Không vượt quá 3 loại môn học");
            }
        }
    }

    public String showSubInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mã môn học: ").append(getId()).
                append(", tên môn học: ").append(getNameSub()).
                append(", số đơn vị học trình: ").append(getUnitNumber()).
                append(", loại môn học: ").append(getTypeSub());
        return builder.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getTypeSub() {
        return typeSub;
    }

    public void setTypeSub(String typeSub) {
        this.typeSub = typeSub;
    }
}
