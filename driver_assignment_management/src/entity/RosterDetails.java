package entity;

public class RosterDetails implements inputITF{
    private Router router;
    private int turns;

    @Override
    public void inputInfo() {
        System.out.println("Nhập số lượt lái xe: ");
        do {
            turns = Roster.nhapInt();
            if (turns > 0 && turns < 16) {
                break;
            } else {
                System.out.println("Số lượt của mỗi người lái xe không thể vượt quá 15");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "RosterDetails{" +
                "router=" + router +
                ", turns=" + turns +
                '}';
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

}
