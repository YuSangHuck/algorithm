//https://cote.inflearn.com/contest/10/problem/09-01
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0901_씨름선수 {

    private int count = 0;

    private void solution(int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            int[] candidate = arr[i];
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (arr[j][0] > candidate[0] && arr[j][1] > candidate[1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0901_씨름선수 T = new _0901_씨름선수();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0901_씨름선수.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }

        T.solution(n, arr);

    }
}
