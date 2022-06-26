//https://cote.inflearn.com/contest/10/problem/01-10
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0110_charDistance {
    private int[] charDistance(String str, char c) {
        int[] answer = new int[str.length()];

        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(p, answer[i]);
            }
        }

        return answer;
    }

    public int[] solution(String str, char c) {
        return charDistance(str, c);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0110_charDistance T = new _0110_charDistance();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for (int i : T.solution(str, c)) {
            System.out.print(i+" ");
        }
    }
}
