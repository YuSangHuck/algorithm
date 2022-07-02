//https://cote.inflearn.com/contest/10/problem/06-01
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0601_선택정렬 {
    private String solution(int n, int[] arr) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = 1 + i; j < n; j++) {
//                i 이후의 최소값의 인덱스
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
//            i랑 i 이후의 최소값이랑 swap
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        for (int i : arr) {
            answer.append(i);
            answer.append(" ");
        }

        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0601_선택정렬 T = new _0601_선택정렬();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0601_선택정렬_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n= kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
