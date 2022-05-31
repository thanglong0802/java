package stringhandling;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        String s1 = new String();
        String s2 = new String();
        System.out.println("Nhập xâu s1: ");
        s1 = new Scanner(System.in).nextLine();
        System.out.println("Nhập xâu s2: ");
        s2 = new Scanner(System.in).nextLine();
        int size = s2.length();
        System.out.println("Độ dài của s2 = " + size);
        String s3 = new String();
        String check = new String();

        System.out.println("Vị trí của s2 trong s1 là: ");
        for (int i = 0; i < s1.length() - size + 1; i++) {
            check = s1.substring(i, i + size);
            if (check.equals(s2)) {
                System.out.println(i);
            }
        }
        s1 = s1.replaceAll(s2, s3);
        System.out.println("Xâu s1 sau khi loại bỏ s2 là: " + s1);
    }
}
