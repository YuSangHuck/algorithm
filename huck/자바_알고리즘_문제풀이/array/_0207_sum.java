//https://cote.inflearn.com/contest/10/problem/02-07
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0207_sum {

    public int solution(int n, int[] arr) {
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                sum += cnt;
            } else {
                cnt = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0207_sum T = new _0207_sum();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0207_sum_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
