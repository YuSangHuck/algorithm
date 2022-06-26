//https://cote.inflearn.com/contest/10/problem/01-12
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0112_passToSentence {

    public String passToSentence(int n, String str) {
        StringBuilder answer = new StringBuilder();
//        1. 7씩 자르기
//        2. 7개 -> 이진수 -> 10진수 -> 문자
//        3. String.Valueof(문자List)
        for (int i = 0; i < n; i++) {
            String bin = str.substring(7 * i, 7 * (1 + i))
                    .replace('*', '0').replace('#', '1');
            int dec = Integer.parseInt(bin, 2);

            answer.append((char) dec);
        }
        return answer.toString();
    }

    public String solution(int n, String str) {
        return passToSentence(n, str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0112_passToSentence T = new _0112_passToSentence();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }
}
