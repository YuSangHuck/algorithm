//https://cote.inflearn.com/contest/10/problem/01-09
package huck.자바_알고리즘_문제풀이.string;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0109_extractNumber {
    private static int extractNumber1(String str) {
        int ret = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                ret = ret * 10 + (c - '0');
            }
        }
        return ret;
    }
    private static int extractNumber2(String str) {
        return Integer.parseInt(str.replaceAll("[^\\d]", ""));
    }

    public static int solution(String str) {
        return extractNumber1(str);
//        return extractNumber2(str);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
    }
}
