//https://cote.inflearn.com/contest/10/problem/02-08
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _0208_rank {

    public String solution(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : answer) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0208_rank T = new _0208_rank();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0208_rank_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
