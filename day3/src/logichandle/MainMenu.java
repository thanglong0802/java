package logichandle;

import java.util.Scanner;

public class MainMenu {

    public static int menu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Nhập danh sách giảng viên");
        System.out.println("2. Hiển thị danh sách giảng viên");
        System.out.println("3. Nhập danh sách môn học");
        System.out.println("4. Hiển thị danh sách môn học");
        System.out.println("5. Lập bảng kê khai giảng dạy cho mỗi giảng viên");
        System.out.println("6. Hiển thị danh sách kê khai");
        System.out.println("7. Sắp xếp danh sách kê khai giảng dạy");
        System.out.println("8. Tính toán và lập bảng tính tiền công cho mỗi giảng viên");
        System.out.println("0. Thoát chương trình");
        System.out.println("==================================================");
        System.out.print("Chọn: ");
        int choiceMenu = -1;
        do {
            choiceMenu = Integer.parseInt(new Scanner(System.in).nextLine());
            if (choiceMenu >= 1 && choiceMenu <= 5) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, nhập lại: ");
        } while (choiceMenu > 5 || choiceMenu < 1);
        return choiceMenu;
    }

}
