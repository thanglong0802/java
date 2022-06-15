package entity;

import java.util.List;

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
