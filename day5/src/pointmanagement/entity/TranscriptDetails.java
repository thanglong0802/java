package pointmanagement.entity;

import java.io.Serializable;

public class TranscriptDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private Subject subject;
    private double score;

    @Override
    public String toString() {
        return "Transcript{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
