//https://cote.inflearn.com/contest/10/problem/05-05
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class _0505_쇠막대기 {

    private int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
//                    레이저
                    answer += stack.size();
                } else {
//                    막대끝
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0505_쇠막대기 T = new _0505_쇠막대기();

        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/stack_queue/_0505_쇠막대기_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.solution(s));
    }
}
