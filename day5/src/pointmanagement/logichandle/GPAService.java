package pointmanagement.logichandle;

import pointmanagement.entity.GPA;
import pointmanagement.entity.Student;
import pointmanagement.entity.Subject;
import pointmanagement.entity.Transcript;

import java.util.Scanner;

public class GPAService {
    public static void inputGPA() {
        Scanner scanner = new Scanner(System.in);
        if (!checkData()) {
            System.out.println("Chưa có dữ liệu sinh viên và môn học");
            return;
        }
        System.out.print("Nhập mã sinh viên cần nhập điểm: ");

        do {
            try {
                int studentID = Integer.parseInt(new Scanner(System.in).nextLine());
                if (searchStudentByID(studentID) != null) {
                    break;
                } else {
                    System.out.println("Mã sinh viên không tồn tại vui lòng nhập lại");
                }
            } catch (Exception e) {
                System.out.println("Mã sinh viên phải là số có 5 chữ số");
            }

        } while (true);

        System.out.println("Nhập số lượng môn học: ");
        int n;
        do {
            try {
                n = Integer.parseInt(new Scanner(System.in).nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Số lượng môn học tối thiểu là 1");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại: ");
            }
        } while (true);

        Transcript transcript[] = new Transcript[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập môn học thứ " + (i + 1) + ": ");

        }

    }

//    public static boolean checkStudent() {
//        boolean checkStu = false;
//        for (int i = 0; i < Service.STUDENT.length; i++) {
//            if (Service.STUDENT[i] != null) {
//                checkStu = true;
//                break;
//            }
//        }
//        return checkStudent();
//    }
//
//    public static boolean checkSubject() {
//        boolean checkSub = false;
//        for (int i = 0; i < Service.SUBJECT.length; i++) {
//            if (Service.SUBJECT[i] != null) {
//                checkSub = true;
//                break;
//            }
//        }
//        return checkSubject();
//    }

    public static boolean checkData() {
        boolean checkStu = false;
        boolean checkSub = false;
        for (int i = 0; i < Service.STUDENT.length; i++) {
            if (Service.STUDENT[i] != null) {
                checkStu = true;
                break;
            }
        }
        for (int i = 0; i < Service.SUBJECT.length; i++) {
            if (Service.SUBJECT[i] != null) {
                checkSub = true;
                break;
            }
        }
        return checkStu && checkSub;
    }

    public static Student searchStudentByID(int id) {
        for (int i = 0; i < Service.STUDENT.length; i++) {
            if (Service.STUDENT[i] != null) {
                if (Service.STUDENT[i].getId() == id) {
                    return Service.STUDENT[i];
                }
            }
        }
        return null;
    }

    public static Subject searchSubjectByID(int id) {
        for (int i = 0; i < Service.SUBJECT.length; i++) {
            if (Service.SUBJECT[i] != null) {
                if (Service.SUBJECT[i].getId() == id) {
                    return Service.SUBJECT[i];
                }
            }
        }
        return null;
    }

    public static boolean checkSameSubject(Transcript transcript[], String name) {
        for (int i = 0; i < transcript.length; i++) {
            if (transcript[i] != null) {
                if (transcript[i].getSubject().getNameSub() != name) {
                    return false;
                }
            }
        }
        return true;
    }

}
