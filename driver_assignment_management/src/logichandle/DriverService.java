package logichandle;

import entity.Driver;
import file.FileUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static List<Driver> DRIVER = new ArrayList<>();

    public static void inputNewDriver() {
        System.out.println("Nhập số lượng lái xe mới: ");
        int newDriver = -1;
        do {
            try {
                newDriver = Integer.parseInt(new Scanner(System.in).nextLine());
                if (newDriver > 0) {
                    break;
                } else {
                    System.out.println("Nhập số nguyên");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không đúng định dạng, mời nhập số!");
            }
        } while (true);
        for (int i = 0; i < newDriver; i++) {
            System.out.println("Nhập lái xe thứ " + (i + 1) + " : ");
            Driver driver = new Driver();
            driver.inputInfo();
            DRIVER.add(driver);
            FileUtil.writeFile(Collections.singletonList(DRIVER), "driver_assignment_management/src/file/driver.dat");
        }
        System.out.println("Thêm thành công");

    }

    public static void showDriver() {
        for (int i = 0; i < DRIVER.size(); i++) {
            if (DRIVER.get(i) == null) {
                continue;
            }
            System.out.println(DRIVER.get(i));
        }
    }

    public static Driver searchDriverByID(int id) {
        for (int i = 0; i < DRIVER.size(); i++) {
            if (DRIVER.get(i) != null) {
                if (DRIVER.get(i).getId() == id) {
                    return DRIVER.get(i);
                }
            }
        }
        return null;
    }
}
