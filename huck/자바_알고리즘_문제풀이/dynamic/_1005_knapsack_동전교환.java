//https://cote.inflearn.com/contest/10/problem/10-05
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _1005_knapsack_동전교환 {
    private void solution(int n, int[] arr, int m) {
        Arrays.sort(arr);

        int answer = 0;
        int change = m;
        for (int i = n - 1; i >= 0; i--) {
            if (change >= arr[i]) {
                answer += change / arr[i];
                change = change % arr[i];
                if (change == 0) {
                    break;
                }
            }
        }

        System.out.println(answer);

    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1005_knapsack_동전교환 T = new _1005_knapsack_동전교환();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dynamic/_1005_knapsack_동전교환.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        T.solution(n, arr, m);

    }
}
