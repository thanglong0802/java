package stringhandling;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai3 {
    public static void main(String[] args) {
        System.out.println("Nhập xâu để thực hiện chuẩn hóa: ");
        String s = new Scanner(System.in).nextLine();
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(s);
        while (tokenizer.hasMoreTokens()) {
            String s2 = tokenizer.nextToken();
            s2 = s2.toLowerCase();
            String s3 = s2.substring(0, 1);
            s2 = s2.replaceFirst(s3, s3.toUpperCase());
            result.append(s2).append(" ");

        }
        System.out.println("Xâu sau khi chuẩn hóa: " + result);
    }
}
