//https://cote.inflearn.com/contest/10/problem/03-04
package huck.자바_알고리즘_문제풀이.twoPointer_slidingWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0304_continuousPartialSequence {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0304_continuousPartialSequence T = new _0304_continuousPartialSequence();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/twoPointer_slidingWindow/_0304_continuousPartialSequence_input.txt");

//        Scanner kb = new Scanner(System.in);
        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
