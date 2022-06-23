//https://cote.inflearn.com/contest/10/problem/02-02
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0202_biggerMax {

    public int solution(int n, int[] arr) {
        int max = arr[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                cnt++;
                max = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0202_biggerMax T = new _0202_biggerMax();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
