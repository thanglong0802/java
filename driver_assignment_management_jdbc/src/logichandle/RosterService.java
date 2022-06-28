package logichandle;

import entity.Driver;
import entity.ESort;
import entity.Roster;
import entity.RosterDetails;
import main.Main;

import java.util.*;

public class RosterService {

    public static void inputAssignmentList () {
        if (!checkData()) {
            System.out.println("Chưa có dữ liệu lái xe và tuyến");
            return;
        }
        System.out.println("Nhập mã lái xe cần thêm tuyến: ");
        int driverID;
        do {
            try {
                driverID = Integer.parseInt(new Scanner(System.in).nextLine());
                if (DriverService.searchDriverByID(driverID) != null) {
                    break;
                } else {
                    System.out.println("Mã lái xe không tồn tại hoặc đã bị trùng, vui lòng nhập lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã lái xe là số nguyên và có 5 chữ số");
            }
        } while (true);

        System.out.println("Nhập số lượng tuyến: ");
        int n;
        do {
            try {
                n = Integer.parseInt(new Scanner(System.in).nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Số lượng tuyến tối thiểu là 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng không đúng, mời nhập số");
            }
        } while (true);

        List<RosterDetails> list = new ArrayList<>();
        int routerID;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập mã số tuyến thứ " + (i + 1) + " : ");
            do {
                try {
                    routerID = Integer.parseInt(new Scanner(System.in).nextLine());
                    if (RouterService.searchRouterByID(routerID) != null && !checkRouterID(list, routerID)) {
                        break;
                    } else {
                        System.out.println("Mã số tuyến không tồn tại hoặc đã bị trùng, mời nhập lại");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Mã số tuyến là số nguyên và có 3 chữ số");
                }
            } while (true);

            int turn;
            System.out.println("Nhập số lượt thứ " + (i + 1) + " : ");
            do {
                try {
                    turn = Integer.parseInt(new Scanner(System.in).nextLine());
                    if (turn > 0 && turn < 16) {
                        break;
                    } else {
                        System.out.println("Số lượt của 1 lái xe không vượt quá 15");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Định dạng không đúng, mời nhập số");
                }
            } while (true);

            RosterDetails roster = new RosterDetails();
            roster.setRouter(RouterService.searchRouterByID(routerID));
            roster.setTurns(turn);
            list.add(roster);
        }
        Roster r1 = new Roster();
        r1.setDriver(DriverService.searchDriverByID(driverID));
        r1.setDetails(list);
        Main.ROSTER.add(r1);
    }

    public static boolean checkData() {
        boolean checkDriverDat = false;
        boolean checkRouterDat = false;

        for (int i = 0; i < DriverService.DRIVER.size(); i++) {
            if (DriverService.DRIVER.get(i) != null) {
                checkDriverDat = true;
                break;
            }
        }
        for (int i = 0; i < RouterService.ROUTER.size(); i++) {
            if (RouterService.ROUTER.get(i) != null) {
                checkRouterDat = true;
                break;
            }
        }
        return checkDriverDat && checkRouterDat;
    }

    public static boolean checkRouterID(List<RosterDetails> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).getRouter().getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void showAllTurns() {
        for (int i = 0; i < Main.ROSTER.size(); i++) {
            if (Main.ROSTER.get(i) == null) {
                continue;
            }
            System.out.println(Main.ROSTER.get(i));
        }
    }

    public static void sortByName(ESort eSort) {
        Collections.sort(DriverService.DRIVER, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                if (ESort.TANG_DAN == eSort) {
                    return d1.getFullName().compareTo(d2.getFullName());
                } else {
                    return d2.getFullName().compareTo(d1.getFullName());
                }
            }
        });
        System.out.println("Danh sách vừa sắp xếp theo tên lái xe là: ");
        DriverService.showDriver();
    }

}
