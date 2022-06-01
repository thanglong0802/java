package pointmanagement.entity;

public class Student extends Person {
    private int id;

    private static int AUTO_ID = -1;

    public Student() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    @Override
    public void inputPersonInfo() {
        super.inputPersonInfo();
    }

    @Override
    public String showPersonInfo() {
        return "Mã sinh viên: " + getId() + super.showPersonInfo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
