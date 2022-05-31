package stringhandling;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai6 {
    public static void main(String[] args) {
        System.out.println("Nhập một câu không quá 20, mỗi từ không quá 10 ký tự: ");
        String s = new Scanner(System.in).nextLine();
        sort(s);
    }

    public static void sort(String s) {
        String s1 = new String();
        StringTokenizer tokenizer = new StringTokenizer(s);
        int n = tokenizer.countTokens();
        String arr[] = new String[n];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            arr[i] = tokenizer.nextToken();
            i++;
        }
        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (arr[j].compareTo(arr[k]) > 0) {
                    s1 = arr[j];
                    arr[j] = arr[k];
                    arr[k] = s1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
