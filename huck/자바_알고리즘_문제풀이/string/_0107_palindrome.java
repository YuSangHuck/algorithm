//https://cote.inflearn.com/contest/10/problem/01-07
package huck.자바_알고리즘_문제풀이.string;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0107_palindrome {
    // 1. 직접 비교
    public String palindrome1(String str) {
        String ret = "YES";
        str = str.toLowerCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) return "NO";
        }
        return ret;
    }
    // 2. builder
    public String palindrome2(String str) {
        String ret = "NO";
        str = str.toLowerCase();
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equals(reverse)) {
            return "YES";
        }
        return ret;
    }

    public String solution(String str) {
        return palindrome1(str);
//        return palindrome2(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0107_palindrome T = new _0107_palindrome();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
