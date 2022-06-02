package pointmanagement.logichandle;

import pointmanagement.entity.Person;
import pointmanagement.entity.Student;
import pointmanagement.entity.Subject;

public class Function {
    public static Person STUDENT[] = new Student[20];
    public static Subject SUBJECT[] = new Subject[20];
    public static int INDEX = 0;

    public static int indexStu = 0;
    public static int indexSub = 0;
    // nhập sinh viên
    public static void inputStudent() {
        Person student = new Student();
        student.inputPersonInfo();
        STUDENT[indexStu++] = student;
        System.out.println("Nhập thành công");
    }
    // hiển thị sinh viên
    public static void showStudent() {
        for (int i = 0; i < indexStu; i++) {
            System.out.println(STUDENT[i].showPersonInfo());
        }
    }
    // nhập môn học
    public static void inputSub() {
        Subject subject = new Subject();
        subject.inputSubInfo();
        SUBJECT[indexSub++] = subject;
        System.out.println("Nhập thành công");
    }
    // hiển thị môn học
    public static void showSub() {
        for (int i = 0; i < indexSub; i++) {
            System.out.println(SUBJECT[i].showSubInfo());
        }
    }
}
