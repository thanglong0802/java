package pointmanagement.entity;

import java.util.Scanner;

public class Transcript {
    private Student student;
    private Subject subject[];
    private double testScore;

    public void inputTranscript() {
        System.out.println("Nhập điểm kết quả thi: ");
        this.testScore = Double.parseDouble(new Scanner(System.in).nextLine());
    }

    public String showTranscript() {
        StringBuilder builder = new StringBuilder();

        return builder.toString();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject[] getSubject() {
        return subject;
    }

    public void setSubject(Subject[] subject) {
        this.subject = subject;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }
}
