package entity;

import java.util.List;
import java.util.Scanner;

public class Roster {
    private Driver driver;
    private List<RosterDetails> details;

    @Override
    public String toString() {
        return "Roster{" +
                "driver=" + driver +
                ", details=" + details +
                '}';
    }

    public static int nhapInt() {
        int result = 0;
        try {
            result = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Không thể nhập chữ, xin mời nhập số: ");
            nhapInt();
        }
        return result;
    }

    public static float nhapFloat() {
        float result = 0;
        try {
            result = Float.parseFloat(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Không thể nhập chữ, xin mời nhập số: ");
            nhapFloat();
        }
        return result;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<RosterDetails> getDetails() {
        return details;
    }

    public void setDetails(List<RosterDetails> details) {
        this.details = details;
    }
}
