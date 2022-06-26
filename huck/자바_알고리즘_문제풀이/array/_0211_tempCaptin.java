//https://cote.inflearn.com/contest/10/problem/02-11
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0211_tempCaptin {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) { // arr[a][b]는 a번학생이 b학년일때의 반
                        cnt++;
                        break;
                    }
                }
                if (cnt > max) {
                    max = cnt;
                    answer = i;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0211_tempCaptin T = new _0211_tempCaptin();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0211_tempCaptin_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
