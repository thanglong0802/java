package stringhandling;

public class Bai1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100000; i <= 999999; i++) {
            if (kiemTraThuanNghich(i))
            System.out.println(i);
            count++;
        }
        System.out.println("Tổng các số đối xứng: " + count);
    }

    public static boolean kiemTraThuanNghich(int n) {
        String intString = String.valueOf(n);
        int size = intString.length();
        for (int i = 0; i <= (size / 2); i++) {
            if (intString.charAt(i) != intString.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
