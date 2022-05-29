package main;

import logichandle.ChucNang;
import logichandle.MainMenu;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int menu = MainMenu.menu();
            switch (menu) {
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                case 1:
                    ChucNang.nhapGiangVien();
                    break;
                case 2:
                    ChucNang.inGiangVien(ChucNang.GIANG_VIEN);
                    break;
                case 3:
                    ChucNang.nhapMonHoc();
                    break;
                case 4:
                    ChucNang.inMonHoc(ChucNang.MON_HOC);
                    break;
                case 5:
                    ChucNang.kiemTraGVMH();
                    break;
                case 6:
                    ChucNang.showTeaching(ChucNang.GIANG_VIEN_MON_HOC);
                    break;
                case 7:
                    ChucNang.showSortTeaching();
                    break;
                case 8:
                    ChucNang.showSalary();
                    break;
            }
        }
    }
}
