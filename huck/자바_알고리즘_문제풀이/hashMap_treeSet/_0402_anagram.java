//https://cote.inflearn.com/contest/10/problem/04-02
package huck.자바_알고리즘_문제풀이.hashMap_treeSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//public class Main {
public class _0402_anagram {

    public String solution(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s1.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            Integer cCount = hm.get(c);
            if (cCount == null || cCount == 0) {
                return "NO";
            }
            hm.put(c, cCount - 1);
        }

        return "YES";
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0402_anagram T = new _0402_anagram();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/hashMap_treeSet/_0402_anagram_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String s1 = kb.next();
        String s2 = kb.next();
        System.out.println(T.solution(s1, s2));
    }
}
