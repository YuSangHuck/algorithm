//https://cote.inflearn.com/contest/10/problem/01-01
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0101_findChar {

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        char[] arr = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (arr[lt] == t) {
                answer++;
            }
            if (arr[rt] == t) {
                answer++;
            }

            lt++;
            rt--;
        }
        if (lt == rt && arr[lt] == t) {
            answer++;
        }


        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0101_findChar T = new _0101_findChar();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/string/_0101_findChar.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
