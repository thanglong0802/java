package main;

import entity.Driver;
import entity.Router;

public class Main {
    public static void main(String[] args) {
        Router r1 = new Router();
        r1.inputRouter();
        System.out.println(r1.toString());
    }
}
