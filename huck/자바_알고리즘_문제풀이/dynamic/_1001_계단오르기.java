//https://cote.inflearn.com/contest/10/problem/10-01
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _1001_계단오르기 {
    private void solution(int n) {
        int[] dy = new int[n + 1];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        System.out.println(dy[n]);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1001_계단오르기 T = new _1001_계단오르기();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dynamic/_1001_계단오르기.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        T.solution(n);

    }
}
