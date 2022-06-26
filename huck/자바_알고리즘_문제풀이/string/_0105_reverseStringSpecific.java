//https://cote.inflearn.com/contest/10/problem/01-05
package huck.자바_알고리즘_문제풀이.string;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0105_reverseStringSpecific {
    public String reverseStringSpecific(String str) {
        char[] cList = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(cList[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(cList[rt])) {
                rt--;
            } else {
                char tmp = cList[lt];
                cList[lt] = cList[rt];
                cList[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(cList);
    }


    public String solution(String str) {
        return reverseStringSpecific(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0105_reverseStringSpecific T = new _0105_reverseStringSpecific();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
