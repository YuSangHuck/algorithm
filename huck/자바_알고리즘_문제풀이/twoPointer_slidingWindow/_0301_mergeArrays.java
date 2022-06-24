//https://cote.inflearn.com/contest/10/problem/03-01
package huck.자바_알고리즘_문제풀이.twoPointer_slidingWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _0301_mergeArrays {

    public String solution(int n, int m, int[] arr1, int[] arr2) {
//        오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
        ArrayList<Integer> answer = new ArrayList<>();

        int p1 = 0; // n-1까지
        int p2 = 0; // m-1까지

        while (p1 < n && p2 < m) {
            if (arr1[p1] > arr2[p2]) {
                answer.add(arr2[p2++]);
            } else {
                answer.add(arr1[p1++]);
            }
        }
        while (p1 < n) {
            answer.add(arr1[p1++]);
        }
        while (p2 < m) {
            answer.add(arr2[p2++]);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : answer) {
            sb.append(integer);
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0301_mergeArrays T = new _0301_mergeArrays();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/twoPointer_slidingWindow/_0301_mergeArrays_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt(); // 학생수
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        int m = kb.nextInt(); // 학생수
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr1, arr2));
    }
}
