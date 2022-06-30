//https://cote.inflearn.com/contest/10/problem/05-01
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class _0501_올바른_괄호 {
    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0501_올바른_괄호 T = new _0501_올바른_괄호();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/stack_queue/_0501_올바른_괄호_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.solution(s));
    }
}
