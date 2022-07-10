//https://cote.inflearn.com/contest/10/problem/10-02
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _1002_돌다리건너기 {
    private void solution(int n) {
        int[] dy = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        System.out.println(dy[n + 1]);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1002_돌다리건너기 T = new _1002_돌다리건너기();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dynamic/_1002_돌다리건너기.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        T.solution(n);

    }
}
