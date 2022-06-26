//https://cote.inflearn.com/contest/10/problem/01-01
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0101_findChar {

    public int findChar1(String s, char c) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ret++;
            }
        }
        return ret;
    }
    public int findChar2(String s, char c) {
        int ret = 0;
        char[] chars = s.toCharArray();
        for (char _c : chars) {
            if (_c == c) {
                ret++;
            }
        }
        return ret;
    }

    public int solution(String str, char t) {
        int answer;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

//        answer = findChar1(str, t);
        answer = findChar2(str, t);

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0101_findChar T = new _0101_findChar();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
