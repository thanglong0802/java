package entity;

import itf.InputITF;

public class Router extends Roster implements InputITF {
    private int id;
    private float distance;
    private int stopPoint;

    private static int AUTO_ID = -1;

    public Router() {
        if (AUTO_ID == -1) {
            AUTO_ID = 100;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập khoảng cách: ");
        this.distance = nhapFloat();
        System.out.println("Nhập số điểm dừng: ");
        this.stopPoint = nhapInt();
    }

    @Override
    public String toString() {
        return "Router{" +
                "id=" + id +
                ", distance=" + distance +
                ", stopPoint=" + stopPoint +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(int stopPoint) {
        this.stopPoint = stopPoint;
    }
}
