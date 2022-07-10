//https://cote.inflearn.com/contest/10/problem/10-03
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _1003_LIS_최대부분증가수열 {
    private void solution(int n, int[] arr) {
//        dy[i]는 arr[i]를 끝으로하는 부분수열의 최대길이
        int answer = 0;
        int[] dy = new int[n];
        dy[0] = 1;
        for (int i = 1; i < n; i++) { // dy값 셋팅
            int max = 0;
            for (int j = i - 1; j >= 0; j--) { // arr[i] > arr[j] && dy[j] > max 일때 max 업데이트
                if (arr[i] > arr[j]) { // arr이 증가하는 경우
                    if (max < dy[j]) {
                        max = dy[j];
                    }
                }

            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1003_LIS_최대부분증가수열 T = new _1003_LIS_최대부분증가수열();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dynamic/_1003_LIS_최대부분증가수열.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.solution(n, arr);

    }
}
