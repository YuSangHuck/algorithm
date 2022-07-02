//https://cote.inflearn.com/contest/10/problem/05-06
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class _0506_공주구하기 {


    private int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0506_공주구하기 T = new _0506_공주구하기();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/stack_queue/_0506_공주구하기_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(T.solution(n, k));
    }
}
