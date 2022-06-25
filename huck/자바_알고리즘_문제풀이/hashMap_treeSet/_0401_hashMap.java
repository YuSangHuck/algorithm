//https://cote.inflearn.com/contest/10/problem/04-01
package huck.자바_알고리즘_문제풀이.hashMap_treeSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

//public class Main {
public class _0401_hashMap {

    public Character solution(int n, String s) {
        char answer = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (Character c : m.keySet()) {
            Integer integer = m.get(c);
            if (integer > max) {
                max = integer;
                answer = c;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0401_hashMap T = new _0401_hashMap();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/hashMap_treeSet/_0401_hashMap_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String s = kb.next();
        System.out.println(T.solution(n, s));
    }
}
