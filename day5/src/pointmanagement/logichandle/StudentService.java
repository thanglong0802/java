package pointmanagement.logichandle;

import pointmanagement.entity.Student;
import pointmanagement.file.FileUtil;

import java.util.Scanner;

public class StudentService {
    public static Student STUDENT[] = new Student[20];

    public static void inputStudent() {
        System.out.println("Nhập số lượng sinh viên mới: ");
        int newStudent = -1;
        do {
            newStudent = Integer.parseInt(new Scanner(System.in).nextLine());
            if (newStudent > 0) {
                break;
            } else {
                System.out.println("Phải nhập ít nhất 1 sinh viên");
            }
        } while (true);
        for (int i = 0; i < newStudent; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + " :");
            Student student = new Student();
            student.inputPersonInfo();
            saveStudent(student);
            FileUtil.wirteFile(STUDENT, "student.dat");
        }
        System.out.println("Nhập thành công");
    }

    public static void showStudent() {
        for (int i = 0; i < STUDENT.length; i++) {
            if (STUDENT[i] == null) {
                continue;
            }
            System.out.println(STUDENT[i]);
        }
    }

    public static void saveStudent(Student student) {
        for (int i = 0; i < STUDENT.length; i++) {
            if (STUDENT[i] == null) {
                STUDENT[i] = student;
                break;
            }
        }
    }

    public static Student searchStudentByID(int id) {
        for (int i = 0; i < StudentService.STUDENT.length; i++) {
            if (StudentService.STUDENT[i] != null) {
                if (StudentService.STUDENT[i].getId() == id) {
                    return StudentService.STUDENT[i];
                }
            }
        }
        return null;
    }
}
