package pointmanagement.logichandle;

import pointmanagement.entity.Transcript;
import pointmanagement.entity.TranscriptDetails;
import pointmanagement.file.FileUtil;
import pointmanagement.main.Main;

import java.util.Scanner;

public class GPAService {

    public static void inputGPA() {
        if (!checkData()) {
            System.out.println("Chưa có dữ liệu sinh viên và môn học");
            return;
        }
        System.out.print("Nhập mã sinh viên cần nhập điểm: ");
        int studentID;
        do {
            try {
                studentID = Integer.parseInt(new Scanner(System.in).nextLine());
                if (StudentService.searchStudentByID(studentID) != null) {
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

        TranscriptDetails transcript[] = new TranscriptDetails[n];
        int subjectID;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập mã môn học thứ " + (i + 1) + " : ");
            do {
                try {
                    subjectID = Integer.parseInt(new Scanner(System.in).nextLine());
                    if (SubjectService.searchSubjectByID(subjectID) != null && !checkSameSubject(transcript, subjectID)) {
                        break;
                    } else {
                        System.out.println("Mã môn học không tồn tại hoặc đã bị trùng \n Nhập lại: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Mã môn học phải là số nguyên \n Nhập lại");
                }
            } while (true);
            double score;
            System.out.println("Nhập điểm của môn học thứ " + (i + 1) + " : ");
            do {
                try {
                    score = Double.parseDouble(new Scanner(System.in).nextLine());
                    if (score >= 0 && score <= 10) {
                        break;
                    } else {
                        System.out.println("Thang điểm chỉ từ 0 đến 10 \n Nhập lại: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            } while (true);
            TranscriptDetails trans = new TranscriptDetails();
            trans.setSubject(SubjectService.searchSubjectByID(subjectID));
            trans.setScore(score);
            transcript[i] = trans;
        }
        for (int i = 0; i < Main.GPA.length; i++) {
            if (Main.GPA[i] == null) {
                Transcript t1 = new Transcript(StudentService.searchStudentByID(studentID), transcript);
                Main.GPA[i] = t1;
                break;
            }
        }
        FileUtil.wirteFile(Main.GPA, "gpa.dat");

    }

    public static boolean checkData() {
        boolean checkStudent = false;
        boolean checkSubject = false;
        for (int i = 0; i < StudentService.STUDENT.length; i++) {
            if (StudentService.STUDENT[i] != null) {
                checkStudent = true;
                break;
            }
        }
        for (int i = 0; i < SubjectService.SUBJECT.length; i++) {
            if (SubjectService.SUBJECT[i] != null) {
                checkSubject = true;
                break;
            }
        }
        return checkStudent && checkSubject;
    }

    public static boolean checkScore() {
        for (int i = 0; i < Main.GPA.length; i++) {
            if (Main.GPA[i] != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSameSubject(TranscriptDetails transcript[], int id) {
        for (int i = 0; i < transcript.length; i++) {
            if (transcript[i] != null) {
                if (transcript[i].getSubject().getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void showAllGPA() {
        for (int i = 0; i < Main.GPA.length; i++) {
            if (Main.GPA[i] == null) {
                continue;
            }
            System.out.println(Main.GPA[i]);
        }
    }

    public static void sortGPAByName() {
        for (int i = 0; i < Main.GPA.length - 1; i++) {
            Transcript transcript = Main.GPA[i];
            if (transcript != null) {
                for (int j = i + 1; j < Main.GPA.length; j++) {
                    Transcript transcript1 = Main.GPA[j];
                    if (transcript1 != null) {
                        if (transcript.getStudent().getFullName().compareTo(transcript1.getStudent().getFullName()) > 0) {
                            Transcript temp = transcript;
                            Main.GPA[i] = transcript1;
                            Main.GPA[j] = temp;
                        }
                    }
                }
            }
        }

    }

    public static void calculateGPA() {
        for (int i = 0; i < Main.GPA.length; i++) {
            if (Main.GPA[i] != null) {
                double score = 0;
                int unit = 0;
                for (int j = 0; j < Main.GPA[i].getTranscript().length; j++) {
                    unit += (Main.GPA[i].getTranscript()[j].getSubject().getUnitNumber());
                    score += (Main.GPA[i].getTranscript()[j].getScore() * Main.GPA[i].getTranscript()[j].getSubject().getUnitNumber());

                }
                System.out.println("Sinh viên " + Main.GPA[i].getStudent().getFullName() + " có GPA là: " + ((double) score / unit));
            }
        }
    }

}
