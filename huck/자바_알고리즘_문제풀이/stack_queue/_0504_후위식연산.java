//https://cote.inflearn.com/contest/10/problem/05-04
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class _0504_후위식연산 {

    private int solution(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
//            System.out.println("c = " + c);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                Integer p2 = stack.pop();
                Integer p1 = stack.pop();
                if (c == '+') {
                    stack.push(p1 + p2);
                } else if (c == '-') {
                    stack.push(p1 - p2);
                } else if (c == '*') {
                    stack.push(p1 * p2);
                } else { // c == '/'
                    stack.push(p1 / p2);
                }
            }

        }
        return stack.peek();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0504_후위식연산 T = new _0504_후위식연산();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/stack_queue/_0504_후위식연산_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String postfix = kb.next();
        System.out.println(T.solution(postfix));
    }
}
