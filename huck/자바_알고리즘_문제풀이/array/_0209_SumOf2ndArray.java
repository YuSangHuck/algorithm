//https://cote.inflearn.com/contest/10/problem/02-09
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0209_SumOf2ndArray {

    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
//        행,열
        for (int i = 0; i < n; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            answer = Math.max(rowSum, answer);
            answer = Math.max(colSum, answer);
        }
//        대각선
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[n - i - 1][n - i - 1];
        }
        answer = Math.max(sum1, answer);
        answer = Math.max(sum2, answer);

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0209_SumOf2ndArray T = new _0209_SumOf2ndArray();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0209_SumOf2ndArray_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
