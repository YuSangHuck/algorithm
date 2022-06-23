//https://cote.inflearn.com/contest/10/problem/01-08
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0108_palindromeSpecific {
    public String palindromeSpecific(String str) {
        String ret = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equals(reverse)) {
            ret = "YES";
        }
        return ret;

    }

    public String solution(String str) {
        return palindromeSpecific(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0108_palindromeSpecific T = new _0108_palindromeSpecific();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
