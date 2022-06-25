//https://cote.inflearn.com/contest/10/problem/04-04
package huck.자바_알고리즘_문제풀이.hashMap_treeSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0405_kthMax {

    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    int sum = arr[i] + arr[j] + arr[l];
                    ts.add(sum);
                }
            }
        }


        int cnt = 0;
        for (Integer t : ts) {
            cnt++;
            if (cnt == k) {
                answer = t;
            }

        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0405_kthMax T = new _0405_kthMax();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/hashMap_treeSet/_0405_kthMax_input.txt");

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
