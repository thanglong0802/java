package pointmanagement.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
    private Student student;
    private TranscriptDetails transcript[];

    public Transcript(Student student, TranscriptDetails[] transcript) {
        this.student = student;
        this.transcript = transcript;
    }

    public Transcript() {
    }

    @Override
    public String toString() {
        return "TranscriptDetails{" +
                "student=" + student +
                ", transcript=" + Arrays.toString(transcript) +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TranscriptDetails[] getTranscript() {
        return transcript;
    }

    public void setTranscript(TranscriptDetails[] transcript) {
        this.transcript = transcript;
    }
}
