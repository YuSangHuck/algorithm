package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _7568_덩치 {

    private static String solution(int n, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] a : arr) {
            int count = 0;
            for (int[] b : arr) {
                if (a[0] < b[0] && a[1] < b[1]) {
                    count++;
                }
            }
            sb.append(count + 1).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_7568_덩치.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        System.out.println(solution(n, arr));
    }
}
