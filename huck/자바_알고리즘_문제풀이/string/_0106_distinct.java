//https://cote.inflearn.com/contest/10/problem/01-06
package huck.자바_알고리즘_문제풀이.string;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0106_distinct {

    public String distinct(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                ret += str.charAt(i);
            }
        }
        return ret;
    }
    public String solution(String str) {
        return distinct(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0106_distinct T = new _0106_distinct();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
