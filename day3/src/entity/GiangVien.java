package entity;

import java.util.Scanner;

public class GiangVien extends Nguoi {

    public static final String GS = "GS-TS";
    public static final String PGS = "PGS-TS";
    public static final String GVC = "Giảng viên chính";
    public static final String TS = "Thạc sỹ";

    private static int AUTO_ID = -1;

    private int id;
    private String trinhDo;

    public GiangVien() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTrinhDo() {
        return trinhDo;
    }
    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

//    public String showPerson() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Mã giảng viên: ").append(getId()).
//                append(", họ tên: ").append(getTenGV()).
//                append(", địa chỉ: ").append(getDiaChi()).
//                append(", số điện thoại: ").append(getSoDienThoai()).
//                append(", trình độ: ").append(getTrinhDo());
//        System.out.println(builder);
//        return builder.toString();
//    }

    @Override
    public void nhapThongTin() {
        System.out.println("Mã giảng viên: " + this.getId());
        super.nhapThongTin();
        System.out.println("Nhập trình độ: ");
        int choice = 0;
        while (true) {
            System.out.println("1. GS-TS");
            System.out.println("2. PGS-TS");
            System.out.println("3. Giảng viên chính");
            System.out.println("4. Thạc sỹ");
            System.out.println("===============================");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            if (choice == 1) {
                this.trinhDo = GS;
                break;
            } else if (choice == 2) {
                this.trinhDo = PGS;
                break;
            } else if (choice == 3) {
                this.trinhDo = GVC;
                break;
            } else if (choice == 4) {
                this.trinhDo = TS;
                break;
            } else {
                System.out.println("Nhập lại!");
            }
        }
    }

    @Override
    public String toString() {
        return "Mã giảng viên: " + getId() +
                " " + super.toString() +
                ", trình độ:" + getTrinhDo();
    }
}
