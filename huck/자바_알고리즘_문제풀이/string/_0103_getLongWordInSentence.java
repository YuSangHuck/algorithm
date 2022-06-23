//https://cote.inflearn.com/contest/10/problem/01-03
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _0103_getLongWordInSentence {


    public String getLongWordInSentence1(String sentence) {
        String ret = "";
        int min = Integer.MIN_VALUE;
        String[] sList = sentence.split(" ");
        for (String s : sList) {
            int len = s.length();
            if (len > min) {
                min = len;
                ret = s;
            }
        }
        return ret;
    }

    private String getLongWordInSentence2(String sentence) {
        String ret = "";
        int min = Integer.MIN_VALUE, pos;

        while ((pos = sentence.indexOf(' ')) != -1) {
            String substring = sentence.substring(0, pos);
            int length = substring.length();
            if (length > min) {
                min = length;
                ret = substring;
            }
            sentence = sentence.substring(1 + pos);
        }
        if (sentence.length() > min) {
            ret = sentence;
        }

        return ret;
    }

    public String solution(String str) {
        String answer = "";

        answer = getLongWordInSentence1(str);
        answer = getLongWordInSentence2(str);


        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0103_getLongWordInSentence T = new _0103_getLongWordInSentence();
        FileInputStream fileInputStream = new FileInputStream("./input.txt");

        Scanner kb = new Scanner(fileInputStream);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }
}
