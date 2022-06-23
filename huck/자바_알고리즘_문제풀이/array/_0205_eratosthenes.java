//https://cote.inflearn.com/contest/10/problem/02-05
package huck.자바_알고리즘_문제풀이.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0205_eratosthenes {

    public int solution(int n) {
        int answer = 0;
        int[] check = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if (check[i] == 0) {
                answer++;
                for (int j = 0; j < n + 1; j = j + i) {
                    check[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0205_eratosthenes T = new _0205_eratosthenes();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/array/_0205_eratosthenes_input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
