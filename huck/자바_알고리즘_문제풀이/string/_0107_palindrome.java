//https://cote.inflearn.com/contest/10/problem/01-07
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0107_palindrome {
    // 1. 직접 비교
    public static String palindrome1(String str) { // 길이가 길어질수록 이게 더 효율적이겠지
        String ret = "YES";
        str = str.toLowerCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return "NO";
            }
        }
        return ret;
    }

    // 2. builder
    public static String palindrome2(String str) {
        String ret = "NO";
        str = str.toLowerCase();
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equals(reverse)) {
            return "YES";
        }
        return ret;
    }

    public static String solution(String str) {
        return palindrome1(str);
//        return palindrome2(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    }
}
