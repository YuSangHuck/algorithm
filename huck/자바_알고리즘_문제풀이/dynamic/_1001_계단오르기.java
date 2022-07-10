//https://cote.inflearn.com/contest/10/problem/10-01
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _1001_계단오르기 {
    private void solution(int n) {
//        한번에 1계단 or 2계단
//        3번째계단을 올라오는건 2 -> 3 or 1 -> 3밖에 없다
//        n번째계단을 올라오는건 n-1 -> n or n-2 -> n밖에 없다
//        arr[n] = arr[n-1] + arr[n-2]
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[n]);
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
