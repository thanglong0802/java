package pointmanagement.entity;

public class GPA {
    private Student student;
    private Transcript transcript[];

    public GPA(Student student, Transcript[] transcript) {
        this.student = student;
        this.transcript = transcript;
    }

    public GPA() {

    }

    public String showGPA() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sinh viên: ").append(getStudent()).
                append(", bảng điểm: ").append(getTranscript());
        return builder.toString();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Transcript[] getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript[] transcript) {
        this.transcript = transcript;
    }
}
