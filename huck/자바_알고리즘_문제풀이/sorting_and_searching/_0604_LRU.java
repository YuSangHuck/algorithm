//https://cote.inflearn.com/contest/10/problem/06-04
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0604_LRU {

    private String solution(int s, int n, int[] tasks) {
        StringBuilder answer = new StringBuilder();
        int[] cache = new int[s];
        for (int task : tasks) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (cache[i] == task) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
//                miss
                pos = s - 1;
            }
            if (pos >= 0) System.arraycopy(cache, 0, cache, 1, pos);
//            for (int i = pos; i >= 1; i--) {
//                cache[i] = cache[i - 1];
//            }
            cache[0] = task;
        }

        for (int integer : cache) {
            answer.append(integer);
            answer.append(" ");
        }
        return answer.toString();

    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0604_LRU T = new _0604_LRU();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0604_LRU_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt(); // cache size
        int n = kb.nextInt(); // task count
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = kb.nextInt();
        }
        System.out.println(T.solution(s, n, tasks));
    }
}
