package pointmanagement.logichandle;

import pointmanagement.entity.Subject;
import pointmanagement.file.FileUtil;

import java.util.Scanner;

public class SubjectService {
    public static Subject SUBJECT[] = new Subject[20];

    public static void inputSubject() {
        System.out.println("Nhập số lượng môn học mới: ");
        int newSubject = -1;
        do {
            newSubject = Integer.parseInt(new Scanner(System.in).nextLine());
            if (newSubject > 0) {
                break;
            } else {
                System.out.println("Phải nhập ít nhất 1 môn học");
            }
        } while (true);
        for (int i = 0; i < newSubject; i++) {
            System.out.println("Nhập môn học thứ " + (i + 1) + " :");
            Subject subject = new Subject();
            subject.inputSubInfo();
            saveSubject(subject);
            FileUtil.wirteFile(SUBJECT, "subject.dat");
        }
        System.out.println("Nhập thành công");
    }

    public static void showSubject() {
        for (int i = 0; i < SUBJECT.length; i++) {
            if (SUBJECT[i] == null) {
                continue;
            }
            System.out.println(SUBJECT[i]);
        }
    }

    public static void saveSubject(Subject subject) {
        for (int i = 0; i < SUBJECT.length; i++) {
            if (SUBJECT[i] == null) {
                SUBJECT[i] = subject;
                break;
            }
        }
    }

    public static Subject searchSubjectByID(int id) {
        for (int i = 0; i < SubjectService.SUBJECT.length; i++) {
            if (SubjectService.SUBJECT[i] != null) {
                if (SubjectService.SUBJECT[i].getId() == id) {
                    return SubjectService.SUBJECT[i];
                }
            }
        }
        return null;
    }
}
