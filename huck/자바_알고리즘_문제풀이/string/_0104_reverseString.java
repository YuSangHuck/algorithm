//https://cote.inflearn.com/contest/10/problem/01-04
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _0104_reverseString {
    public String reverseString1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String reverseString2(String str) {
        char[] cList = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            char tmp = cList[lt];
            cList[lt] = cList[rt];
            cList[rt] = tmp;
            lt++;
            rt--;
        }
        return String.valueOf(cList);
    }

    public ArrayList<String> solution(String[] strList) {
        ArrayList<String> answer = new ArrayList<>();

        for (String s : strList) {
//            answer.add(reverseString1(s));
            answer.add(reverseString2(s));
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0104_reverseString T = new _0104_reverseString();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        String[] strList = new String[n];
        for (int i = 0; i < n; i++) {
            strList[i] = kb.next();
//            strList[i] = kb.nextLine();
        }

        for (String s : T.solution(strList)) {
            System.out.println(s);
        }
    }
}
