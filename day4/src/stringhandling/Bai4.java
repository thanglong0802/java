package stringhandling;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai4 {
    public static void main(String[] args) {
        System.out.println("Nhập xâu bất kỳ: ");
        String s = new Scanner(System.in).nextLine();
        String arr[] = new String[50];
        int max = 1;
        int n = 0;
        StringTokenizer tokenizer = new StringTokenizer(s);
        while (tokenizer.hasMoreTokens()) {
            arr[n] = tokenizer.nextToken();
            n++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        System.out.println("Từ dài nhất trong xâu: " + max);
        System.out.println("Vị trí của từ đó trong xâu là: ");
        for (int i = 0; i < n; i++) {
            if (arr[i].length() == max) {
                System.out.print(" " + i);
            }
        }
    }

}
