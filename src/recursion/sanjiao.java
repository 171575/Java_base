package recursion;

/**
 * sanjiao
 * @author chen
 * @date 2023/5/8 16:27
 * @version 1.0
 */
public class sanjiao {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.printf("%" + 2 * (n - 1 - i) + "s", " ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }
    public static int element(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        return element(i - 1, j - 1) + element(i - 1, j);
    }
}
 