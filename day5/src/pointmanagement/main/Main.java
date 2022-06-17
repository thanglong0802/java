package pointmanagement.main;

import pointmanagement.entity.Transcript;
import pointmanagement.entity.Person;
import pointmanagement.logichandle.GPAService;
import pointmanagement.logichandle.StudentService;
import pointmanagement.logichandle.SubjectService;

public class Main {
    public static Transcript[] GPA = new Transcript[50];

    public static void main(String[] args) {
        while (true) {
            System.out.println("=====Quản lý điểm sinh viên=====");
            System.out.println("1. Sinh viên");
            System.out.println("2. Môn học");
            System.out.println("3. Nhập và xuất điểm cho mỗi sinh viên đã có trong danh sách");
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
                    int choice1 = Person.enterNumber();
                    if (choice1 == 1) {
                        StudentService.inputStudent();
                        break;
                    } else if (choice1 == 2) {
                        System.out.println("Danh sách các sinh viên: ");
                        StudentService.showStudent();
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
                    int choice2 = Person.enterNumber();
                    if (choice2 == 1) {
                        SubjectService.inputSubject();
                        break;
                    } else if (choice2 == 2) {
                        SubjectService.showSubject();
                        break;
                    } else {
                        System.out.println("Nhập lại!");
                    }
                }
            } else if (choiceMenu == 3) {
                while (true) {
                    GPAService.inputGPA();
                    GPAService.showAllGPA();
                    break;
                }
            } else if (choiceMenu == 4) {
                while (true) {
                    System.out.println("1. Theo họ tên sinh viên");
                    System.out.println("2. Theo tên môn học");
                    System.out.println("=======================================================================");
                    System.out.print("Chọn: ");
                    int choice3 = Person.enterNumber();
                    if (choice3 == 1) {
                        GPAService.sortGPAByName();
                        GPAService.showAllGPA();
                        break;
                    } else if (choice3 == 2) {
                        break;
                    } else {
                        System.out.println("Nhập lại!");
                    }
                }
            } else if (choiceMenu == 5) {
                while (true) {
                    GPAService.calculateGPA();
                    break;
                }
            }
        }
        System.out.println("Kết thúc chương trình");
    }

}
