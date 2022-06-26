//https://cote.inflearn.com/contest/10/problem/02-03
package huck.자바_알고리즘_문제풀이.array;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0203_rockSissorPaper {

    public String solution(int n, int[] a, int[] b) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer.append("D\n");
            } else if ((a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)) {
                answer.append("A\n");
            } else {
                answer.append("B\n");
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0203_rockSissorPaper T = new _0203_rockSissorPaper();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, a, b));
    }
}
