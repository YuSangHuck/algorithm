//https://cote.inflearn.com/contest/10/problem/03-02
package huck.자바_알고리즘_문제풀이.twoPointer_slidingWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _0302_commonElement {

    public String solution(int n, int m, int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        StringBuilder sb = new StringBuilder();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] > arr2[p2]) {
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                sb.append(arr1[p1]).append(" ");
                p1++;
                p2++;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0302_commonElement T = new _0302_commonElement();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/twoPointer_slidingWindow/_0302_commonElement_input.txt");

//        Scanner kb = new Scanner(System.in);
        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr1, arr2));
    }
}
