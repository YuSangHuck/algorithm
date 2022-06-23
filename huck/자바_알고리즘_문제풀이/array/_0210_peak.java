//https://cote.inflearn.com/contest/10/problem/02-10
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0210_peak {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 1; i < n + 2; i++) {
            for (int j = 1; j < n + 2; j++) {
                if (arr[i][j] > arr[i - 1][j] &&
                        arr[i][j] > arr[i + 1][j] &&
                        arr[i][j] > arr[i][j - 1] &&
                        arr[i][j] > arr[i][j + 1]) {
                    answer++;

                }

            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0210_peak T = new _0210_peak();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0210_peak_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[][] arr = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
