//https://cote.inflearn.com/contest/10/problem/04-03
package huck.자바_알고리즘_문제풀이.hashMap_treeSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//public class Main {
public class _0403_kindsOfSales {

    public String solution(int n, int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);

            sb.append(hm.size());
            sb.append(" ");

            hm.put(arr[lt], hm.get(arr[lt]) - 1);
            if (hm.get(arr[lt]) == 0) {
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0403_kindsOfSales T = new _0403_kindsOfSales();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/hashMap_treeSet/_0403_kindsOfSales_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
