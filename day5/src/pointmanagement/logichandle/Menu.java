package pointmanagement.logichandle;

import pointmanagement.entity.Person;

public class Menu {
    public static void mainMenu() {
        while (true) {
            System.out.println("1. Sinh viên");
            System.out.println("2. Môn học");
            System.out.println("3. Nhập điểm cho mỗi sinh viên đã có trong danh sách");
            System.out.println("4. Sắp xếp danh sách bảng điểm");
            System.out.println("5. Tính điểm tổng kết dựa trên điểm môn học và số đơn vị học trình");
            System.out.println("0. Kết thúc chương trình");
            System.out.println("=======================================================================");
            System.out.print("Chọn: ");
            int choiceMenu = Person.enterNumber();
            if (choiceMenu == 0) {
                break;
            } else if (choiceMenu == 1) {
                while (true) {
                    System.out.println("1. Nhập danh sách sinh viên");
                    System.out.println("2. Hiển thị danh sách sinh viên");
                    System.out.println("=======================================================================");
                    System.out.print("Chọn: ");
                    int choice = Person.enterNumber();
                    if (choice == 1) {
                        Function.inputStudent();
                        break;
                    } else if (choice == 2) {
                        System.out.println("Danh sách các sinh viên: ");
                        Function.showStudent();
                        break;
                    } else {
                        System.out.println("Nhập lại!");
                    }
                }
            } else if (choiceMenu == 2) {
                while (true) {
                    System.out.println("1. Nhập danh sách môn học");
                    System.out.println("2. Hiển thị danh sách môn học");
                    System.out.println("=======================================================================");
                    System.out.print("Chọn: ");
                    int choice = Person.enterNumber();
                    if (choice == 1) {
                        Function.inputSub();
                        break;
                    } else if (choice == 2) {
                        Function.showSub();
                        break;
                    } else {
                        System.out.println("Nhập lại!");
                    }
                }
            } else if (choiceMenu == 3) {

            } else if (choiceMenu == 4) {

            } else if (choiceMenu == 5) {

            }
        }
        System.out.println("Kết thúc chương trình");
    }
}
