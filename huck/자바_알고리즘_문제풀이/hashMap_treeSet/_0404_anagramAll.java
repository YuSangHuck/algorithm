//https://cote.inflearn.com/contest/10/problem/04-04
package huck.자바_알고리즘_문제풀이.hashMap_treeSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//public class Main {
public class _0404_anagramAll {

    public int solution(String s, String t) {
        int answer = 0;

        HashMap<Character, Integer> hmOfT = new HashMap<>();
        for (char c : t.toCharArray()) {
            hmOfT.put(c, hmOfT.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> hmOfS = new HashMap<>();
        for (int i = 0; i < t.length() - 1; i++) {
            hmOfS.put(s.charAt(i), hmOfS.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            hmOfS.put(s.charAt(rt), hmOfS.getOrDefault(s.charAt(rt), 0) + 1);

            if (hmOfS.equals(hmOfT)) {
                answer++;
            }

            hmOfS.put(s.charAt(lt), hmOfS.get(s.charAt(lt)) - 1);
            if (hmOfS.get(s.charAt(lt)) == 0) {
                hmOfS.remove(s.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0404_anagramAll T = new _0404_anagramAll();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/hashMap_treeSet/_0404_anagramAll_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        String t = kb.next();
        System.out.println(T.solution(s, t));
    }
}
