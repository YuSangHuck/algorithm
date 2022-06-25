//https://cote.inflearn.com/contest/10/problem/03-06
package huck.자바_알고리즘_문제풀이.twoPointer_slidingWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0306_maxLengthContinuousSequence {

    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int lt = 0;
        int changeCnt = 0;
        for (int rt = 0; rt < n; rt++) {
//            1. rt기반 0체크. 참이면 changeCnt++
//            2. changeCnt > k인지 체크. 참이면 answer에 max(answer, rt - lt)
//            1. changeCnt > k면 무한루프
//                1. lt기반 0체크. 참이면 changeCnt--
//                2. lt++
            if (arr[rt] == 0) {
                changeCnt++;
            }
            if (changeCnt > k) {
                answer = Math.max(answer, rt - lt);
            }
            while (changeCnt > k) {
                if (arr[lt] == 0) {
                    changeCnt--;
                }
                lt++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0306_maxLengthContinuousSequence T = new _0306_maxLengthContinuousSequence();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/twoPointer_slidingWindow/_0306_maxLengthContinuousSequence_input.txt");

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
