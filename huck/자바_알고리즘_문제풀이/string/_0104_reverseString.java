//https://cote.inflearn.com/contest/10/problem/01-04
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0104_reverseString {

    public static String solution(int n, String[] strList) {
        StringBuilder answer = new StringBuilder();

        for (String s : strList) {
            answer.append(new StringBuilder(s).reverse()).append('\n');
        }

        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/string/_0104_reverseString.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        String[] strList = new String[n];
        for (int i = 0; i < n; i++) {
            strList[i] = kb.next();
        }

        System.out.println(solution(n, strList));
    }
}
