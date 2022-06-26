//https://cote.inflearn.com/contest/10/problem/01-11
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0111_compressString {
    private String compressString(String str) {
        StringBuilder answer = new StringBuilder();
        str = str + " ";

        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(1 + i)) {
                cnt++;
            } else {
                answer.append(str.charAt(i));
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            }

        }

        return answer.toString();
    }

    public String solution(String str) {
        return compressString(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0111_compressString T = new _0111_compressString();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
