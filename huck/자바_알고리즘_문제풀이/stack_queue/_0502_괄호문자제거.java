//https://cote.inflearn.com/contest/10/problem/05-02
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class _0502_괄호문자제거 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                while (stack.pop() != '(') ;
            }
        }
        for (Character c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0502_괄호문자제거 T = new _0502_괄호문자제거();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/stack_queue/_0502_괄호문자제거_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.solution(s));
    }
}
