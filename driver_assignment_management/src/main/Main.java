package main;

import entity.Roster;
import logichandle.DriverService;
import logichandle.RouterService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Roster> ROSTER = new ArrayList<>();

    public static void main(String[] args) {
        boolean check = true;
        while (check) {
            menu();
            int choiceMenu = Roster.nhapInt();
            switch (choiceMenu) {
                case 0:
                    System.out.println("Kết thúc chương trình");
                    check = false;
                    break;
                case 1:
                    DriverService.inputNewDriver();
                    break;
                case 2:
                    DriverService.showDriver();
                    break;
                case 3:
                    RouterService.inputNewRouter();
                    break;
                case 4:
                    RouterService.showRouter();
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    System.out.println("Không có chức năng mà bạn vừa nhập, mời nhập lại");
            }
        }
    }

    public static void menu() {
        System.out.println("===== QUẢN LÝ PHÂN CÔNG LÁI XE BUÝT =====");
        System.out.println("1. Thêm lái xe mới");
        System.out.println("2. Hiển thị danh sách lái xe");
        System.out.println("3. Thêm tuyến mới");
        System.out.println("4. Hiển thị danh sách tuyến");
        System.out.println("5. Thêm danh sách phân công cho mỗi lái xe");
        System.out.println("6. Hiển thị danh sách phân công lái xe");
        System.out.println("7. Sắp xếp danh sách phân công");
        System.out.println("8. Lập bảng kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
        System.out.println("0. Thoát chương trình");
        System.out.println("===============================================================================");
        System.out.print("Chọn chức năng: ");
    }
}
