package stringhandling;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        System.out.println("Nhập một chuỗi bất kỳ: ");
        String s = new Scanner(System.in).nextLine();
        String swap = " ";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                swap += s.substring(i, i + 1).toLowerCase();
            } else {
                swap += s.substring(i, i + 1).toUpperCase();
            }
        }
        System.out.println("Xâu khi chuyển đổi:" + swap);
    }

}
