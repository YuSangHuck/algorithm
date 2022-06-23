//https://cote.inflearn.com/contest/10/problem/02-06
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _0206_reversePrime {

    private boolean isPrime(int res) {
        if (res == 1) {
            return false;
        }
        for (int i = 2; i < res; i++) {
            if (res % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) answer.add(res);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : answer) {
            sb.append(integer);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0206_reversePrime T = new _0206_reversePrime();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0206_reversePrime_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
