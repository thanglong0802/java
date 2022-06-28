package logichandle;

import entity.Router;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RouterService {
    public static List<Router> ROUTER = new ArrayList<>();

    public static void inputNewRouter() {
        System.out.println("Nhập số lượng tuyến: ");
        int newRouter = -1;
        do {
            try {
                newRouter = Integer.parseInt(new Scanner(System.in).nextLine());
                if (newRouter > 0) {
                    break;
                } else {
                    System.out.println("Nhập số nguyên");
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng không đúng, mời nhập số!");
            }
        } while (true);
        for (int i = 0; i < newRouter; i++) {
            System.out.println("Nhập tuyến thứ " + (i + 1) + " : ");
            Router router = new Router();
            router.inputInfo();
            ROUTER.add(router);
        }
        System.out.println("Thêm thành công");
    }

    public static void showRouter() {
        for (int i = 0; i < ROUTER.size(); i++) {
            if (ROUTER.get(i) != null) {
                System.out.println(ROUTER.get(i));
            }
        }
    }

    public static Router searchRouterByID(int id) {
        for (int i = 0; i < ROUTER.size(); i++) {
            if (ROUTER.get(i) != null) {
                if (ROUTER.get(i).getId() == id) {
                    return ROUTER.get(i);
                }
            }
        }
        return null;
    }

}
