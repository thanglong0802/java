package entity;

import java.io.Serializable;

public class RosterDetails implements Serializable {
    private Router router;
    private int turns;

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
