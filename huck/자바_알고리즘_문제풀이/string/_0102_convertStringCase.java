//https://cote.inflearn.com/contest/10/problem/01-02
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0102_convertStringCase {
    public String convertStringCase2(String src) {
        StringBuilder dst = new StringBuilder();
        char[] chars = src.toCharArray();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                dst.append(Character.toLowerCase(c)); // c - ('a' - 'A')
            } else {
                dst.append(Character.toUpperCase(c)); // c + ('a' - 'A')
            }
        }
        return dst.toString();
    }

    public String solution(String str) {
        String answer;

        answer = convertStringCase2(str);

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0102_convertStringCase T = new _0102_convertStringCase();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/string/_0102_convertStringCase.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}
