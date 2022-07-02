//https://cote.inflearn.com/contest/10/problem/05-07
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0508_응급실 {
    private int solution(int n, int m, Integer[] arr) {
//        1. 정렬 전 중복 카운트
        int v = arr[m];
        int cnt = 0;
        for (int i = 0; i <= m; i++) {
            if (arr[i] == v) {
                cnt++;
            }
        }
//        2. 정렬 후 앞에있는놈들 카운트
        Arrays.sort(arr, Collections.reverseOrder());
        for (Integer integer : arr) {
            if (integer > v) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0508_응급실 T = new _0508_응급실();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/stack_queue/_0508_응급실_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }

}
