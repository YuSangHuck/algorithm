//https://cote.inflearn.com/contest/10/problem/05-07
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class Main {
public class _0507_교육과정설계 {
    private String solution(String required, String plan) {
        Queue<Character> q = new LinkedList<>();
        for (char c : required.toCharArray()) {
            q.offer(c);
        }
//        NOTE 내 생각
//        loop required
//            각 required의 각 요소 pos를 example에서 첫번째로 만나는놈을 찾고, 역순이면 return "NO"

//        NOTE 강의
//        loop example
//            각 example이 required에 포함되어있으면, required[0]이랑 example이 일치하지 않으면 return "NO"
        for (char c : plan.toCharArray()) {
            if (q.contains(c)) {
                if (q.peek() != c) {
                    return "NO";
                } else {
                    q.poll();
                }
            }
        }
        if (!q.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0507_교육과정설계 T = new _0507_교육과정설계();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/stack_queue/_0507_교육과정설계_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String required = kb.next();
        String plan = kb.next(); // length <= 30
        System.out.println(T.solution(required, plan));
    }
}
