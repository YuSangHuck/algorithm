//https://cote.inflearn.com/contest/10/problem/02-01
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _0201_bigger {

    public ArrayList<Integer> bigger(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {

        return bigger(n, arr);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0201_bigger T = new _0201_bigger();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (Integer integer : T.solution(n, arr)) {
            System.out.print(integer + " ");
        }
    }
}
