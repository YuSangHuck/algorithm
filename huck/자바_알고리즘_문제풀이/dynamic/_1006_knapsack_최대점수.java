//https://cote.inflearn.com/contest/10/problem/10-06
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _1006_knapsack_최대점수 {

    private void solution(int n, int m, int[][] arr) {
//        강의 전 생각해본것
//        dy[i]는 i의 시간일때 얻을 수 있는 최대점수
//        arr를 시간 오름차순 정렬
//        dy[i]를 arr[0~i-1]로 업데이트

//        앞의 _1005와는 동전이 무한개였지만, 시험문제는 1번만 => dy의 초기값이 0 && j가 역순으로 돌면됨
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int[] v = arr[i];
            int s = v[0]; // 10
            int t = v[1]; // 5
            for (int j = m; j >= t; j--) {
                dy[j] = Math.max(dy[j], dy[j - t] + s);
            }
        }
        System.out.println(dy[m]);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1006_knapsack_최대점수 T = new _1006_knapsack_최대점수();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dynamic/_1006_knapsack_최대점수.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        T.solution(n, m, arr);

    }
}
