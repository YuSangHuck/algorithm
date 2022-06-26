//https://cote.inflearn.com/contest/10/problem/02-12
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0212_mentoring {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
//                (i,j) 학생에 대해서 i,j학생의 등수를 구해야 함
                int cnt = 0;
                int rankI = 0;
                int rankJ = 0;
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) {
                            rankI = l;
                        }
                        if (arr[k][l] == j) {
                            rankJ = l;
                        }
                    }
                    if (rankI > rankJ) {
                        cnt++;
                    }
                }
                if (cnt == m) {
//                    System.out.println(String.format("(%d,%d)", i, j));
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0212_mentoring T = new _0212_mentoring();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0212_mentoring_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt(); // 학생수
        int m = kb.nextInt(); // 시험수
        int[][] arr = new int[m][n]; // 시험등수, m번째 시험의 n등수인 학생번호. arr[0][0]은 0번째시험 0등인 학생번호
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, m, arr));
    }
}
