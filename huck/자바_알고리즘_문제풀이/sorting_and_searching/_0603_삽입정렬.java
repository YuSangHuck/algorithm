//https://cote.inflearn.com/contest/10/problem/06-03
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0603_삽입정렬 {
    private String solution(int n, int[] arr) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;

        }

        for (int i : arr) {
            answer.append(i);
            answer.append(" ");
        }

        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0603_삽입정렬 T = new _0603_삽입정렬();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0603_삽입정렬_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
