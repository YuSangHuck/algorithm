//https://cote.inflearn.com/contest/10/problem/03-03
package huck.자바_알고리즘_문제풀이.twoPointer_slidingWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _0303_maxSales {

    public int solution(int n, int k, int[] arr) {
        int answer = 0;

        for (int i = 0; i < k; i++) {
            answer += arr[i];
        }

        int tmp = answer;
        for (int i = k; i < n; i++) {
            tmp += arr[i] - arr[i - k];
            answer = Math.max(answer, tmp);
        }
        return answer;
    }


    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0303_maxSales T = new _0303_maxSales();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/twoPointer_slidingWindow/_0303_maxSales_input.txt");

//        Scanner kb = new Scanner(System.in);
        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
