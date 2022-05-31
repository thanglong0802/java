package stringhandling;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai5 {
    public static void main(String[] args) {
        System.out.println("Nhập họ tên: ");
        String s = new Scanner(System.in).nextLine();
        swap(s);
    }

    public static void swap(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        StringBuffer result = new StringBuffer();
        String arr[] = new String[50];
        int i = 1;
        while (tokenizer.hasMoreTokens()) {
            arr[i] = tokenizer.nextToken();
            i++;
        }
        result.append(arr[3]).append(" ").append(arr[1]).append(" ").append(arr[2]).append(" ");
        System.out.println(result);
    }
}
